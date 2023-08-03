package com.parimi.studentservices.controller;

import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.Student;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import com.parimi.studentservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller Class -
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students/{studentId}/courses") //API Endpoint- which is mapped to the GET Courses Request
    public List<StudentRegisteredCourse> retrieveCoursesForStudent(
            @PathVariable String studentId //@Path Variable is nothing but - the arguement passed to the api
    ) {
        return studentService.retrieveCourses(studentId);
    }

    @GetMapping("/students/{studentId}/courses/{courseId}") // API Endpoint- which is mapped to GET Courses for a student
    public StudentRegisteredCourse retrieveStudentsCourses(
            @PathVariable String studentId,
            @PathVariable String courseId
    ){
        return studentService.retrieveStudentsCourse(studentId, courseId);
    }

    @GetMapping("/courses") // API Endpoint- which is mapped to GET Courses for a student
    public List<Course> getAllCourses(
    ){
        return studentService.getAllCourses();
    }
    @GetMapping("/students") // API Endpoint- which is mapped to GET Courses for a student
    public List<Student> getAllRegisteredStudents(
    ){
        return studentService.getAllRegisteredStudents();
    }
    //@GetMapping("/students/{studentId}/courses/{courseId}") // API Endpoint- which is mapped to GET Courses for a student
    @PostMapping(path="/addCourse", consumes = "application/json")
    public void addCourse(
            @RequestBody Course course
    ){
         studentService.addCourse(course);
    }

    @PostMapping(path="/registerStudent", consumes = "application/json")
    public void registerStudent(
            @RequestBody Student student
    ){
        studentService.registerStudent(student);
    }
}
