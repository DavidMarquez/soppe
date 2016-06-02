/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.sessions;

import co.soppe.jpa.entities.Empresa_;
import co.soppe.jpa.entities.Producto;
import co.soppe.jpa.entities.Tercero;
import co.soppe.rest.auth.AuthUtils;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adsi1
 */
@Stateless
public class TerceroFacade extends AbstractFacade<Tercero> {

    @PersistenceContext(unitName = "com.mycompany_BackendSoppe_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }

    public Tercero findByEmail(String email) {
        try {
            return (Tercero) getEntityManager().createNamedQuery("Tercero.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Tercero> findByNombre(String nombre) {
        return getEntityManager().createNamedQuery("Tercero.findByNombres")
                .setParameter("nombres", nombre + "%")
                .getResultList();
    }

    public Tercero getAuthUser(HttpServletRequest request) throws ParseException, JOSEException {
        String subject = AuthUtils.getSubject(request.getHeader(AuthUtils.AUTH_HEADER_KEY));
        return super.find(Integer.parseInt(subject));
    }

    public List<Tercero> findTerceroByIdEmpresa(int idSede) {
        try {

            Query query = em.createNativeQuery("SELECT * FROM sedes s inner join terceros t where t.id_sedes=s.id_sedes and s.id_sedes=?id_sedes", Tercero.class);
            query.setParameter("id_sedes", idSede);
            List<Tercero> results = (List<Tercero>) query.getResultList();
            return results;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }
}



