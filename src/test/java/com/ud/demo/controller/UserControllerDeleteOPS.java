package com.ud.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ud.demo.Repository.UserRepository;
import com.ud.demo.model.User;
import com.ud.demo.service.UserServices;

//*************************** in this test class ****Implemeted Test cases of Hard delete and soft delete********
@RunWith(SpringRunner.class)

@WebMvcTest(value = UserController.class)
public class UserControllerDeleteOPS {
	@Autowired
	private MockMvc mockMvc; // .............provides way to rest and points ....
	
	@MockBean
	private UserRepository userrepo;
	
	@MockBean
	private UserServices userservice;
	
	@Test
	public void TestSoftdelete() throws Exception
	{

		User mockuser=new User(22, "RAM", "Dashram", "omm", "123456789", "Pune", "MH", 43129,"javadeveloper", "1995-03-02",  "1995-01-01");
		//Mockito.when(userservice.deleteuserbyid(21)).thenReturn("Deleted");
		Mockito.when(userservice.deleteuserbyid(22)).thenReturn("Delete");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/udel/22").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Uddhav Printing this msg "+result.getResponse().getContentAsString()+ " ->");
		String expected ="{Deleted}";
		
		MockHttpServletResponse response = result.getResponse();
		/*JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);*/
		assertEquals(HttpStatus.OK.value(), response.getStatus());
				
		
	}
	@Test
	public void TestHardtdelete() throws Exception
	{
		User mockuser=new User(23, "RAM", "Dashram", "omm", "123456789", "Pune", "MH", 43129,"javadeveloper", "1995-03-02",  "1995-01-01");
		//Mockito.when(userservice.deleteuserbyid(21)).thenReturn("Deleted");
		Mockito.when(userservice.userdel(23)).thenReturn("Delete");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/hdel/23").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
}
