package com.parimi.studentservices.service;

import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.Student;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import com.parimi.studentservices.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service// Service layer: Controller layer calls this service - which inturn interacts with dbrepository
public class StudentService {
    @Autowired
    private DbRepository dbRepository;
    public List<StudentRegisteredCourse> retrieveCourses(String studentId){
        return dbRepository.getCourses(studentId);
    }



    public StudentRegisteredCourse retrieveStudentsCourse(String studentId, String courseId){
        return dbRepository.getCourseDetails(studentId, courseId);
    }


    public List<Course> getAllCourses(){
        return dbRepository.getAllCourses();
    }

    public void addCourse(Course course){
        dbRepository.addCourse(course);
    }
    public void registerStudent(Student student){
        dbRepository.registerStudent(student);
    }

    public List<Student> getAllRegisteredStudents() {
        return dbRepository.getAllRegisteredStudents();
    }
}
