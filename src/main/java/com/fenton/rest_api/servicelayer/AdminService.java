package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.StudentProfile;

public interface AdminService {
    Admin admin(Admin admin);
    Object addStudent(StudentProfile studentProfile);

    Object addHr(HR hr);


}
