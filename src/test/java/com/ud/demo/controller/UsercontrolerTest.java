package com.ud.demo.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType.*;

import com.ud.demo.Repository.UserRepository;
import com.ud.demo.model.User;
import com.ud.demo.service.UserServices;

import antlr.collections.List;

// Mock MVC to launch  user controller
@RunWith(SpringRunner.class)

@WebMvcTest(value = UserController.class)
public class UsercontrolerTest
{
	@Autowired
	private MockMvc mockMvc; // .............provides way to rest and points ....
	
	@MockBean
	private UserRepository userrepo;
	
	@MockBean
	private UserServices userservice;
	
	User mockuser=new User(31,"uddhav","sadashiv", "dawale","9595934249","Pune","Maharashtra",431209,"javadeveloper", "1995-03-02",  "1995-01-01");
	//String exampleuserJson = "{\"uid\":\"19\",\"fame\":\"RAM\",\"mname\":\"Spring\",\"lame\":\"Spring\",\"phone\":\"Spring\",\"city\":\"Spring\",\"state\":\"Spring\",\"pincode\":\"Spring\",\"profile\":\"Spring\",\"doj\":\"Spring\",\"dob\":\"Spring\"}";
	@SuppressWarnings("unchecked")
	@Test
	public void validategetuserbyid() throws Exception
	{
		Mockito.when(userservice.getuser(Mockito.anyInt())).thenReturn(mockuser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/uinfo/31").accept(org.springframework.http.MediaType.APPLICATION_JSON);
			//	heheader("Content-type", "application/json");
			  // .get(String.class).accept(MediaType.APPLICATION/JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg"+result.getResponse().getContentAsString());
		String expected = "{uid:31,fname:uddhav,mname:sadashiv,lname:dawale,city:Pune,state:Maharashtra,pincode:431209,profile:javadeveloper,doj:1995-03-02,dob:1995-01-01}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	//***************implementing negative test *********************************
	/*
	@Test
	public void validategetuserbyid_Negative_Test() throws Exception
	{
		User mockuser1=new User(36,"uddhav","sadashiv", "dawale","9595934249","Pune","Maharashtra",431209,"javadeveloper", "1995-03-02",  "1995-01-01");
		Mockito.when(userservice.getuser(Mockito.anyInt())).thenReturn(mockuser1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/uinfo/31").accept(org.springframework.http.MediaType.APPLICATION_JSON);
			//	heheader("Content-type", "application/json");
			  // .get(String.class).accept(MediaType.APPLICATION/JSON)
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg"+result.getResponse().getContentAsString());
		String expected = "{uid:35,fname:uddhav,mname:sadashiv,lname:dawale,city:Pune,state:Maharashtra,pincode:431209,profile:javadeveloper,doj:1995-03-02,dob:1995-01-01,phone:9595934249}";
		
		/*JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		assertEquals(expected, result.getResponse()
				.getContentAsString()); 
		
	JSONAssert.assertNotEquals(expected, expected, true);
	}*/
	@Test
	public void validategetuserbyname() throws Exception
	{
		ArrayList<User> mockuser=new ArrayList<User>();
		mockuser.add(new User(31,"uddhav","sadashiv", "dawale","9595934249","Pune","Maharashtra",431209,"javadeveloper", "1995-03-02",  "1995-01-01"));
		Mockito.when(userservice.getuserByfame(Mockito.anyString())).thenReturn(mockuser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/fname/uddhav").accept(org.springframework.http.MediaType.APPLICATION_JSON);
			//	heheader("Content-type", "application/json");
			  // .get(String.class).accept(MediaType.APPLICATION/JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg"+result.getResponse().getContentAsString());
		String expected = "[{uid:31,fname:uddhav,mname:sadashiv,lname:dawale,city:Pune,state:Maharashtra,pincode:431209,profile:javadeveloper,doj:1995-03-02,dob:1995-01-01}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	@Test
	public void validategetuserbyLastname() throws Exception
	{
		ArrayList<User> mockuser=new ArrayList<User>();
		mockuser.add(new User(31,"uddhav","sadashiv", "dawale","9595934249","Pune","Maharashtra",431209,"javadeveloper", "1995-03-02",  "1995-01-01"));
		Mockito.when(userservice.getuserByLame(Mockito.anyString())).thenReturn(mockuser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/lname/dawale").accept(org.springframework.http.MediaType.APPLICATION_JSON);
			//	heheader("Content-type", "application/json");
			  // .get(String.class).accept(MediaType.APPLICATION/JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg"+result.getResponse().getContentAsString());
		String expected = "[{uid:31,fname:uddhav,mname:sadashiv,lname:dawale,city:Pune,state:Maharashtra,pincode:431209,profile:javadeveloper,doj:1995-03-02,dob:1995-01-01}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	@Test
	public void validategetuserbyPicode() throws Exception
	{
		ArrayList<User> mockuser=new ArrayList<User>();
		mockuser.add(new User(31,"uddhav","sadashiv", "dawale","9595934249","Pune","Maharashtra",431209,"javadeveloper", "1995-03-02",  "1995-01-01"));
		Mockito.when(userservice.getuserByPincode(Mockito.anyInt())).thenReturn(mockuser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/pincode/431209").accept(org.springframework.http.MediaType.APPLICATION_JSON);
			//	heheader("Content-type", "application/json");
			  // .get(String.class).accept(MediaType.APPLICATION/JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg"+result.getResponse().getContentAsString());
		String expected = "[{uid:31,fname:uddhav,mname:sadashiv,lname:dawale,city:Pune,state:Maharashtra,pincode:431209,profile:javadeveloper,doj:1995-03-02,dob:1995-01-01}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	}
	
	

