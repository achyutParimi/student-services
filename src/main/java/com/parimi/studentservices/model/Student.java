package com.parimi.studentservices.model;
import java.util.Date;

public record Student (
        String name,
        String id,

        String address,
        Date birthDate,
        Date eDate

){
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    public String getaddress(){
        return address;
    }

    public Date getBirthDay(){
        return birthDate;
    }
    public Date getStartDate(){
        return eDate;
    }

}
