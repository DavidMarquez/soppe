package co.soppe.rest.service;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("co.soppe.rest.service;co.soppe.rest.auth");
        register(RolesAllowedDynamicFeature.class);
    }


}
