package com.MiniProject;

import java.sql.SQLException;

public class TestMain {

	static {
		System.out.println("***********E-COMMERCE************");
		}

	public static void main(String[] args) throws SQLException {
		DisplayProduct obj=new DisplayProduct();
		LoginPage lp=new LoginPage();
		lp.getUserData();
		//obj.getUserName();
		
	}
}
