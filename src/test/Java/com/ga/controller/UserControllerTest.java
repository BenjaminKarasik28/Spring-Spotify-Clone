package com.ga.controller;

import com.ga.Service.UserService;
import com.ga.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.Before;
import org.mockito.junit.MockitoJUnitRunner;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;
    private MockMvc mockMvc2;


    @InjectMocks
    userController usercontroller;

    @InjectMocks
    HelloWorldController helloWorldController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
    }

    @Before
    public void init2() {
        mockMvc2 = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void helloWorld_HelloWorld_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/home/hello")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc2.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"));
    }

    private static String createUserInJson(String username, String password) {
        return "{ \"username\": \"" + username + "\", " +
                "\"password\":\"" + password + "\"}";
    }

    @Test
    public void signup_User_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe", "abc"));

        when(userService.signup(ArgumentMatchers.any())).thenReturn("12345");
        MvcResult result = mockMvc.perform(requestBuilder)
          .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"12345\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void login_User_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe", "abc"));

        when(userService.login(ArgumentMatchers.any())).thenReturn("12345");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"12345\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}