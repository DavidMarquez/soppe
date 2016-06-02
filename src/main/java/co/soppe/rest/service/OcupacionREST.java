/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Ocupacion;
import co.soppe.jpa.entities.Producto;
import co.soppe.jpa.sessions.OcupacionFacade;
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
@Path("ocupacion")
public class OcupacionREST {
        
   @EJB
   private OcupacionFacade ejbOcupacionFacade;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Ocupacion ocupacion) {
        ejbOcupacionFacade.create(ocupacion);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Ocupacion ocupacion) {
        ejbOcupacionFacade.edit(ocupacion);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbOcupacionFacade.remove(ejbOcupacionFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ocupacion> findAll() {
        return ejbOcupacionFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ocupacion findById(@PathParam("id") String id) {
        return ejbOcupacionFacade.find(id);
    }
}
