package com.astrorogan.worker.demo.backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class DatabaseCommands {

    private final String databaseUrl = "jdbc:postgresql://localhost:5432/demoDatabase";
    private final String username = "adamrogan";
    private final String password = "";

    public int insertText(Connection con, String str) throws SQLException, ClassNotFoundException {
        final CallableStatement cs = con.prepareCall("{ ? = call insert_text(?) }");

        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, str);
        cs.execute();

        return cs.getInt(1);
    }

    public ArrayList<String> retrieveAllTextExcerpts(Connection con) throws SQLException, ClassCastException {
        ArrayList<String> resultList = new ArrayList<>();
        final PreparedStatement ps = con.prepareCall("Select text_piece from text_excerpts");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            resultList.add(rs.getString(1));
        }
        return resultList;
    }
}
