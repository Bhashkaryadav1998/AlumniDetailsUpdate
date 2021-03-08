package com.example.erp.service;

import com.example.erp.bean.alumni_details;
import com.example.erp.bean.alumni_education;
import com.example.erp.dao.alumniDetailsDao;
import com.example.erp.dao.alumniEducationDao;
import com.example.erp.dao.implementation.alumniDetailsDaoImpl;
import com.example.erp.dao.implementation.alumniEducationDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class alumniEducationService {
    alumniEducationDao alumni= new alumniEducationDaoImpl();
    public boolean updateDetails(alumni_education al){
        return alumni.updateDetails(al);
    }
    public boolean add(alumni_education al){
        return alumni.add(al);
    }
    public List<alumni_education> find(alumni_education al){
        return alumni.findMax(al);
    }
    public boolean deleteDetails(alumni_education al){ return alumni.deleteDetails(al);}
}
