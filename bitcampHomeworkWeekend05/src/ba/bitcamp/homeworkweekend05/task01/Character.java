package ba.bitcamp.homeworkweekend05.task01;

public class Character extends StoryElement {

	private boolean isMale;
	private boolean isAlive;
	private boolean isCapable;

	/**
	 * <h1>Constructor that initializes name, gender, and capability</h1>
	 * <p>
	 * 
	 * @param name
	 *            - represents Story element name (extended from StoryElement)
	 * @param isMale
	 *            - checks character gender
	 * @param isCapable
	 *            - checks character capability
	 */
	public Character(String name, boolean isMale, boolean isCapable) {
		super(name);
		this.isMale = isMale;
		isAlive = true;
		this.isCapable = isCapable;
	}

	// Getters and setters
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isCapable() {
		return isCapable;
	}

	public void setCapable(boolean isCapable) {
		this.isCapable = isCapable;
	}

	// Method that kills character
	public void killCharacter() {
		isAlive = false;
	}

	// Method that changes character from incapable to capable
	public void boostCapability() {
		isCapable = true;
	}

	// Basic toString method
	public String toString() {
		String s = "";
		s = "Is character male: " + isMale;
		s = s + "\nIs character alive: " + isAlive;
		s = s + "\nIs character capable: " + isCapable;
		return s;
	}
}
