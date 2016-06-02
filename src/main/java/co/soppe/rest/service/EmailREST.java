/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Tercero;
import co.soppe.jpa.sessions.TerceroFacade;
import co.soppe.models.RecoveryPassword;
import co.soppe.rest.auth.DigestUtil;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author adsi1
 */
@Path("email")
@Stateless
public class EmailREST {

    @EJB
    private TerceroFacade ejbTerceroFacade;

    @POST
    @Path("recoverypass")
    @Consumes(MediaType.APPLICATION_JSON)
    public void recoveryPass(RecoveryPassword recoveryPassword) {
        try {

            Tercero user = ejbTerceroFacade.findByEmail(recoveryPassword.getEmail());
            int x = (int) (Math.random() * 1000);

            String cd = null;
            try {
                cd = DigestUtil.generateDigest(String.valueOf(x));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                Logger.getLogger(Tercero.class.getName()).log(Level.SEVERE, null, ex);
            }

            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("soppecolombia@gmail.com", "Soppe904955"));
            email.setSSL(true);
            email.setFrom("services@soppe.com");
            email.setSubject("Restablecer Contraseña Soppe");
            email.setHtmlMsg("<div style=\"border-bottom:1px solid; text-align:center; background:#7B1FA2; display:inline-block; width:100%\"><img src=\"\" alt=\"Soppe\" style=\"width:5em; padding-top:1em\"><h1 style=\"margin:0; padding:0.5em 0.5em 0.5em 0; color:white; font-family:sans-serif; width:80%; display:inline-block; float:right; text-align:right\">Restablecer Contraseña</h1></div><div style=\"\">\n"
                    + "          <p style=\"padding-left:2em; margin:2em 0 2em 0; font-family:sans-serif\">Abra el siguiente enlace para continuar con el proceso de recuperación <a href=\"http://localhost:8001/#/passconfirm/" + user.getIdTerceros() + "/" + cd + "\">http://localhost:8001/#/passconfrm/" + user.getIdTerceros() + "/" + cd + "</a></p>\n"
                    + "      \n"
                    + "        </div>");
            
            email.addTo(recoveryPassword.getEmail());
            
            user.setCodigoRecuperacion(cd);
            ejbTerceroFacade.edit(user);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
