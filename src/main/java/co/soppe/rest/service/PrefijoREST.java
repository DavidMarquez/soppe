/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.Prefijo;
import co.soppe.jpa.sessions.PrefijoFacade;
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
@Path("prefijo")
public class PrefijoREST {

        @EJB
        private PrefijoFacade ejbPrefijoFacade;

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public void create(Prefijo prefijo) {
            ejbPrefijoFacade.create(prefijo);
        }

        @PUT
        @Path("{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void edit(@PathParam("id") String id, Prefijo prefijo) {
            ejbPrefijoFacade.edit(prefijo);
        }

        @DELETE
        @Path("{id}")
        public void remove(@PathParam("id") String id) {
            ejbPrefijoFacade.remove(ejbPrefijoFacade.find(id));
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Prefijo> findAll() {
            return ejbPrefijoFacade.findAll();
        }

        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Prefijo findById(@PathParam("id") String id) {
            return ejbPrefijoFacade.find(id);
        }
    }

