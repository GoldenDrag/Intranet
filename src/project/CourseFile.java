package project;

public class CourseFile {
	private String text;
	private String name;
	
	public CourseFile(String text, String name) {
		setText(text);
		setName(name);
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

