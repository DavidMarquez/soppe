package co.soppe.rest.service;

import co.soppe.jpa.entities.Empresa;
import co.soppe.jpa.entities.Sede;
import co.soppe.jpa.sessions.SedeFacade;
import co.soppe.rest.auth.AuthUtils;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1
 */
@Path("sede")
public class sedeREST {
    
    @EJB
    private SedeFacade ejbSedeFacade;
    
    @Context
    private HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Sede sede) {
        ejbSedeFacade.create(sede);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") int id, Sede sede) {
        ejbSedeFacade.edit(sede);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        ejbSedeFacade.remove(ejbSedeFacade.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sede> findAll() {
        return ejbSedeFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sede findById(@PathParam("id") int id) {
        return ejbSedeFacade.find(id);
    }
    
    @GET
    @Path("empresa/{idEmpresa}")
    @Produces({"application/json"})
    public List<Sede> findSedeByIdEmpresa(@PathParam("idEmpresa") int id) {
        return ejbSedeFacade.findSedeByIdEmpresa(id);
    }
    
}
