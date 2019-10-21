package com.ga.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ga.entity.UserRole;

public class UserRoleServiceTest {
	
	private UserRoleServiceImpl userRoleService;
	
	private UserRole userRole;
	
	@Before
	public void initUserRole() {
		
		userRole = new UserRole();
		userRole.setName("ROLE_DBA");
		userRole.setRoleId(1);
	}

	@Test
	public void getUserRole_AddsRole_Success() {
		UserRole newUserRole = userRoleService.getRole("ROLE_DBA");
		
		Assert.assertNotNull(newUserRole);
		Assert.assertEquals(newUserRole.getName(), userRole.getName());
	}
}
