package com.resteasy.rest;

import com.resteasy.domain.ProductSearchRequest;
import com.resteasy.service.MyService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ProductRestService {
    //Service to search products
    MyService myService = new MyService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product")
    public void searchProduct(final ProductSearchRequest productSearchRequest, final @Suspended AsyncResponse asyncResponse) {
        //recommended to use java executor framework
        new Thread() {
            public void run() {
                //do some other time consuming work if required
                asyncResponse.resume(Response.status(200).entity(getMyService().getProduct(productSearchRequest.getName())).build());
            }
        }.start();
    }

    public MyService getMyService() {
        return myService;
    }
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}