package com.example.erp.dao;

import com.example.erp.bean.alumni_education;

import java.util.List;

public interface alumniEducationDao {
    boolean deleteDetails(alumni_education alumni);
    boolean add(alumni_education alumni);
    boolean updateDetails(alumni_education alumni);
    List<alumni_education> findMax(alumni_education al);
}
