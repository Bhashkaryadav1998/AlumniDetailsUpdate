package com.example.erp.service;


import com.example.erp.bean.alumni_education;
import com.example.erp.bean.alumni_organisation;
import com.example.erp.dao.alumniOrganisationDao;
import com.example.erp.dao.implementation.alumniEducationDaoImpl;
import com.example.erp.dao.implementation.alumniOrganisationDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class alumniOrganisationService {
    alumniOrganisationDao alumni= new alumniOrganisationDaoImpl();
    public boolean updateDetails(alumni_organisation al){
        return alumni.updateDetails(al);
    }
    public boolean add(alumni_organisation al){
        return alumni.add(al);
    }
    public List<alumni_organisation> find(alumni_organisation al){
        return alumni.findMax(al);
    }
    public boolean deleteDetails(alumni_organisation al){ return alumni.deleteDetails(al);}
}
