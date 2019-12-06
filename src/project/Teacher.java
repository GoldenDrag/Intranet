package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

public class Teacher extends Employee{
	private static final long serialVersionUID = 1L;
	private String name;
	private double rating;
	private Vector<Course> courses;
	private TeacherTitle title;
	
	public Teacher(String login, String password, String name, int salary, String id) {
		super(login, password, name, salary, id);
		// TODO Auto-generated constructor stub
	}
	
	public void viewCourses() {
		System.out.println("Courses:\r\n");
		if (courses.size() > 0) {
			for (int i = 0; i < courses.size(); ++i) {
				System.out.println(courses.get(i));
			}
		}
	}
	public void addCourseFile(CourseFile file, Course course) {
		course.getFiles().add(file);
	}
	public boolean addCourse(Course course) {
		return courses.add(course);
	}
	public boolean viewStudents() {
		if(Database.students.size()==0) {
			System.out.println("No students yet...");
			return false;
		}
		for(int i=0; i<Database.students.size(); i++)
			System.out.println(i+1+ ")" +Database.students.get(i));
		return true;
	}
	public void putMark(Student student, Course course, Mark mark) {
		for (HashMap.Entry<Student, Mark > entry : course.getMarks().entrySet()) {
			if (entry.getKey() == student) entry.setValue(mark);
//		     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
	public void sendOrder(Executer executor, String order) {
		executor.sendOrder(order);
	}
	public String viewStudentInfo(Student student) {
		return student.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name + " " + rating;
	}
	public void rate(int rate) {
		// TODO Auto-generated method stub
		rating = (rating + rate) / 2;
	}
	public void serialize(){
		try {
		FileOutputStream fos = new FileOutputStream("teacher.txt");
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
			FileInputStream fis = new FileInputStream("teacher.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Teacher user = (Teacher)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public Teacher clone() throws CloneNotSupportedException {
		Teacher cloned = (Teacher)super.clone();
		cloned.setCourses((Vector<Course>)courses.clone());
		return cloned;
	}
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public TeacherTitle getTitle() {
		return title;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}
}
