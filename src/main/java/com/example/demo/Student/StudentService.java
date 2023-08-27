package com.example.demo.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student(1L, "eyuel", "eyuel@gmail.com", LocalDate.of(2000, 5, 1), 20
                        )
        );
    }


}
