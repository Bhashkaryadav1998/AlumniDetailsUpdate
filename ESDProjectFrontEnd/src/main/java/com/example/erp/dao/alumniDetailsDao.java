package com.example.erp.dao;

import com.example.erp.bean.alumni_details;

public interface alumniDetailsDao {
    alumni_details loginValidate(alumni_details alumni);
    alumni_details viewDetails(alumni_details alumni);
    alumni_details updateDetails(alumni_details alumni);
}
