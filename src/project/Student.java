package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;;

public class Student extends User {
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private Vector<Course> studentCourses;
	
	public Student(String login, String password, String name, String id) {
		super(login, password);
		this.setName(name);
		this.setId(id);
	}
	
	public void viewCourses() {
		System.out.println("Students courses:\r\n");
		if (studentCourses.size() > 0) {
			for (int i = 0; i < studentCourses.size(); ++i) {
				System.out.println(studentCourses.get(i));
			}
		}
		else System.out.println("No courses registered");
	}
//	public Vector<Course> viewCourses1() {
//		System.out.println("Students courses:");
//		Vector<Course> r = new Vector<Course>();
//		if (studentCourses.size() > 0) {
//			for (int i = 0; i < studentCourses.size(); ++i) {
//				r.add(studentCourses.get(i));
//			}
//			return r;
//		}
//		else return r;
//	}
	public void viewCourseFiles(Course course) {
		course.getFiles();
	}
	public Vector<Course> getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(Vector<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}
	public String viewTeacherInfo(Teacher teacher) {
		return teacher.toString();
	}
	public Mark viewMarks(Course course) {
	    return course.getMark(this);
	}
	public void viewTranscript() {
		System.out.println("Your transcript:");
		for (int i = 0; i < studentCourses.size(); ++i) {
			System.out.println(studentCourses.get(i) + ": " + studentCourses.get(i).getMark(this));
		}
	}
	public String rateTeacher(Teacher teacher, int rate) {
		teacher.rate(rate);
	    return "Thanks for your activeness!";
	}
	public void getTranscript() {
		try {
			FileOutputStream fos = new FileOutputStream("transcript.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < studentCourses.size(); ++i) {
				oos.writeObject(studentCourses.get(i) + ": " + studentCourses.get(i).getMark(this));
			}
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
		System.out.println("Your transcript is ready");
	}
	public void registerCourse(Course course, Manager manager) throws NullPointerException, CloneNotSupportedException {
		if(manager.approveRegistration(this.clone(), course) == true) {
			studentCourses.add(course);
			System.out.println("You now registered to course: " + course);
		} else {
			System.out.println("You can't register");
		}
	}
	public void registerCourse1(Course course, Manager manager) {
		manager.approveRegistration1(this, course);
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (getAverageMark() > o.getAverageMark()) return 1;
		else if (getAverageMark() < o.getAverageMark()) return -1;
		else return 0;
	}
	public double getAverageMark() {
		double averageMark = 0;
		for (int i = 0; i < studentCourses.size(); ++i) {
			averageMark = averageMark + studentCourses.get(i).getMark(this).getTotal();
		}
		return averageMark/studentCourses.size();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id + " " + name;
	}
	public void serialize(){
		try {
		FileOutputStream fos = new FileOutputStream("student.txt");
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
			FileInputStream fis = new FileInputStream("student.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Student user = (Student)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public Student clone() throws CloneNotSupportedException {
		Student cloned = (Student)super.clone();
		cloned.setStudentCourses((Vector<Course>) studentCourses.clone());
		return cloned;
	}
}

