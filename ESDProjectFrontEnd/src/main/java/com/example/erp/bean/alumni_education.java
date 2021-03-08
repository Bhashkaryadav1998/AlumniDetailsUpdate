package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class alumni_education implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer alumni_id;
    @Column
    private String degree;
    @Column
    private Integer passing_year;
    @Column
    private Integer joining_year;
    @Column
    private String college_name;


    @Column
    private String address;
    public alumni_education(){

    }

    public alumni_education(Integer id, Integer alumni_id, String degree, Integer passing_year, Integer joining_year, String college_name, String address) {
        this.id = id;
        this.alumni_id = alumni_id;
        this.degree = degree;
        this.passing_year = passing_year;
        this.joining_year = joining_year;
        this.college_name = college_name;
        this.address = address;
    }

    public alumni_education(Integer alumni_id, String degree, Integer passing_year, Integer joining_year, String college_name, String address) {
        this.alumni_id = alumni_id;
        this.degree = degree;
        this.passing_year = passing_year;
        this.joining_year = joining_year;
        this.college_name = college_name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(Integer alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(Integer passing_year) {
        this.passing_year = passing_year;
    }

    public Integer getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(Integer joining_year) {
        this.joining_year = joining_year;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
