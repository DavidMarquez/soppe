package co.soppe.rest.service;

import co.soppe.jpa.entities.Tercero;
import co.soppe.jpa.sessions.TerceroFacade;
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
@Path("terceros")
public class TerceroREST {
    @EJB
    private TerceroFacade ejbTerceroFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Tercero tercero) {        
        ejbTerceroFacade.create(tercero);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Tercero tercero) {
        ejbTerceroFacade.edit(tercero);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbTerceroFacade.remove(ejbTerceroFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tercero> findAll() {
        return ejbTerceroFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tercero findById(@PathParam("id") Integer id) {
        return ejbTerceroFacade.find(id);
    }
    
    @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tercero> findByNombre(@PathParam("nombre") String nombre){
        return ejbTerceroFacade.findByNombre(nombre);
    }
    
    @GET
    @Path("empresa/{idTercero}")
    @Produces({"application/json"})
    public List<Tercero> findTerceroByIdEmpresa(@PathParam("idTercero") Integer id) {
        return ejbTerceroFacade.findTerceroByIdEmpresa(id);
    }
    
}
