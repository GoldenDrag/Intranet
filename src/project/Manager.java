package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
	private HashMap<Student, Course> registration;
	private MTypes type; 
	
	public Manager(String login, String password, String name, int salary, String id) {
			super(login, password, name, salary, id);
			// TODO Auto-generated constructor stub
	}
	public boolean approveRegistration(Student student, Course course) throws NullPointerException{
		int countCredits = 0;
		Vector<Course> courses = student.getStudentCourses();
		for (int i = 0; i < courses.size(); ++i) {
			if (courses.get(i).equals(course) || countCredits > 21) return false;
			else countCredits += courses.get(i).getCredits();
		}
		return true;
	}
	public void approveRegistration1(Student student, Course course) {
		// TODO Auto-generated method stub
		registration.put(student, course);
	}
	public void registrate(Student student, Course course) {
		student.getStudentCourses().add(course);
		registration.remove(student, course);
	}
	public void nichtRegistrate(Student student, Course course) {
		registration.remove(student, course);
	}
	/**
	 * assign courses to teacher
	 * @param teacher 
	 * @param course 
	 * @return 
	*/
	public boolean assignCourse(Teacher teacher, Course course) {
		return teacher.addCourse(course);
	}
	public void addNews(String str) throws IOException {
		FileWriter fw = new FileWriter("News");
		fw.write(str);
		fw.close();
	}
	public void createReport(String report) throws IOException {
		FileWriter fw = new FileWriter("report");
		fw.write(report);
		fw.close();
	}
	@SuppressWarnings("unchecked")
	public Manager clone() throws CloneNotSupportedException {
		Manager cloned = (Manager)super.clone();
		cloned.setRegistration((HashMap<Student, Course>)registration.clone());
		return cloned;
	}
	public HashMap<Student, Course> getRegistration() {
		return registration;
	}
	public void setRegistration(HashMap<Student, Course> registration) {
		this.registration = registration;
	}
	public void serialize(){
		try {
		FileOutputStream fos = new FileOutputStream("manager.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("manager.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Manager user = (Manager)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MTypes getType() {
		return type;
	}
	public void setType(MTypes type) {
		this.type = type;
	}
	
}

