package com.ud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStRestUserManagmentApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(PocStRestUserManagmentApplication.class, args);
		System.out.println("Running.........User Managment...... ");
	
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(" Stoping the user managment ....");
	}

}
