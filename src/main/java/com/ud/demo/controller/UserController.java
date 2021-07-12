package com.ud.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ud.demo.model.*;
import com.ud.demo.model.User;
import com.ud.demo.service.UserServices;

@RestController
public class UserController 
{
	@Autowired
	UserServices serve;
	@RequestMapping("/ucheck")
	public User fistmsg()
	{
		return new User();
	}
	//*** ***************************Add New User **************************
	@PostMapping(path="/addUser",consumes = {"application/json"} )
	public String saveUser(@RequestBody User user)
	{		
		System.out.println(serve.savinguserdata(user));
		return " Service served ";
	}
	//*** ***************************Modify User based on ID**************************
	@PostMapping(path="/modifyUser",consumes = {"application/json"} )
	public String modify(@Valid @RequestBody User user)
	{
		
		System.out.println(serve.modifyuser(user));
		return " user has  been changed  ";
	}
	//*** ***************************Search by User id**************************
	@RequestMapping(path= "/uinfo/{id}",method=RequestMethod.GET,produces ="application/json")
	public User getuserinfo(@PathVariable("id") String id)
	{ 
		return serve.getuser(Integer.parseInt(id));
	}
	//*** ***************************Search by First Name**************************
	@RequestMapping(path= "/user/fname/{fname}",method=RequestMethod.GET)
	public List<User> userinfobyFName(@PathVariable("fname") String fname)
	{
		return serve.getuserByfame(fname);
	}
	//*** ***************************Search by Last Name**************************
	@RequestMapping(path= "/user/lname/{lname}",method=RequestMethod.GET)
	public ArrayList<User> userinfobyLname(@PathVariable("lname") String lname)
	{
		return serve.getuserByLame(lname);
	}
	//*** ***************************Search by pincode**************************
	@RequestMapping(path= "/user/pincode/{pincode}",method=RequestMethod.GET)
	public List<User> userinfobyPincode(@PathVariable("pincode") String pincode)
	{
		return serve.getuserByPincode(Integer.parseInt(pincode));
				//ffindByPincode(Integer.parseInt(pincode));
	}
	
	//*** ***************************Soft Deletion**************************
		@DeleteMapping("/udel/{id}")
		public String  deletebyid(@PathVariable("id") String sid)
		{
			//int id=Integer.parseInt(sid);
			serve.deleteuserbyid(Integer.parseInt(sid));
			
			
			return "Deleted" ;
		}
		//*** ***************************Hard Deletion**************************
		@DeleteMapping("/hdel/{id}")
		public String  Harddelbyid(@PathVariable("id") String sid)
		{
			//int id=Integer.parseInt(sid);
			serve.userdel(Integer.parseInt(sid));
			
			System.out.println(" Deleted"  );
			return "Deleted ";
		}
		//*** ***************************sorting Deletion**************************
		@GetMapping("/orderbydoj")
		public List<User> getdojbyOrder()
		{
			return serve.sortbydoj();
		}
		@GetMapping("/orderbydojanddob")
		public List<User> getorderbydojandOrder()
		{
			return serve.OrderbyDojAndDob();
		}
	
	

}
