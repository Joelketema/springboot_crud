package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("api/v1/student")
    public List<Student> getStudents(){
        return studentService.getStudents();

    }
    record NewStudentRequest(String name, String email, Integer age){}

    @PostMapping("api/v1/student")
    public void createStudent(@RequestBody NewStudentRequest request){
        studentService.addStudent(request);
    }

    @DeleteMapping("api/v1/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteSpecificStudent(id);
    }

    @PutMapping("api/v1/student/{studentId}")
    public void update(@RequestBody NewStudentRequest request,@PathVariable("studentId") Long id){
        studentService.updateStudent(request,id);
    }


}
