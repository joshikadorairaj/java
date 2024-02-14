package com.kgisl.SpringStudentCRUD.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.SpringStudentCRUD.Dao.StudentDao;
import com.kgisl.SpringStudentCRUD.model.Student;
@Service
public class StudentService {
    {
        System.out.println("StudentService");
    }
    @Autowired
    private StudentDao studentDao;
    public Student getStudent(final int student_id) {
        return studentDao.getStudent(student_id);
    }
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }
    public void addStudent(final Student student) {
        studentDao.addStudent(student);
    }
    public void updateStudent(final Student student) {
        studentDao.updateStudent(student);
    }
    public void deleteStudent(final int student_id) {
        studentDao.deleteStudent(student_id);
    }
}
