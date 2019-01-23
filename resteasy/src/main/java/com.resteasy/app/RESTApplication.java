package com.resteasy.app;

import com.resteasy.rest.ProductRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;



public class RESTApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public RESTApplication() {
        singletons.add(new ProductRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}