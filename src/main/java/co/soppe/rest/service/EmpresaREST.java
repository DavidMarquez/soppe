package co.soppe.rest.service;

import co.soppe.jpa.entities.Empresa;
import co.soppe.jpa.entities.Tercero;
import co.soppe.jpa.sessions.EmpresaFacade;
import co.soppe.rest.auth.AuthUtils;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1
 */
@Path("empresa")
public class EmpresaREST {
    
   @EJB
   private EmpresaFacade ejbEmpresaFacade;
   
   @Context
    private HttpServletRequest request;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Empresa empresa) {
        try{
            empresa.setIdTerceros(
                    new Tercero(
                            Integer.parseInt(
                                    AuthUtils.getSubject(
                                            request.getHeader(AuthUtils.AUTH_HEADER_KEY)))));
            ejbEmpresaFacade.create(empresa);
    } catch (ParseException | JOSEException ex){
         Logger.getLogger(EmpresaREST.class.getName()).log(Level.SEVERE, null, ex);
            }     
    }
    
    

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Empresa empresa) {
        ejbEmpresaFacade.edit(empresa);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbEmpresaFacade.remove(ejbEmpresaFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> findAll() {
        return ejbEmpresaFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa findById(@PathParam("id") Integer id) {
        return ejbEmpresaFacade.find(id);
    }
    
    @GET
    @Path("tercero/{idTercero}")
    @Produces({"application/json"})
    public List<Empresa> findEmpresaByIdTercero(@PathParam("idTercero") Integer id) {
        return ejbEmpresaFacade.findEmpresaByIdTercero(id);
    }
}
