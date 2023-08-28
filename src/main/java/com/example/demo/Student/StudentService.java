package com.example.demo.Student;

import org.springframework.expression.ExpressionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(StudentController.NewStudentRequest request){
        Student newStudent = new Student();
        newStudent.setName(request.name());
        newStudent.setEmail(request.email());

        newStudent.setAge(request.age());

        studentRepository.save(newStudent);
    }
    public void deleteSpecificStudent(Long id){
        studentRepository.deleteById(id);
    }

    @Async
    public void updateStudent(StudentController.NewStudentRequest request, Long id){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Employee not found for this id :: " + id));;
        updateStudent.setName(request.name());
        updateStudent.setAge(request.age());
        updateStudent.setEmail(request.email());

        studentRepository.save(updateStudent);
    }
}
