package client;


import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.UriBuilder;

/**
 * Created by kgoralski on 19/07/16.
 */

public class GenericClient<T> {

    protected ResteasyClient client;
    protected ResteasyWebTarget target;
    protected String resourceURI;
    protected T resource;


    public GenericClient(String resourceURI, Class<T> clazz, String userName, String password) {
        this.resourceURI = resourceURI;
        client = new ResteasyClientBuilder().build();
        target = client.target(UriBuilder.fromPath(resourceURI));
        resource = target.proxy(clazz);
    }

    public GenericClient(String resourceURI, Class<T> clazz) {
        this.resourceURI = resourceURI;
        client = new ResteasyClientBuilder().build();
        target = client.target(UriBuilder.fromPath(resourceURI));
        resource = target.proxy(clazz);
    }
}
