package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.LoginCredentials;

public interface AuthenticationService {
    Object login(LoginCredentials loginInfo);
}
