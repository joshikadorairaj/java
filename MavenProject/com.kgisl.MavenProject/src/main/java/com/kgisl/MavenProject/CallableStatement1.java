package com.kgisl.MavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class CallableStatement1 {
    public static void main(String[] args) throws SQLException {
        // select();
        // selectin();
        // insertusers();
        // updateusers();
        deleteusers();
    }

    public static void select() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{call getusers()}";
        CallableStatement Stmt = con.prepareCall(str);
        ResultSet R = Stmt.executeQuery(str);
        int rowcount = 0;
        while (R.next()) {
            String USERNAME = R.getString("USERNAME");
            String USER_ID = R.getString("USER_ID");
            String PASSWORD = R.getString("PASSWORD");
            System.out.println(USER_ID + "   " + USERNAME + "   " + PASSWORD);
            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);
        con.close();
        Stmt.close();
    }

    public static void selectin() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{call getusers1('Joshika')}";
        CallableStatement Stmt = con.prepareCall(str);
        ResultSet result = Stmt.executeQuery(str);
        int rowcount = 0;
        while (result.next()) {
            String USERNAME = result.getString("USERNAME");
            String USER_ID = result.getString("USER_ID");
            String PASSWORD = result.getString("PASSWORD");
            System.out.println(USER_ID + "   " + USERNAME + "   " + PASSWORD);
            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);
        Stmt.close();
        con.close();
    }

    public static void insertusers() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{call insertusers1()}";
        CallableStatement Stmt = con.prepareCall(str);
        int result = Stmt.executeUpdate(str);
        System.out.println(result);
        Stmt.close();
        con.close();

    }

    public static void updateusers() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{call updateusers2(29)}";
        CallableStatement Stmt = con.prepareCall(str);
        int result = Stmt.executeUpdate(str);
        System.out.println(result);
        Stmt.close();
        con.close();
    }

    public static void deleteusers() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{call deleteusers(30)}";
        CallableStatement Stmt = con.prepareCall(str);
        int result = Stmt.executeUpdate(str);
        System.out.println(result);
        Stmt.close();
        con.close();
    }


}
