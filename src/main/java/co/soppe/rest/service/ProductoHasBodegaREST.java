/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.service;

import co.soppe.jpa.entities.CategoriaProducto;
import co.soppe.jpa.entities.ProductoHasBodega;
import co.soppe.jpa.entities.ProductoHasBodegaPK;
import co.soppe.jpa.sessions.ProductoHasBodegaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis
 */
@Path("productoBodega")
public class ProductoHasBodegaREST {

    @EJB
    private ProductoHasBodegaFacade ejbProductoHasBodega;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ProductoHasBodega productoHasBodega) {
        int idProducto=productoHasBodega.getProducto().getIdProducto();
        int idBodega=productoHasBodega.getBodega().getIdBodega();
        ProductoHasBodegaPK pk=new ProductoHasBodegaPK(idProducto, idBodega);
        productoHasBodega.setProductoHasBodegaPK(pk);
        ejbProductoHasBodega.create(productoHasBodega);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoHasBodega> findAll() {
        return ejbProductoHasBodega.findAllQuery();
    }

}
