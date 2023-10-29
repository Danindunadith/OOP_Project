package com.pharmacist;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class pharmacistDBUtil {
	public static List<pharmacist> validate(String pEmail,String pPhone){
		
		ArrayList<pharmacist> pha=new ArrayList<>();
		
		//create database connection
		String url="jdbc:mysql://localhost:3306/medicare";
		String user="root";
		String pass="Danindu@123";
		
		//validate
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt=con.createStatement();
			
			String sql="select * from registered_user where pemail='"+pEmail+"' and pphone='"+pPhone+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int pid=rs.getInt(1);
				String pname=rs.getString(2);
				String pemail=rs.getString(3);
				String meditype=rs.getString(4);
				String paddress=rs.getString(5);
				String pphone=rs.getString(6);
				
				pharmacist r=new pharmacist(pid,pname,pemail,meditype,paddress,pphone);
				pha.add(r);

			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return pha;
	}

}
