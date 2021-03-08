package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class alumni_organisation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String organisation;
    private Integer alumni_id;
    private String position;
    private String joining_date;
    private String leaving_date;
    public alumni_organisation(){

    }
    public alumni_organisation(String organisation, Integer alumni_id, String position, String joining_date, String leaving_date) {
        this.organisation = organisation;
        this.alumni_id = alumni_id;
        this.position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
    }

    public alumni_organisation(Integer id, String organisation, Integer alumni_id, String position, String joining_date, String leaving_date) {
        this.id = id;
        this.organisation = organisation;
        this.alumni_id = alumni_id;
        this.position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public Integer getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(Integer alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(String leaving_date) {
        this.leaving_date = leaving_date;
    }
}
