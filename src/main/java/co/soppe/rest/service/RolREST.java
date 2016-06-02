/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Rol;
import co.soppe.jpa.sessions.RolFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
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
@Path("roles")
public class RolREST {
    
    @EJB
    private RolFacade ejbRolFacade;

    @POST
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Rol rol) {
        ejbRolFacade.create(rol);
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Rol rol) {
        ejbRolFacade.edit(rol);
    }

    @DELETE
    @RolesAllowed("ADMIN")
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbRolFacade.remove(ejbRolFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> findAll() {
        return ejbRolFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rol findById(@PathParam("id") String id) {
        return ejbRolFacade.find(id);
    }
    
}
