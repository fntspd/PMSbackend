package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin admin(Admin admin) {
        return null;
    }
}
