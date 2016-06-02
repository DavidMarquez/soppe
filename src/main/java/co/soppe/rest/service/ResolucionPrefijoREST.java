/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.ResolucionPrefijo;
import co.soppe.jpa.sessions.ResolucionPrefijoFacade;
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
@Path("resolucionprefijo")
public class ResolucionPrefijoREST {
     @EJB
    private ResolucionPrefijoFacade ejbResolucionPrefijoFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ResolucionPrefijo categoriaproducto) {        
        ejbResolucionPrefijoFacade.create(categoriaproducto);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, ResolucionPrefijo categoriaproducto) {
        ejbResolucionPrefijoFacade.edit(categoriaproducto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbResolucionPrefijoFacade.remove(ejbResolucionPrefijoFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResolucionPrefijo> findAll() {
        return ejbResolucionPrefijoFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResolucionPrefijo findById(@PathParam("id") Integer id) {
        return ejbResolucionPrefijoFacade.find(id);
    }
        
}
