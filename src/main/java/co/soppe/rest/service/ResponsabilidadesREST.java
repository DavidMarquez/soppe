/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Responsabilidad;
import co.soppe.jpa.sessions.ResponsabilidadFacade;
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
@Path("responsabilidades")
public class ResponsabilidadesREST {
       
   @EJB
   private ResponsabilidadFacade ejbResponsabilidadFacade;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Responsabilidad responsabilidad) {
        ejbResponsabilidadFacade.create(responsabilidad);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Responsabilidad responsabilidad) {
        ejbResponsabilidadFacade.edit(responsabilidad);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbResponsabilidadFacade.remove(ejbResponsabilidadFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Responsabilidad> findAll() {
        return ejbResponsabilidadFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Responsabilidad findById(@PathParam("id") String id) {
        return ejbResponsabilidadFacade.find(id);
    } 
}
