/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.EntradaAlmacen;
import co.soppe.jpa.sessions.EntradaAlmacenFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Luis
 */
@Path ("entradaAlmacen")
public class EntradaAlmacenREST {
    @EJB 
    private EntradaAlmacenFacade ejbEntradaAlmacen;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(EntradaAlmacen entradaAlmacen) {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
        Date fecha = new Date();
        dt1.format(fecha);
        entradaAlmacen.setFecha(fecha);
        ejbEntradaAlmacen.create(entradaAlmacen);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, EntradaAlmacen entradaAlmacen) {
        ejbEntradaAlmacen.edit(entradaAlmacen);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbEntradaAlmacen.remove(ejbEntradaAlmacen.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EntradaAlmacen> findAll() {
        return ejbEntradaAlmacen.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EntradaAlmacen findById(@PathParam("id") String id) {
        return ejbEntradaAlmacen.find(id);
    }
    
}
