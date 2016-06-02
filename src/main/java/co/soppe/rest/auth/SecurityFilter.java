package co.soppe.rest.auth;

import co.soppe.jpa.entities.Rol;
import co.soppe.jpa.entities.Tercero;
import co.soppe.jpa.sessions.TerceroFacade;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;

/**
 *
 * @author adsi1
 */
@Provider
@Priority(Priorities.AUTHENTICATION)

public class SecurityFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @EJB
    private TerceroFacade ejbFacadeTercero;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext originalContext = requestContext.getSecurityContext();
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || authHeader.isEmpty() || authHeader.split(" ").length != 2) {
            Authorizer authorizer = new Authorizer(new ArrayList<Rol>(), "",
                    originalContext.isSecure());
            requestContext.setSecurityContext(authorizer);
        } else {
            JWTClaimsSet claimSet;
            try {
                claimSet = (JWTClaimsSet) AuthUtils.decodeToken(authHeader);
            } catch (ParseException ex) {
                throw new IOException("Error al decodificar JWT");
            } catch (JOSEException ex) {
                throw new IOException("Token invalido");
            }
            if (new DateTime(claimSet.getExpirationTime()).isBefore(DateTime.now())){
                throw new IOException("El token ha expirado");
        }else{
                Tercero User = ejbFacadeTercero.find(Integer.parseInt(claimSet.getSubject()));
                Authorizer authorizer = new Authorizer(User.getRolList(), User.getEmail(),originalContext.isSecure());
                requestContext.setSecurityContext(authorizer);
             }
    }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException { //To change body of generated methods, choose Tools | Templates.
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    public static class Authorizer implements SecurityContext {

        List<Rol> roles;
        String username;
        boolean isSecure;

        public Authorizer(List<Rol> roles, String username, boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String role) {
            return roles.contains(new Rol(Integer.parseInt(role)));
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "JWT";
        }
    }

    public static class User implements Principal {

        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Tamales.
        }

    }

}
