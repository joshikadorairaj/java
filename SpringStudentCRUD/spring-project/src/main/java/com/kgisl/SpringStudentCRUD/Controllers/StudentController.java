package com.kgisl.SpringStudentCRUD.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kgisl.SpringStudentCRUD.model.Student;
import com.kgisl.SpringStudentCRUD.Service.StudentService;

@Controller
@RequestMapping(value = "/students")

public class StudentController {
    {
        System.out.println("StudentController loaded ...............");
    }
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String getStudents(ModelMap studentModel) {

        List<Student> students = studentService.getStudents();
        System.out.println("StudentController loaded ...............");
        students.stream().forEach(System.out::println);
        studentModel.addAttribute("students", students);
        return "students";
    }

    // Method to show the form for adding a new teacher
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudentForm"; // Assuming you have a JSP named "addTeacherForm.jsp"
    }

    // Method to handle the form submission
    @PostMapping("/add")
    public String processAddStudentForm(@ModelAttribute Student student, Model model) {
        // Process the submitted form data (save to database, etc.)
        studentService.addStudent(student);

        // Redirect to the list of teachers after adding a new one
        return "redirect:/students/";
    }

    // Method to show the form for editing an existing teacher
    @GetMapping("/update/{student_id}")
    public String showEditStudentForm(@PathVariable("student_id") int student_id, Model model) {
        Student existingStudent = studentService.getStudent(student_id);
        model.addAttribute("student", existingStudent);
        return "editStudentForm";
    }

    // Method to handle the form submission for updating an existing teacher
    @PostMapping("/update/{student_id}")
    public String processEditStudentForm(@PathVariable("student_id") int student_id,
            @ModelAttribute Student updatedStudent, Model model) {
        updatedStudent.setStudent_id(student_id);
        studentService.updateStudent(updatedStudent);
        return "redirect:/students/";
    }

    // Method to handle the DELETE request for deleting a teacher
    @GetMapping("/delete/{student_id}")
    public String deleteStudent(@PathVariable("student_id") int student_id) {
        studentService.deleteStudent(student_id);
        // Redirect to the list of teachers after deleting one
        return "redirect:/students/";
    }
}
