package ba.bitcamp.homeworkweekend05.task01;

/**
 * This method contains name attribute, that represents story element name
 * 
 * @author Mladen13
 *
 */
public class StoryElement {

	private String name;

	/**
	 * Creating constructor that initializes story element name
	 * 
	 * @param name
	 */
	public StoryElement(String name) {
		super();
		this.name = name;
	}

	public StoryElement() {
		this("STElement");
	}

	/**
	 * Getting story element name
	 * 
	 * @return - name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setting story element name
	 * 
	 * @param name
	 *            - represents story element name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Printing story element name
	 */
	public String toString() {

		return "Story element name " + name;
	}
}
