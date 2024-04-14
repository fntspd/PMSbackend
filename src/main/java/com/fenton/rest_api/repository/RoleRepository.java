package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.Role;
import com.fenton.rest_api.Model.Role_Enum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(Role_Enum name);
}
