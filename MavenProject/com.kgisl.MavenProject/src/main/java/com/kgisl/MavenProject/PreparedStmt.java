package com.kgisl.MavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStmt {
    public static void main(String[] args) throws SQLException {

        // select();
        //insert();
        //update();
        // delete();
        sqljoin();

    }

    public static void select() throws SQLException {

        // int value=sc.nextInt();
        // sc.close();
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String stselect = "select user_id, username, email from users where user_id = ? and username LIKE ?";
        PreparedStatement st = con.prepareStatement(stselect);
        st.setInt(1, 1);
        st.setString(2, "Joshika");
        ResultSet result = st.executeQuery();

        int count = 0;
        while (result.next()) {
            String user_id = result.getString("user_id");

            String username = result.getString("username");

            String email = result.getString("email");

            System.out.println(user_id + ", " + username + ", " + email);

            ++count;
        }
        System.out.println("Total number of records: " + count);
        con.close();
        st.close();
    }

    public static void insert() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        // String stinsert = "insert into users values(?,?,?,?,?,?,?)";
        
        String stinsert = "INSERT INTO users (user_id, username, password, email, first_name, last_name, user_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        PreparedStatement st = con.prepareStatement(stinsert);
        st.setInt(1, 24);
        st.setString(2, "Andrew");
        st.setString(3, "andrew@123");
        st.setString(4, "andrew@gmail.com");
        st.setString(5, "Andrew");
        st.setString(6, "A");
        st.setString(7, "Coach") ;
        st.addBatch();

        st.setInt(1, 26);
        st.setString(2, "David");
        st.setString(3, "david@123");
        st.setString(4, "david@gmail.com");
        st.setString(5, "David");
        st.setString(6, "S");
        st.setString(7, "Coach");
        st.addBatch();


        int[] result = st.executeBatch();
        System.out.println(result);
        st.close();
        con.close();
    }

    public static void update() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String stupdate = "update users set password= ?, last_name= ? where user_id=?";
        PreparedStatement st = con.prepareStatement(stupdate);
        st.setString(1,"achu@123");
        st.setString(2,"B");
        st.setInt(3,4);
        int result = st.executeUpdate();
        System.out.println(result);
        st.close();
        con.close();

    }

    public static void delete() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String stdelete = "delete from users where user_id=?";
        PreparedStatement st = con.prepareStatement(stdelete);
        st.setInt(1,12);
        int result = st.executeUpdate();
        System.out.println(result);
        st.close();
        con.close();
    }

    public static void sqljoin() throws SQLException
    {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

                
        String stjoin="select U.username,A.athlete_id from users U INNER JOIN athletes_table A where U.user_id=A.user_id";
        PreparedStatement st = con.prepareStatement(stjoin);
        ResultSet result = st.executeQuery();
        int count = 0;
        while (result.next()) {
            String username = result.getString("username");

            String athlete_id = result.getString("athlete_id");

            System.out.println(username + ", " + athlete_id + " " );

            ++count;
        }
        System.out.println("Total number of records: "+count);
        st.close();
        con.close();
    }
}
