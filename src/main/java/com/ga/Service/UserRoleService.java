package com.ga.Service;

import com.ga.entity.UserRole;

public interface UserRoleService {

    public UserRole createRole(UserRole newRole);

    public UserRole getRole(String roleName);

}