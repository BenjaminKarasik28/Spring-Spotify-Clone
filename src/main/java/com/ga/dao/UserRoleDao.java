package com.ga.dao;

import com.ga.entity.UserRole;

public interface UserRoleDao {

    public UserRole createRole(UserRole userRole);
    public UserRole getRole(String name);
}
