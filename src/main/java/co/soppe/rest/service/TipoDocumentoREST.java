/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.TipoDocumento;
import co.soppe.jpa.sessions.TipoDocumentoFacade;
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
@Path("tipodocumento")
public class TipoDocumentoREST {
        
   @EJB
   private TipoDocumentoFacade ejbTipoDocumentoFacade;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(TipoDocumento tipodocumento) {
        ejbTipoDocumentoFacade.create(tipodocumento);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, TipoDocumento tipodocumento) {
        ejbTipoDocumentoFacade.edit(tipodocumento);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbTipoDocumentoFacade.remove(ejbTipoDocumentoFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoDocumento> findAll() {
        return ejbTipoDocumentoFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoDocumento findById(@PathParam("id") int id) {
        return ejbTipoDocumentoFacade.find(id);
    }
}
