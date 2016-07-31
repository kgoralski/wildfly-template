package com.goralski.server.rest;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by kgoralski on 19/07/16.
 */

@ApplicationPath(RestApplication.REST_BASE)
public class RestApplication extends Application {

    public static final String REST_BASE = "/rest";


}
