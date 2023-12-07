package com.kgisl.MavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sample {
    // static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        // delete();
        // select();
        // insert();
        // update();
        sqljoin();
    }

    public static void select() throws SQLException {

        // int value=sc.nextInt();
        // sc.close();
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement st = con.createStatement();
        String stselect = "select user_id, username, email from users";

        ResultSet result = st.executeQuery(stselect);

        int count = 0;
        while (result.next()) {
            String user_id = result.getString("user_id");

            String username = result.getString("username");

            String email = result.getString("email");

            System.out.println(user_id + ", " + username + ", " + email);

            ++count;
        }
        System.out.println("Total number of records: " + count);
        st.close();
        con.close();
    }

    public static void insert() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement st = con.createStatement();

        // String stinsert = "insert into users values
        // (23,'Adams','abc@123','adams@gmail.com','Adams','s','Athlete')";

        String stinsert = "insert into users values "
                + "(23, 'Selena', 'abc@123', 'selena@gmail.com','Selena','G','Athlete'),"
                + "(24, 'Taylor', 'abc@123', 'taylor@gmail.com','Taylor','S', 'Athlete')";

        int result = st.executeUpdate(stinsert);
        System.out.println(result);
        st.close();
        con.close();
    }

    public static void update() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement st = con.createStatement();

        String stupdate = "update users set password='josh@gmail.com',last_name='Durairaj' where user_id=1";

        int result = st.executeUpdate(stupdate);
        System.out.println(result);
        st.close();
        con.close();
    }

    public static void delete() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement st = con.createStatement();
        String stdelete = "delete from users where user_id=24";
        int result = st.executeUpdate(stdelete);
        System.out.println(result);
        st.close();
        con.close();
    }

    public static void sqljoin() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/joshika_d?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement st = con.createStatement();

        String str = "SELECT er.registration_id,es.event_name,us.username AS athlete_name,er.registration_date FROM event_registrations er\r\n"
                + //

                "JOIN event_details es ON er.event_id=es.event_id\r\n" + //

                "JOIN athletes_table ath ON er.athlete_id=ath.athlete_id\r\n" + //

                "JOIN users us ON ath.user_id=us.user_id ";

        ResultSet R = st.executeQuery(str);

        int rowcount = 0;

        while (R.next()) {

            String registration_id = R.getString("registration_id");

            String event_name = R.getString("event_name");

            String athlete_name = R.getString("athlete_name");

            String registration_date = R.getString("registration_date");

            // String PASSWORD = R.getString("PASSWORD");

            System.out.println(registration_id + "   " + event_name + "   " + athlete_name + "  " + registration_date);

            rowcount = rowcount + 1;
        }
        System.out.println("Total number of records: " + rowcount);
        st.close();
        con.close();
    }
}
