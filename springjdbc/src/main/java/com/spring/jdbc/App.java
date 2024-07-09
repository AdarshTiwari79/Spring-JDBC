package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program is started....." );
        ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/jdbc/Config.xml");
        StudentDao student = con.getBean("studentDao",StudentDao.class);
        
        Student stud = new Student();
         
        Scanner sc = new Scanner(System.in);
		boolean condition = true;
		while (condition) {
			System.out.println("Press 1 for insert a data");
			System.out.println("Press 2 for select a single data");
			System.out.println("Press 3 for select all data");
			System.out.println("Press 4 for delete a single data");
			System.out.println("Press 5 for update a data");
			System.out.println("Press 6 for EXIT");

			try {
				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.println("****************************************");
					System.out.println("You are at Insertion");
					System.out.println("Enter Id : ");
					int studentId = sc.nextInt();
					sc.nextLine();
					stud.setId(studentId);
					System.out.println("Enter Name : ");
					String studentName = sc.nextLine();
					stud.setName(studentName);
					System.out.println("Enter Ciry : ");
					String studentCity = sc.nextLine();
					stud.setAddress(studentCity);
					int row = student.insert(stud);
					System.out.println(row+" row inserted with id = " + stud.getId());	
					System.out.println("****************************************");
					break;

				case 2:
					System.out.println("****************************************");
					System.out.println("You are at Selection of single Student detail");
					System.out.println("Enter Id : ");
					int sId = sc.nextInt();
					Student s1 = student.selectOne(sId);
					System.out.println("-----------------------------------------------");
					System.out.println("Id : "+s1.getId());
					System.out.println("Name : "+s1.getName());
					System.out.println("City : "+s1.getAddress());
					System.out.println("-----------------------------------------------");
					break;

				case 3:
					System.out.println("****************************************");
					System.out.println("You are at Selection of all Student detail");
					List<Student> studentList = student.selectAll();
					for(Student s : studentList) {
						System.out.println("-----------------------------------------------");
						System.out.println("Id : "+s.getId());
						System.out.println("Name : "+s.getName());
						System.out.println("City : "+s.getAddress());
						System.out.println("-----------------------------------------------");
					}
					break;

				case 4:
					System.out.println("****************************************");
					System.out.println("You are at Deleting of single Student detail");
					System.out.println("Enter Id : ");
					int studId = sc.nextInt();
					int n = student.delete(studId);
					System.out.println(n+" row deleted successfully!");
					break;

				case 5:
					System.out.println("****************************************");
					System.out.println("You are at Updating");
					System.out.println("Enter Id : ");
					int stdId = sc.nextInt();
					sc.nextLine();
					stud.setId(stdId);
					System.out.println("Enter Name : ");
					String stdName = sc.nextLine();
					stud.setName(stdName);
					System.out.println("Enter Ciry : ");
					String stdCity = sc.nextLine();
					stud.setAddress(stdCity);
					int no = student.update(stud);
					System.out.println(no+" row Updated successfully ");	
					System.out.println("****************************************");
					break;

				case 6:
					condition = false;
					break;

				default: System.out.println("read the prompt carefully and try with correct input value");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input try with correct one");
				System.out.println(e.getMessage());
			}

		}
		
		System.out.println("You are out now");
    }
}
