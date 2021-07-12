package com.ud.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ud.demo.model.User;


public interface UserRepository extends CrudRepository<User, Integer>
{
	public List<User> findByDobOrderByDobAsc(String Doj);
	
	public List<User> findByLname(String Lname);
	public List<User> findByFname(String fname);
	public List<User> findByPincode(int Pincode);
	public List<User> findByOrderByDojAsc();
	public List<User> findByOrderByDojAscDobAsc();
	
	
	//***********************Hard delete Implementation *************************
	@Transactional
	@Modifying
	@Query("Delete  from User c where c.uid =:n")
	public void userdelete(@Param("n") int id);
	//***********************end Hard delete*********************************
	
}
