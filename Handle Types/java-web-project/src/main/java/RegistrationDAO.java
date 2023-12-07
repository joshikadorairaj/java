// import java.sql.Connection;
// import java.sql.Date;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import com.google.gson.Gson;
// import com.mysql.cj.jdbc.MysqlDataSource;

// public class RegistrationDAO {
//     private String jdbcURL;
//     private String jdbcUsername;
//     private String jdbcPassword;
//     private Connection jdbcConnection;

//     public RegistrationDAO() {
//         this.jdbcURL = "jdbc:mysql://localhost:3306/joshika_d";
//         this.jdbcUsername = "root";
//         this.jdbcPassword = "";
//     }

//     protected void connect() throws SQLException {
//         if (jdbcConnection == null || jdbcConnection.isClosed()) {
//             // try {
//             // Class.forName("com.mysql.jdbc.Driver");
//             // } catch (ClassNotFoundException e) {
//             // throw new SQLException(e);
//             // }
//             // jdbcConnection = DriverManager.getConnection(
//             // jdbcURL, jdbcUsername, jdbcPassword);

//             MysqlDataSource d = new MysqlDataSource();
//             d.setURL("jdbc:mysql://localhost:3306/joshika_d");
//             d.setUser("root");
//             d.setPassword("");
//             jdbcConnection = d.getConnection();
//         }
//     }

//     protected void disconnect() throws SQLException {
//         if (jdbcConnection != null && !jdbcConnection.isClosed()) {
//             jdbcConnection.close();
//         }
//     }

//     public List<Registration> listAll() throws SQLException {
//         List<Registration> listReg = new ArrayList<>();
//         String sql = "SELECT * FROM Registration";
//         connect();
//         Statement statement = jdbcConnection.createStatement();
//         ResultSet resultSet = statement.executeQuery(sql);
//         while (resultSet.next()) {
//             int id = resultSet.getInt("registration_id");
//             String eventname = resultSet.getString("event_name");
//             String athletename = resultSet.getString("athlete_name");
//             Date registrationdate = resultSet.getDate("registration_date");
//             // LocalDate localDate = registrationdate.toLocalDate();
//             Registration reg = new Registration(id, eventname, athletename, registrationdate);
//             listReg.add(reg);

           
//         }
//         resultSet.close();
//         statement.close();
//         disconnect();
//         return listReg;
//     }
// }
