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

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

}

