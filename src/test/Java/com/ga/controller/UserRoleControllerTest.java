package com.ga.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ga.Service.UserRoleServiceStub;
import com.ga.entity.User;
import com.ga.entity.UserRole;

public class UserRoleControllerTest {
	
	private UserRoleController userRoleController;
	private UserRole userRole;
	private User user1;
	private User user2;
	private List <User> userList = new ArrayList();
	
	
	@Before
	public void initUserRoleController() {
		userRoleController = new UserRoleController();
		userRoleController.setUserRoleService(new UserRoleServiceStub());
	}
	
	@Test
	public void createUserRole_SaveUserRole_Success() {
		UserRole userRole = new UserRole();
		userRole.setName("ROLE_User");
		UserRole newUserRole = userRoleController.createRole(userRole);
		assertNotNull(newUserRole);
		assertEquals(newUserRole.getName(), userRole.getName());
	}
	
	@Before 
	public void initUserRole() {
		userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setName("ROLE_DBA");
		userList.add(user1);
		userList.add(user2);
		userRole.setUsers(userList);	
	}
	@Test
	public void getUserRole_UserRole_Success(){
		UserRole newRole = userRoleController.getRole("ROLE_DBA");
		assertNotNull(newRole);
		assertEquals(userRole.getName(), newRole.getName());
		
	}
	
	
	

}
