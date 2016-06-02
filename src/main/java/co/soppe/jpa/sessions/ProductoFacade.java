/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.sessions;

import co.soppe.jpa.entities.Producto;
import co.soppe.jpa.entities.ProductoHasBodega;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adsi1
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "com.mycompany_BackendSoppe_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    public List<Producto> findProductoByIdBodega(int idBodega) {
        try {

            Query query = em.createNativeQuery("SELECT * FROM bodegas b  join productos p join productos_has_bodegas pb where b.id_bodega=pb.id_bodega and p.id_producto=pb.id_producto and b.id_bodega=?id_bodega", Producto.class);
            query.setParameter("id_bodega", idBodega);
            List<Producto> results = (List<Producto>) query.getResultList();
            return results;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }

    public List<ProductoHasBodega> findProductosByIdProductos(int IdProducto) {
        try {

            Query query = em.createNativeQuery("SELECT * FROM productos_has_bodegas pb WHERE pb.id_producto=?id_producto", ProductoHasBodega.class);
            query.setParameter("id_producto", IdProducto);
            List<ProductoHasBodega> results = (List<ProductoHasBodega>) query.getResultList();
            return results;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }

    public Producto findProductoUltimo() {
        try {
            Query query = em.createNativeQuery("SELECT * FROM soppe.productos order by id_producto desc limit 1", Producto.class);
            Producto results = (Producto) query.getSingleResult();
            return results;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}