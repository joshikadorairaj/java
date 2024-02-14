package com.kgisl.SpringStudentCRUD.Dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kgisl.SpringStudentCRUD.Mapper.StudentRowMapper;
import com.kgisl.SpringStudentCRUD.model.Student;
@Repository
@Transactional
public class StudentDao {
    {
        System.out.println("DAO loaded");
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public StudentDao(JdbcTemplate jdbcTemplate2) {
    }
    public Student getStudent(final int student_id) {
        Student student = jdbcTemplate.queryForObject("select * from student where student_id = ?", new Object[] { student_id },
                new StudentRowMapper());
        return student;
    }
    public List<Student> getStudents() {
        List<Student> students = jdbcTemplate.query("select * from student", new StudentRowMapper());
        return students;
    }
    public void addStudent(final Student student) {
        jdbcTemplate.update("insert into student(student_name, student_Dept) values(?,?)",
                new Object[] { student.getStudent_name(), student.getStudent_Dept() });
    }
    public void updateStudent(final Student student) {
        jdbcTemplate.update("update student set student_name = ?, student_Dept = ? where student_id = ?",
                new Object[] { student.getStudent_name(), student.getStudent_Dept(), student.getStudent_id() });
    }
    public void deleteStudent(final int student_id) {
        jdbcTemplate.update("delete from student where student_id = ?", new Object[] { student_id });
    }
}
