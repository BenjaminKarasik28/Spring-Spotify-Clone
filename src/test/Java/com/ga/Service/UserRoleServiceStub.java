package com.ga.Service;

import com.ga.entity.UserRole;

public class UserRoleServiceStub implements UserRoleService{

	@Override
	public UserRole createRole(UserRole newRole) {
		UserRole newUserRole = new UserRole();
		
		newUserRole.setName("ROLE_DBA");
		return newUserRole;
	}

	@Override
	public UserRole getRole(String roleName) {
		UserRole userRole = new UserRole();
			userRole.setName("ROLE_DBA");
			return userRole;
			
		}
	}


