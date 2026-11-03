package com.spriingboot.student_managment_system.service;

import com.spriingboot.student_managment_system.entity.Role;
import com.spriingboot.student_managment_system.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    public void addRole(Role role){
        roleRepository.save(role);
    }
}
