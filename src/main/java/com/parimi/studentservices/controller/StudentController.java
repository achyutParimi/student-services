package com.parimi.studentservices.controller;

import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import com.parimi.studentservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Controller Class -
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students/{studentId}/courses") //API Endpoint- which is mapped to the GET Request
    public List<StudentRegisteredCourse> retrieveCoursesForStudent(
            @PathVariable String studentId //@Path Variable is nothing but - the arguement passed to the api
    ) {
        return studentService.retrieveCourses(studentId);
    }
}
