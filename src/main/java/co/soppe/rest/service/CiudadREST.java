package co.soppe.rest.service;

import co.soppe.jpa.entities.Ciudad;
import co.soppe.jpa.sessions.CiudadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1
 */
@Path("ciudades")
public class CiudadREST {
        @EJB
    private CiudadFacade ejbCiudadFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> findAll() {
        return ejbCiudadFacade.findAll();
    }

    @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> findByNombre(@PathParam("nombre") String nombre) {
        return ejbCiudadFacade.findByNombre(nombre);
    }
    
}
