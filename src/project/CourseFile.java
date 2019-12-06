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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CourseFile))
			return false;
		CourseFile other = (CourseFile) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseFile clone() throws CloneNotSupportedException {
		return (CourseFile)super.clone();
	}
}

