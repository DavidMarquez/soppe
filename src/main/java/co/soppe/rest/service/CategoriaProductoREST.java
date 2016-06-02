package co.soppe.rest.service;

import co.soppe.jpa.entities.CategoriaProducto;
import co.soppe.jpa.sessions.CategoriaProductoFacade;
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
@Path("categoriaproducto")
public class CategoriaProductoREST {
    @EJB
    private CategoriaProductoFacade ejbCategoriaProductoFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CategoriaProducto categoriaproducto) {        
        ejbCategoriaProductoFacade.create(categoriaproducto);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, CategoriaProducto categoriaproducto) {
        ejbCategoriaProductoFacade.edit(categoriaproducto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbCategoriaProductoFacade.remove(ejbCategoriaProductoFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaProducto> findAll() {
        return ejbCategoriaProductoFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaProducto findById(@PathParam("id") Integer id) {
        return ejbCategoriaProductoFacade.find(id);
    }
        
}
