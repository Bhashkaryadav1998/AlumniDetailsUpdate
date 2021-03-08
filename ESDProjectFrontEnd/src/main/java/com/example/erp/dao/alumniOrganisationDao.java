package com.example.erp.dao;

import com.example.erp.bean.alumni_education;
import com.example.erp.bean.alumni_organisation;

import java.util.List;

public interface alumniOrganisationDao {
    boolean add(alumni_organisation alumni);
    boolean updateDetails(alumni_organisation alumni);
    List<alumni_organisation> findMax(alumni_organisation al);
    boolean deleteDetails(alumni_organisation alumni);
}
