/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.sessions;

import co.soppe.jpa.entities.ProductoHasBodega;
import co.soppe.jpa.entities.Sede;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luis
 */
@Stateless
public class ProductoHasBodegaFacade extends AbstractFacade<ProductoHasBodega> {

    @PersistenceContext(unitName = "com.mycompany_BackendSoppe_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoHasBodegaFacade() {
        super(ProductoHasBodega.class);
    }

    public List<ProductoHasBodega> findAllQuery() {
        try {
            return getEntityManager().createNamedQuery("ProductoHasBodega.findAll")
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }

}
