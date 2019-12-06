package project;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Tester {
	public static void save() throws IOException{
		Database.serStudents();
		Database.serCourses();
	}
	public static boolean showStudents(){
		if(Database.students.size()==0) {
			System.out.println("No students yet...");
			return false;
		}
		for(int i=0; i<Database.students.size(); i++)
			System.out.println(i+1+ ")" +Database.students.get(i));
		return true;
	}
	public static boolean showCourses(){
		if(Database.courses.size()==0) {
			System.out.println("No courses yet...");
			return false;
		}
		for(int i=0; i<Database.courses.size(); i++)
			System.out.println(i+1+ ")" +Database.courses.get(i));
		return true;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		if(new File("courses").exists()) {Database.desCourses();}
		if(new File("students").exists()) {Database.desStudents();}
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?");
				System.out.println("\n 1) Add student \n 2) Add course  \n 3) Add course to a Student  \n 4) View students \n 5) Exit");
				int choice = in.nextInt();
				if(choice==1){
					addStudent: while(true){
						System.out.println("Enter login, password, name and id: ");
						Database.students.add(new Student(in.next(), in.next(), in.next(), in.next()));
						System.out.println("Student added! ");
						System.out.println("\n 1) Add another student  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addStudent;
						if(choice==2) continue menu;
						if(choice==5) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					}
				}
				else if (choice==2){
					addCourse: while(true){
						System.out.println("Enter name of the course: ");
						Database.courses.add(new Course(in.next(), in.next(), in.nextInt(), in.next(), in.nextInt()));
						System.out.println("Course added! ");
						System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourse;
						if(choice==2) continue menu;
						if(choice==3) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					}
				}
				else if (choice==3){
					addCourseToStudent: while(true){
						System.out.println("Choose student to which you want to add course: (Enter number)");
						if(!showStudents()) continue menu;
						Student s = Database.students.get(in.nextInt()-1);
						System.out.println("Choose course: (Enter number)");
						if(!showCourses()) continue menu;
						int i = in.nextInt()-1;
						s.getStudentCourses().add(Database.courses.get(i));
						System.out.println("Course "+Database.courses.get(i) +" added to  "+s.getName());
						System.out.println("\n 1) Add another course to some student  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourseToStudent;
						if(choice==2) continue menu;
						if(choice==3) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					}
				}
				else if (choice==4){
					if(!showStudents()) continue menu;
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {System.out.println("Bye!!!"); save();  break menu;}
					break;
				}
				else if (choice==5){
					System.out.println("Bye!!!"); 
					save();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
}
