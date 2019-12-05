package project;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m = new Manager("sasat", "lezhat", "Matt", 340000, "SLM34");
		Course c1 = new Course ("OOP", "O0O0P", 4, "IT", 2019);
		Course c2 = new Course ("Algo", "Al101", 4, "IT", 2019);
		Course c3 = new Course ("CN", "CN411", 4, "IT", 2019);
		Course c4 = new Course ("Diff", "Mth112", 4, "IT", 2019);
		Course c5 = new Course ("DB", "DB111", 4, "IT", 2019);
		Course c6 = new Course ("FEE", "El043", 4, "IT", 2019);
		Student s = new Student("ty", "pidor", "Logan", "LN111");
		s.registerCourse(c1, m);
		s.registerCourse(c2, m);
		s.registerCourse(c3, m);
		s.registerCourse(c4, m);
		s.registerCourse(c5, m);
		s.viewCourses();
		System.out.println(s);
	}

}
