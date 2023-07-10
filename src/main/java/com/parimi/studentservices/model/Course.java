package com.parimi.studentservices.model;

import java.util.List;
import java.util.Date;
public record Course(String id,
                     String name,
                     String description,
                     Date startDate,
                     Date endDate

) {
    public void setId(String id) {
    }

}