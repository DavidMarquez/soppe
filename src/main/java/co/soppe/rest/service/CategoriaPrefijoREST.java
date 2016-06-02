/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.CategoriaPrefijo;
import co.soppe.jpa.sessions.CategoriaPrefijoFacade;
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
@Path("categoriaprefijo")
public class CategoriaPrefijoREST {

    @EJB
    private CategoriaPrefijoFacade ejbCategoriaPrefijoFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CategoriaPrefijo categoriaprefijo) {        
        ejbCategoriaPrefijoFacade.create(categoriaprefijo);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, CategoriaPrefijo categoriaproducto) {
        ejbCategoriaPrefijoFacade.edit(categoriaproducto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejbCategoriaPrefijoFacade.remove(ejbCategoriaPrefijoFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaPrefijo> findAll() {
        return ejbCategoriaPrefijoFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaPrefijo findById(@PathParam("id") Integer id) {
        return ejbCategoriaPrefijoFacade.find(id);
    }
        
}