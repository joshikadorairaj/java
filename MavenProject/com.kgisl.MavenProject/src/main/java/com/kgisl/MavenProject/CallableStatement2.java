package com.kgisl.MavenProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement2 {
    public static void main(String[] args) throws SQLException {
          outselect();
        // insertusers();
        // updateusers();
        //deleteusers();
    }

    public static void outselect() throws SQLException {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "root", "");

        String str = "{ CALL outselect( ? , ? ) }";
 
        CallableStatement Stmt = con.prepareCall(str);

        Stmt.setInt(1 , 5);

        Stmt.registerOutParameter(2,Types.INTEGER);

        Stmt.executeQuery();

        int total = Stmt.getInt(2);
        System.out.println(total);

        con.close();
        Stmt.close();
    }

    

    

}
