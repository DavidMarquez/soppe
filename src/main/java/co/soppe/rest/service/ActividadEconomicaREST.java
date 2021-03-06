/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.ActividadEconomica;
import co.soppe.jpa.sessions.ActividadEconomicaFacade;
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
@Path("actividadeconomica")
public class ActividadEconomicaREST {
            
   @EJB
   private ActividadEconomicaFacade ActividadEconomicaFacade;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ActividadEconomica actividadeconomica) {
        ActividadEconomicaFacade.create(actividadeconomica);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, ActividadEconomica actividadeconomica) {
        ActividadEconomicaFacade.edit(actividadeconomica);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ActividadEconomicaFacade.remove(ActividadEconomicaFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActividadEconomica> findAll() {
        return ActividadEconomicaFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActividadEconomica findById(@PathParam("id") int id) {
        return ActividadEconomicaFacade.find(id);
    }
}
