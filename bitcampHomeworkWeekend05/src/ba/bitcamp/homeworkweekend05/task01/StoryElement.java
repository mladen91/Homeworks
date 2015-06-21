package ba.bitcamp.homeworkweekend05.task01;

public class StoryElement {

	private String name;

	public StoryElement(String name) {
		super();
		this.name = name;
	}

	public StoryElement() {
		this("STElement");
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Basic toString method
	public String toString() {
		String s = "";
		s = "Story element name " + name;
		return s;
	}
}
