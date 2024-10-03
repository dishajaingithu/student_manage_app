package com.student.manage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDap {
	
	public static boolean insertStudentToDB(Student st) {
		boolean flag = false;
		try {
			//jdbc Code
			Connection con = CP.createC();
			String q = "insert into students(sname,sphone,scity) value(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//Set the Values of Parameters
			pstmt.setString(1,st.getStudentName());
			pstmt.setString(2,st.getStudentPhone());
			pstmt.setString(3,st.getStudentCity());
			
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return flag;
	}
	
	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		try {
			//jdbc Code
			Connection con = CP.createC();
			String q = "delete from students where sid = ?";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			//Set the Values of Parameters
			pstmt.setInt(1,userId );
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudents() {
		try {
			Connection con = CP.createC();
			String q = "select * from students ";
			//Statement
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID : "+ id);
				System.out.println("Name : "+name);
				System.out.println("Phone No : "+phone);
				System.out.println("City : "+city);
				System.out.println("=============================");
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static boolean updateStudent(int userId, String name, String phone, String city) {
	    boolean flag = false;
	    try {
	        // JDBC code
	        Connection con = CP.createC();
	        String q = "update students set sname = ?, sphone = ?, scity = ? where sid = ?";
	        
	        // PreparedStatement
	        PreparedStatement pstmt = con.prepareStatement(q);
	        
	        // Set the values of the parameters
	        pstmt.setString(1, name);
	        pstmt.setString(2, phone);
	        pstmt.setString(3, city);
	        pstmt.setInt(4, userId);  // Specify the student ID to update

	        // Execute update
	        int rowsAffected = pstmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}


}
