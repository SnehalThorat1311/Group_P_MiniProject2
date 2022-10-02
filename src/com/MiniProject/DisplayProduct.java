package com.MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplayProduct {

	static Scanner st=new Scanner(System.in);
	 static int d, qu,i,grandtotal,productprice,nu;
	 static String r, p="yes",productName;
	 static boolean b,q;
	  static ResultSet sr=null; 
	static ArrayList ar=new ArrayList();
	static Connection con=null;
	static PreparedStatement p3=null;
	//creating method to show product list and buy product
	public static void getProduct() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","snehal13");
		//String sql="select *from products";
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs =ps.executeQuery();
				while(rs.next()) {
				  productName = rs.getString(2);
				 
				System.out.print("productId == "+rs.getString(1));
				System.out.println("\n");
				System.out.println("productdescription == "+rs.getString(2));
				System.out.println(" price == "+rs.getString(3));
				System.out.println(" productname == "+rs.getString(4));
				System.out.println("available - quantity == "+rs.getString(5));
			
					 ar.add(productName);
					 }
					Collections.sort(ar);
					 
				 	System.out.println(ar);
				 	System.out.println("want you buy product yes or no ");
				 	String ans=st.next();
				 	
				 	 b=p.equals(ans);
				 	if(b==true) {
				 		do {
				 	System.out.println("please enter the productId of products = ");
				 	int num=st.nextInt();
				 	nu=num-1;
				 	
				 	PreparedStatement p1=con.prepareStatement("select price from products where productId =" +num);
					 sr =p1.executeQuery();
					while(sr.next()) {
					 d=sr.getInt(1);
						System.out.println(ar.get(nu)+"");
					System.out.println("price =" +d);}
					System.out.println("please enter the quantity =");
					qu=st.nextInt();
					grandtotal = qu * d;
					System.out.println("total bill=="+grandtotal);
				 	//System.out.println(ar.get(nu)+"");
				 	getCart(nu);
				 	System.out.println("Do you want purchase more ?");
				 	r=st.next();
				 	q=r.equals(p);
				 		}while(q == true); 
				 		System.out.println("Thank You please visit again...");
				 		} else 
				 			System.out.println("Thank You visit again");
				 	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getCart(int h) {
	 	System.out.println("product added in cart =" +ar.get(h));
	}
	
	// admin related method 
	public static void adminCheckQuantity() throws SQLException {
		Connection co=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				co=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","snehal13");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try { 
		p3=co.prepareStatement("select * from products");
		 ResultSet s=p3.executeQuery();
		 while(s.next()) {
		 String o=s.getString(1)+s.getString(2);
		 System.out.println(o);
		 }
	}catch(NullPointerException q) {
		q.printStackTrace();
	}

	System.out.println(ar.add(productName));
	System.out.println("please enter productId =");
	int id=st.nextInt();
	PreparedStatement p2=co.prepareStatement("select quantity from products where productId =" +id);
	 sr =p2.executeQuery();
	while(sr.next()) {
	 d=sr.getInt(1);
	System.out.println("available quantity =" +d);
	
	}
	
}
	public void getUserName() {
		LoginPage lp= new LoginPage();
		String s=lp. getUserId();
		System.out.println("Visited users are:::" +s);
	}
}
