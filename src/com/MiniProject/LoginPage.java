package com.MiniProject;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginPage {

	Scanner sc=new Scanner(System.in);
	 public static  LoginPage l=new LoginPage();
	 private String userId,userPassword,adminId,adminPassword;
	 DisplayProduct ob=new DisplayProduct();
	
	//seprating user type base on user and admin
	public void getUserData() throws SQLException {
		System.out.println("Plese enter you are user or admin=");
		String UserType= sc.next();
		 String u="user",admin="admin";
		boolean s= UserType.equals(u),a=UserType.equals(admin);
		if(s==true) {
			l.userRegistration();
			DisplayProduct.getProduct();
				}
		if(a==true) {
			l.adminregistration();
			System.out.println("if you want check quantity type 1,and for userlist type 2");
			int w=sc.nextInt();
			if(w==1) {
			DisplayProduct.adminCheckQuantity();
			}
			if(w==2) {
				ob.getUserName();
			}
			}
	}
	/*public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}*/
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	//creating user id and password
	public String userRegistration() {
		
		System.out.println("Please enter your userid=");
	    userId=sc.next();
		System.out.println("Please enter your password");
		userPassword=sc.next();
		System.out.println("userid="+userId+"...password="+userPassword);
		System.out.println("**Welcome to e-commerce web**");
		return userId+userPassword;
		
		
		
		}
	public void adminregistration() {
		System.out.println("please enter adminuserid=");
		adminId =sc.next();
		System.out.println("Please enter your password");
	   adminPassword=sc.next();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public static void main(String[] args) throws SQLException {
	 l.getUserData();
	}
}
