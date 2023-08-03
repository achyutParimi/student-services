package com.parimi.studentservices.repository;

import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.Student;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

@Repository
public class DbRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentRegisteredCourse> getCourses(String studentId){
        String sql =
                "SELECT rc.course_id, rc.student_id, rc.startdate, rc.enddate, rc.grade, rc.Notes, std.student_name, crs.course_name\n" +
                        "                        FROM registered_courses rc\n" +
                        "                        JOIN student std ON rc.student_id=std.id\n" +
                        "                        JOIN courses crs ON rc.course_id = crs.id\n" +
                        "                        WHERE rc.student_id=:id";
        Map<String, String> sMap = new HashMap<String, String>();
        sMap.put("id", studentId);
        RowMapper<StudentRegisteredCourse> rm = new RowMapper<StudentRegisteredCourse>() {
            @Override
            public StudentRegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new StudentRegisteredCourse(
                        rs.getString("course_id"),
                        rs.getString("student_id"),
                        rs.getDate("startdate"),
                        rs.getDate("enddate"),
                        rs.getString("grade"),
                        rs.getString("student_name"),
                        rs.getString("course_name"),
                        rs.getString("Notes")
                        );
            }
        };
        List<StudentRegisteredCourse> result = namedParameterJdbcTemplate.query(sql, sMap, rm);
        return result;

    }
    public StudentRegisteredCourse getCourseDetails(String studentId, String courseId){

        String sql =
                "SELECT rc.course_id, rc.student_id, rc.startDate, rc.endDate, rc.grade, rc.Notes, crs.course_name, std.student_name  \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\tFROM registered_courses rc \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\tJOIN student std ON rc.student_id=std.id \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\tJOIN courses crs ON rc.course_id = crs.id\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\tWHERE rc.course_id=:courseId\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\tAND rc.student_id=:studentId";

        Map<String, String> sMap = new HashMap<>();
        sMap.put("courseId", courseId);
        sMap.put("studentId", studentId);
        RowMapper<StudentRegisteredCourse> rm = new RowMapper<StudentRegisteredCourse>() {
            @Override
            public StudentRegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new StudentRegisteredCourse(
                        rs.getString("course_id"),
                        rs.getString("student_id"),
                        rs.getDate("startdate"),
                        rs.getDate("enddate"),
                        rs.getString("grade"),
                        rs.getString("notes"),
                        rs.getString("course_name"),
                        rs.getString("student_name")
                );
            }
        };
        StudentRegisteredCourse result = namedParameterJdbcTemplate.queryForObject(sql, sMap, rm);
        return result;
    }
    public List<Course> getAllCourses(){
        String sql =
                "SELECT * from courses";
//        Map<String, String> sMap = new HashMap<String, String>();
//        sMap.put("id", studentId);
        RowMapper<Course> rm = new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Course(
                        rs.getString("id"),
                        rs.getString("course_name"),
                        rs.getString("description"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")


                );
            }
        };
        List<Course> result = jdbcTemplate.query(sql, rm);
        return result;

    }
    public void addCourse(Course course){
        String sql =
                "insert into courses (course_name, id, description, start_date, end_date) \n" +
                        "\t   values (:cName, :cId, :desc, :sDate, :eDate)\n";

        Map<String, Object> sMap = new HashMap<>();
        sMap.put("cName", course.getName());
        sMap.put("cId", course.getId());
        sMap.put("desc", course.getDescription());
        sMap.put("sDate", course.getStartDate());
        sMap.put("eDate", course.getEndDate());

        int result = namedParameterJdbcTemplate.update(sql,sMap);

    }

    public void registerStudent(Student student){

        String sql =
                "insert into student (student_name, id, address, date_of_birth, enrolled_date)\n" +
                        "\t   values (:sName, :sId, :address, :bDay, :eDate)";
        Map<String, Object> sMap = new HashMap<>();
        sMap.put("sName", student.getName());
        sMap.put("sId", student.getId());
        sMap.put("address", student.getaddress());
        sMap.put("bDay", student.getBirthDay());
        sMap.put("eDate", student.getStartDate());

        int result = namedParameterJdbcTemplate.update(sql,sMap);
    }

    public List<Student> getAllRegisteredStudents() {

        String sql =
                "select * from student";
        RowMapper <Student> rm = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(
                        rs.getString("student_name"),
                        rs.getString("id"),
                        rs.getString("address"),
                        rs.getDate("date_of_birth"),
                        rs.getDate("enrolled_date")
                );

            }
        };

        List<Student> result = jdbcTemplate.query(sql,rm);
        return result;
    }
}