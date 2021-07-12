package com.ud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ud.demo.Repository.UserRepository;

import com.ud.demo.model.User;


@Service
public class UserServices
{
	
	@Autowired
	UserRepository repository;
	public String savinguserdata(User udata)
		{ try {
			
			repository.save(udata);
			
			return " new user information has been added.";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return " only method gets executed ";
	}
	
	public int modifyuser(User udata)
	{ 
			try {
				
				repository.save(udata);
				
					return 0;
				}catch (Exception e) {
				// TODO: handle exception
					System.out.println(e);
				}
			
		return 1;
	}
	public User getuser(int id)
	{
		 User data=repository.findById(id).orElse(new User());
		return data;
	}
	
	public List<User> getuserByfame(String fname)
	{
		//ArrayList<User> list=(ArrayList) repository.findAll();//=pp.save(t);
		//list.stream().forEach(sti->{(sti.getFname().equals(fname)});
		//return getdatageneric((ArrayList) repository.findAll(),fname);
		
		return repository.findByFname(fname);
	}
	
	public ArrayList<User> getuserByLame(String lname)
	{
		ArrayList<User> ob=(ArrayList<User>) repository.findByLname(lname);
		//return repository.findByLname(lname);
		//return getdatageneric((ArrayList) repository.findAll(),lname);
		return ob;
	}
	
	public List<User> getuserByPincode(int pincode)
	{
		 return repository.findByPincode(pincode);
	}
	
	public String  deleteuserbyid(int id)
	{
		try {
			repository.deleteById(id);
			return "Deleted";
			}
		catch (Exception e) 
		{
		// TODO: handle exception
		}
	return " Only Deletion service served ";
	}
	
	public String userdel(int id)
	{ ; 
	 //User user=ob.findById(id).orElse(new User());
	//ArrayList<User> al=ob.findById(id);
	// System.out.println(" deleted user "+user.toString());
		repository.userdelete(id);
		return"Delete";// Hard deletion done ");
	}
	//**************************** getting sorted resulted by DOJ**********************
	public List<User> sortbydoj()
	{
		return repository.findByOrderByDojAsc();
	}
	//**************************** getting sorted resulted by DOJ and DOB ************* 
	public List<User> OrderbyDojAndDob()
	{
		return repository.findByOrderByDojAscDobAsc();
	}
	/*
	User getdatageneric(ArrayList<User> list,String name)
	{ 
		User obj=new User();
		for (User st : list)
		{
			if(st.getFname().isEmpty())
			{
			System.out.println("String is empty");	
			}
			else if(st.getFname().equals(name))
			{
				obj=st;
			}
			else if(st.getLname().equals(name))
			{
				obj=st;
			}
		}
		return obj;
	}
	*/	
			
}
