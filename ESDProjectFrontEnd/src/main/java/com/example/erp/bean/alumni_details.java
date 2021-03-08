package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class alumni_details implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Long contact_number;
    @Column
    private String student_id;

    public alumni_details(){

    }
    public alumni_details(Integer id, String name, String email, String password, Long contact_number, String student_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact_number = contact_number;
        this.student_id = student_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact_number(Long contact_number) {
        this.contact_number = contact_number;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getContact_number() {
        return contact_number;
    }

    public String getStudent_id() {
        return student_id;
    }
}
