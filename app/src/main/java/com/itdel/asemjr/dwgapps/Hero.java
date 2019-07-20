package com.itdel.asemjr.dwgapps;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asemJr on 7/11/2019.
 */
public class Hero {

    private String success;
private String employee_salary;
private String team;
private String firstappearance;
private String createdby;
private String publisher;
private String imageurl;
private String employee_age;


public Hero(String success, String employee_salary, String team, String firstappearance, String createdby, String publisher, String imageurl, String employee_age) {
        this.success = success;
        this.employee_salary = employee_salary;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.employee_age = employee_age;
        }

public String getName() {
        return success;
        }

public String getRealname() {
        return employee_salary;
        }

public String getTeam() {
        return team;
        }

public String getFirstappearance() {
        return firstappearance;
        }

public String getCreatedby() {
        return createdby;
        }

public String getPublisher() {
        return publisher;
        }

public String getImageurl() {
        return imageurl;
        }

public String getBio() {
        return employee_age;
        }
        }