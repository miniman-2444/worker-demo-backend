package com.astrorogan.worker.demo.backend;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/demo")
public class APICommands {

    final DatabaseCommands db = new DatabaseCommands();

    @GET
    @Path("/hello-world")
    public String getMsg() {
        return "Hello World! - Jersey 2!";
    }

    @GET
    @Path("/get-all-text-excerpts")
    public Response getAllTextExcerpts() {

        try {
            ArrayList<String> resultList = new ArrayList<>();
            resultList = db.retrieveAllTextExcerpts(getDbConnectionInstance());

            return Response
                    .status(201)
                    .entity(resultList.toString()).build();
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

    @POST
    @Path("/insert-text")
    public Response insertTextIntoDB(@QueryParam("inputText") String inputText) {

        try {
            int s = db.insertText(getDbConnectionInstance(), inputText);

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

    private Connection getDbConnectionInstance() throws ClassNotFoundException, SQLException {
        return DatabaseUtil.getDbConnection();
    }
}
