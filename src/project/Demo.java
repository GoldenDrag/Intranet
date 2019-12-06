package project;

import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws NullPointerException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Admin ad = new Admin("a", "as", "Derb", 200000, "ad001");
		if(new File("courses").exists()) {Database.desCourses();}
		if(new File("students").exists()) {Database.desStudents();}
		try {
			menu : while(true) {
				System.out.println("Hello, are you new to intranet?");
				System.out.println("(1)YES;  (2)NO;  (3)Exit;");
				if (in.nextInt() == 1) {
					
				}
				else if (in.nextInt() == 2) {
					enter : System.out.println("Login:");
						String login = in.nextLine();
						System.out.println("Password:");
						String password = in.nextLine();
						for (User user : ad.getUsers()) {
							if (login == user.getLogin() && password == user.getPassword()) {
								if (user instanceof Student) {
									Student student = (Student)user;
									System.out.println("Welcome, " + student.getName() + "!");
									continue student;
								}else if (user instanceof Admin) {
									Admin admin = (Admin)user;
									System.out.println("Welcome, " + admin.getName() + "!");
									continue admin;
								}else if (user instanceof Executer) {
									Executer executer = (Executer)user;
									System.out.println("Welcome, " + executer.getName() + "!");
									continue executer;
								}else if (user instanceof Manager) {
									Manager manager = (Manager)user;
									System.out.println("Welcome, " + manager.getName() + "!");
									continue manager;
								}else {
									Teacher teacher = (Teacher)user;
									System.out.println("Welcome, " + teacher.getName() + "!");
									continue teacher;
								}
							}
							else {
								System.out.println("Something wrong I can feel it. Try again!");
								continue enter;
							}
						}
					student : System.out.println("What do you wish for?");
						System.out.println("(1)Courses;  (2)Files;  (3)Mark;  (4)Rate;  (5)Transcript");
				}
				else if (in.nextInt() == 3) {
					continue menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
		}
	}
}
