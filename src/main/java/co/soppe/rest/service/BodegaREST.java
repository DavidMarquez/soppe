/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Bodega;
import co.soppe.jpa.sessions.BodegaFacade;
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
@Path("bodegas")
public class BodegaREST {
    @EJB
    private BodegaFacade ejbBodegaFacade;
    
        @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Bodega bodega) {
        ejbBodegaFacade.create(bodega);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") int id, Bodega bodega) {
        ejbBodegaFacade.edit(bodega);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        ejbBodegaFacade.remove(ejbBodegaFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bodega> findAll() {
        return ejbBodegaFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bodega findById(@PathParam("id") int id) {
        return ejbBodegaFacade.find(id);
    }
    
}
