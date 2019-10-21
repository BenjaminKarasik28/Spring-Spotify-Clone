package com.ga.repository;

import com.ga.dao.UserRoleDao;
import com.ga.entity.UserRole;

public class UserRoleDaoStub implements UserRoleDao{

	@Override
	public UserRole createRole(UserRole userRole) {
		UserRole userRole1 = new UserRole();
		userRole1.setName("ROLE_DBA");
		
		return userRole1;
	}

	@Override
	public UserRole getRole(String name) {
		UserRole userRole = new UserRole();
		
		userRole.setName("ROLE_DBA");
		
		return userRole;
		
	}

}
