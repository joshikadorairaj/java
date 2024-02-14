package com.kgisl.SpringStudentCRUD.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kgisl.SpringStudentCRUD.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int arg1) throws SQLException {
        Student student = new Student();
        student.setStudent_id(rs.getInt("student_id"));
        student.setStudent_name(rs.getString("student_name"));
        student.setStudent_Dept(rs.getString("student_dept"));
        return student;
    }
}