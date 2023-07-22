package com.customerModels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.customerUtil.DBConnect;

public class CustomerDBUtil {
		private static boolean isSuccess;
		private static Connection con = null;
		private static Statement stmt = null;
		private static ResultSet rs = null;

		public static List<Customer> validate(String userName, String password){
			
			ArrayList<Customer> cus = new ArrayList<>();
			
			try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "select * from customerdetails where username = '"+userName+"'and password='"+password+"'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						int id = rs.getInt(1);
						String name =rs.getString(2);
						String email =rs.getString(3);
						String phone =rs.getString(4);
						String passU =rs.getString(5);
						String userU =rs.getString(6);
						
						Customer c = new Customer(id, name, email, phone, passU, userU);
						cus.add(c);
					}
			}  	
			catch(Exception e) {
				e.printStackTrace();
			}
			return cus;
		}
		
		public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
			
			boolean isSuccess =false;
			
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
			
				
				String sql = "insert into customerdetails values (0,'"+name+"','"+email+"','"+phone+"','"+password+"','"+username+"') ";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
		public static boolean updatecustomer(String id, String name,String email,String phone,String password,String username) {
			
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
				String sql = "update customerdetails set name ='"+name+"', email='"+email+"',phone='"+phone+"',password='"+password+"',username='"+username+"'"+"where id ='"+id+"'";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess =true;
				}else {
					isSuccess =false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			
			return isSuccess;
		}
		
		public static List<Customer> getCustomerDetails(String Id){
			
			int convertedID =Integer.parseInt(Id);
			
			ArrayList<Customer> cus = new ArrayList<> ();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql ="select * from customerdetails where id= '" +convertedID+"'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name =rs.getString(2);
					String email= rs.getString(3);
					String phone = rs.getString(4);
					String password = rs.getString(5);
					String username = rs.getString(6);
					
					Customer c = new Customer(id,name,email,phone,password,username);
					cus.add(c);
				}
				
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return cus;
		}
}
