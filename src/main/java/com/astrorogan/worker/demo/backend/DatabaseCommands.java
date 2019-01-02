package com.astrorogan.worker.demo.backend;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/demo")
public class DatabaseCommands {

    @GET
    @Path("/hello-world")
    public String getMsg() {
        return "Hello World! - Jersey 2!";
    }

    @GET
    @Path("/insert-text")
    public Response insertTextIntoDB(
            @QueryParam("inputText") String inputText) {
        
        try {
        
        DatabaseUtil db = new DatabaseUtil();
        
        int s = db.insertText(inputText);
        
        return Response
                .status(200)
                .entity("Inserted - Id is " + s).build();
        } catch (SQLException e) {
            return Response
                    .status(500)
                    .entity(e.toString()).build();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
            return Response
                    .status(500).build();
            
        }
    }
    
    

}
