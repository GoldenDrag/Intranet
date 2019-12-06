package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

public class Course {
	private String name;
	private String id;
	private int credits;
	private String speciality;
	private int yearOfStudy;
	private Vector<CourseFile> files;
	private HashMap<Student, Mark> marks;

	public Course(String name, String id, int credits, String speciality, int yearOfStudy) {
		this.name = name;
		this.id = id;
		this.credits = credits;
		this.speciality = speciality;
	}

	public String toString() {
		return id + " | " + name + " | " + speciality + " | " + credits + " | " + yearOfStudy;
	}
	public void viewFiles() {
		for(int i = 0; i < files.size(); ++i) {
			System.out.println(files.get(i));
		}
		if (files.size() == 0) System.out.println("No files yet");
	}
	public Vector<CourseFile> getFiles() {
		return files;
	}
	public void setFiles(Vector<CourseFile> files) {
		this.files = files;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public Mark getMark(Student student) {
		for (HashMap.Entry<Student, Mark > entry : marks.entrySet()) {
			if (entry.getKey() == student) return entry.getValue();
//		     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return null;
	}
	public HashMap<Student, Mark> getMarks() {
		return marks;
	}
	public void setMarks(HashMap<Student, Mark> marks) {
		this.marks = marks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		result = prime * result + yearOfStudy;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (yearOfStudy != other.yearOfStudy)
			return false;
		return true;
	}
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("course.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("course.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Course user = (Course)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public Course clone() throws CloneNotSupportedException {
		Course cloned = (Course)super.clone();
		cloned.setMarks((HashMap<Student, Mark>)marks.clone()); 
		return cloned;
	}
}
