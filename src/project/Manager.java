package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
	private HashMap<Student, Course> registration;
	
	public Manager(String login, String password, String name, int salary, String id) {
			super(login, password, name, salary, id);
			// TODO Auto-generated constructor stub
	}
	public boolean approveRegistration(Student student, Course course) {
		int countCredits = 0;
		Vector<Course> courses = student.getStudentCourses();
		for (int i = 0; i < courses.size(); ++i) {
			if (courses.get(i).equals(course) || countCredits > 21) return false;
			countCredits += courses.get(i).getCredits();
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
}

