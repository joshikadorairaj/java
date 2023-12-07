package com.kgisl.MavenProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check {
    public static void main(String args[]) throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        CallableStatement Stmt = con.prepareCall("{CALL SELECTUSERSS()}");

        ResultSet result1 = Stmt.executeQuery();

        System.out.println("Contents of the first result1-set");

        while (result1.next()) {
            String userid = result1.getString("user_id");

            String username = result1.getString("username");

            String password = result1.getString("password");

            String email = result1.getString("email");

            String fname = result1.getString("first_name");

            String lname = result1.getString("last_name");

            String usertype = result1.getString("user_type");

            System.out.println(userid + "," + username + "," + password + "," + email + ","

                    + fname + "," + lname + "," + usertype);
        }

        Stmt.getMoreResults();

        System.out.println("Contents of the second result1-set");

        ResultSet result2 = Stmt.getResultSet();

        while (result2.next()) {

            String EVENT_ID = result2.getString("EVENT_ID");

            String EVENT_NAME = result2.getString("EVENT_NAME");

            String EVENT_DATE = result2.getString("EVENT_DATE");

            String LOCATION = result2.getString("LOCATION");

            String DESCRIPTION = result2.getString("DESCRIPTION");

            System.out.println(EVENT_ID + "  " + EVENT_NAME + "  " + EVENT_DATE + "  " + LOCATION + "  " + DESCRIPTION);
        }

        Stmt.getMoreResults();

        System.out.println("Content of third table");

        ResultSet result3 = Stmt.getResultSet();

        while (result3.next()) {
            String COACH_ID = result3.getString("COACH_ID");

            String USER_ID = result3.getString("USER_ID");

            String SPECIALITY = result3.getString("SPECIALITY");

            String BIO = result3.getString("BIO");

            String CERTIFICATIONS = result3.getString("CERTIFICATIONS");

            System.out.println(COACH_ID + "  " + USER_ID + "  " + SPECIALITY + "  " + BIO + "  " + CERTIFICATIONS);
        }
    }

}
