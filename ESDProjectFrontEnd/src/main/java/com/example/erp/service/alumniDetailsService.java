package com.example.erp.service;

import com.example.erp.bean.alumni_details;
import com.example.erp.dao.alumniDetailsDao;
import com.example.erp.dao.implementation.alumniDetailsDaoImpl;

public class alumniDetailsService {
    alumniDetailsDao alumni= new alumniDetailsDaoImpl();
    public alumni_details loginValidate(alumni_details alumn){
        return alumni.loginValidate(alumn);
    }
    public alumni_details view(alumni_details al){

        return alumni.viewDetails(al);
    }
    public alumni_details updateDetails(alumni_details al){
        System.out.println("In Service");
        return alumni.updateDetails(al);
    }
}
