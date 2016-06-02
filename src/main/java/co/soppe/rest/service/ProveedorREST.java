package co.soppe.rest.service;

import co.soppe.jpa.entities.Proveedor;
import co.soppe.jpa.sessions.ProveedorFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1
 */
@Path ("proveedor")
public class ProveedorREST {
    @EJB 
    private ProveedorFacade ejbProveedorFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Proveedor proveedor) {        
        ejbProveedorFacade.create(proveedor);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") int id, Proveedor proveedor) {
        ejbProveedorFacade.edit(proveedor);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        ejbProveedorFacade.remove(ejbProveedorFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proveedor> findAll() {
        return ejbProveedorFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proveedor findById(@PathParam("id") int id) {
        return ejbProveedorFacade.find(id);
    }
    
}
