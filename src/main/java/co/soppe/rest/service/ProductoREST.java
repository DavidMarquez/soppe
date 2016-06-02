package co.soppe.rest.service;

import co.soppe.jpa.entities.Producto;
import co.soppe.jpa.entities.ProductoHasBodega;
import co.soppe.jpa.sessions.ProductoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
@Path("productos")
@Stateless
public class ProductoREST {
    
   @EJB
   private ProductoFacade ejbProductoFacade;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Producto producto) {        
        ejbProductoFacade.create(producto);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") int id, Producto producto) {
        ejbProductoFacade.edit(producto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        ejbProductoFacade.remove(ejbProductoFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findAll() {
        return ejbProductoFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto findById(@PathParam("id") int id) {
        return ejbProductoFacade.find(id);
    }
    
    @GET
    @Path("bodega/{idBodega}")
    @Produces({"application/json"})
    public List<Producto> findProductoByIdBodega(@PathParam("idBodega") Integer id) {
        return ejbProductoFacade.findProductoByIdBodega(id);
    }
    
    @GET
    @Path("ultimo")
    @Produces({"application/json"})
    public Producto findProductoUltimo() {
        return ejbProductoFacade.findProductoUltimo();
    }
    
    @GET
    @Path("producto/{idProducto}")
    @Produces({"application/json"})
    public List<ProductoHasBodega> findProductosByIdProductos(@PathParam("idProducto") Integer id) {
        return ejbProductoFacade.findProductosByIdProductos(id);
    }
    
    
    
    
}
