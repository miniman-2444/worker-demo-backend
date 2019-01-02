package com.astrorogan.worker.demo.backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;

public class DatabaseUtil {
    
    private final String databaseUrl = "jdbc:postgresql://localhost:5432/demoDatabase";
    private final String username = "adamrogan";
    private final String password = "";
    
    public DatabaseUtil() {
        
    }  

    public int insertText(String str) throws SQLException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(databaseUrl, username, password);
            CallableStatement cs = con.prepareCall("{ ? = call insert_text(?) }");
            
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, str);
            
            cs.execute();
            
            return cs.getInt(1);
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(databaseUrl, username, password);
    }

}
