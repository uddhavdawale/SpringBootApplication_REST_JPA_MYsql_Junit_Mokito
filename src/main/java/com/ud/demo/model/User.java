package com.ud.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//***************************Implementation of JAVA LOMBOK******************************

//*******************************implementation soft Deletion ***********************
@Entity
@SQLDelete(sql = "UPDATE User SET deleted = true WHERE uid=?") // Override the delete command
// delete User WHERE UID=?
@Where(clause = "deleted=false") // used to read filtered data 
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	private @Getter int uid;
	@NotNull
	@Size(min=3,message="Name should have at least 3 characters") 
	 private @Getter @Setter  String fname,mname,lname;
	
	 private @Getter @Setter  String phone;
	
	 private @Getter @Setter String city;
	 private @Getter @Setter String state;
	 private @Getter @Setter  int pincode;
	
	 private @Getter @Setter  String  profile;
	
	 @JsonFormat(pattern="yyyy-MM-DD",shape = Shape.STRING)
	 @Column(name="doj")
	 private @Getter @Setter  String doj;
	 
	
	 @JsonFormat(pattern="yyyy-MM-DD",shape = Shape.STRING)
	 @Column(name="dob")
	// @Past
	 private @Getter @Setter  String dob;
	 
	 private boolean deleted = Boolean.FALSE;

	public User(int uid, @NotNull @Size(min = 3, message = "Name should have at least 3 characters") String fname,
			@NotNull @Size(min = 3, message = "Name should have at least 3 characters") String mname,
			@NotNull @Size(min = 3, message = "Name should have at least 3 characters") String lname, String phone,
			String city, String state, int pincode, String profile, String doj, String dob) {
		
		this.uid = uid;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.profile = profile;
		this.doj = doj;
		this.dob = dob;
	}
	 

}
