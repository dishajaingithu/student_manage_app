package Disha;
import java.io.*;
import com.student.manage.Student;
import com.student.manage.*;

public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.println("Welcome to Student Mangement App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to Add Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Display Student");
			System.out.println("PRESS 4 to Update Student");
			System.out.println("PRESS 5 to exit App");
			System.out.print("Enter Your Choice : ");
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				//add student
				System.out.println("Enter User Name : ");
				String name = br.readLine();
				
				System.out.println("Enter User Phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter User City : ");
				String city = br.readLine();
				
				//Create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer = StudentDap.insertStudentToDB(st);
				
				if(answer == true) {
					System.out.println("Student Added Succcessfully");
				}else {
					System.out.println("Something went Wrong...Try Again");
				}
				
				System.out.println(st);
				
			}else if(choice == 2) {
				//delete student
				System.out.print("Enter student ID to Deletee : ");
				int userID = Integer.parseInt(br.readLine());
				
				boolean flag = StudentDap.deleteStudent(userID);	
				if(flag) {
					System.out.println("Deleted Successfully...");
				}else {
					System.out.println("Something Went Wrong...");
				}
			}else if(choice == 3) {
				//display
				StudentDap.showAllStudents();
				
			}else if(choice == 4){
				//update student
				System.out.println("Enter Student ID to Update : ");
				int userID = Integer.parseInt(br.readLine());
				System.out.println("Enter new Name (leave blank to keep current): ");
			    String name = br.readLine();
			    if (name.isEmpty()) {
			        name = null;
			    }
			    System.out.println("Enter new Phone (leave blank to keep current): ");
			    String phone = br.readLine();
			    if (phone.isEmpty()) {
			        phone = null;
			    }
			    
			    System.out.println("Enter new City (leave blank to keep current): ");
			    String city = br.readLine();
			    if (city.isEmpty()) {
			        city = null;
			    }
			    boolean updated = StudentDap.updateStudent(userID, name, phone, city);
			    if (updated) {
			        System.out.println("Student details updated successfully.");
			    } else {
			        System.out.println("Something went wrong. Please try again.");
			    }
			}else if(choice == 5){
				
				break;
			}
		}
		System.out.println("Thank you for using my application");
		System.out.println("See You Soon...bye bye");
	}

}
