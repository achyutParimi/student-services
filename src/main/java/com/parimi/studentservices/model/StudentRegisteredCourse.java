package com.parimi.studentservices.model;

import java.util.Date;

public record StudentRegisteredCourse(
        String courseId,
        String studentId,
        Date startDate,
        Date endDate,

        String grade,

        String studentName,
        String courseName,

        String notes

) {

}
