package co.soppe.rest.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author adsi1
 */
public class Token {
    String token;

    public Token(@JsonProperty("token") String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
