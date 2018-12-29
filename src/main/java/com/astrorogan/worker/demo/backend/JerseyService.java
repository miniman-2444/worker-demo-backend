package com.astrorogan.worker.demo.backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/demo")
public class JerseyService {

    @GET
    @Path("/hello-world")
    public String getMsg() {
        return "Hello World! - Jersey 2!";
    }

    @GET
    @Path("/hello-world-with-params")
    public Response getMsgWithParams(
            @QueryParam("num1") int num1,
            @QueryParam("num2") int num2) {

        return Response
                .status(200)
                .entity("The total of adding " + num1 + " and " + num2 + 
                        " is: " + (num1 + num2)).build();
    }

}
