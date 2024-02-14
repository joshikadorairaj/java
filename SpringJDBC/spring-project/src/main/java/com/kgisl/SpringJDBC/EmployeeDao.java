// package com.kgisl.SpringJDBC;

// import java.util.List;

// import org.springframework.jdbc.core.JdbcTemplate;

// public class EmployeeDao {
//     private JdbcTemplate jdbcTemplate;

//     public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//         this.jdbcTemplate = jdbcTemplate;
//     }

//     public int saveEmployee(Employee e) {
//         String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
//         return jdbcTemplate.update(query);
//     }

//     public int updateEmployee(Employee e) {
//         String query = "update employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
//                 + e.getId() + "' ";
//         return jdbcTemplate.update(query);
//     }

//     public int deleteEmployee(Employee e) {
//         String query = "delete from employee where id='" + e.getId() + "' ";
//         return jdbcTemplate.update(query);
//     }

//     public List<Employee> allEmployees() {
//         String query = "SELECT * FROM employee";
//         return jdbcTemplate.query(query,new EmployeeMapper());
//     }

// }
