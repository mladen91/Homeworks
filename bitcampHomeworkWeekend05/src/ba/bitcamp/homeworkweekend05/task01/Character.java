package ba.bitcamp.homeworkweekend05.task01;

/**
 * Character class extends StoryElement class. It contains attributes gender,
 * alive and capable status It also contains method that will kill character,
 * and boost his capability
 * 
 * @author Mladen13
 *
 */
public class Character extends StoryElement {

	private boolean male;
	private boolean alive;
	private boolean capable;

	/**
	 * <h1>Constructor that initializes name, gender, and capability</h1>
	 * <p>
	 * 
	 * @param name
	 *            - represents Story element name (extended from StoryElement)
	 * @param male
	 *            - checks character gender
	 * @param capable
	 *            - checks character capability
	 */
	public Character(String name, boolean male, boolean capable) {
		super(name);
		this.male = male;
		alive = true;
		this.capable = capable;
	}

	/**
	 * getting character gender
	 * 
	 * @return - true if its male, false if it's not
	 */
	public boolean isMale() {
		return male;
	}

	/**
	 * Setting character gender
	 * 
	 * @param isMale
	 *            -true if it's male, false if not
	 */
	public void setMale(boolean isMale) {
		this.male = isMale;
	}

	/**
	 * Getting is alive status
	 * 
	 * @return - true if he's alive, false if not
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Setting character to alive or not
	 * 
	 * @param isAlive
	 *            - true if he is alive, false if not
	 */
	public void setAlive(boolean isAlive) {
		this.alive = isAlive;
	}

	/**
	 * Checking character capability
	 * 
	 * @return - true if he's capable, false if not
	 */
	public boolean isCapable() {
		return capable;
	}

	/**
	 * Setting capable status
	 * 
	 * @param isCapable
	 *            - true if he is capable, false if not
	 */
	public void setCapable(boolean isCapable) {
		this.capable = isCapable;
	}

	/**
	 * This method will kill one character
	 */
	public void killCharacter() {
		alive = false;
	}

	/**
	 * This method will turn on character capability
	 */
	public void boostCapability() {
		capable = true;
	}

	/**
	 * Printing character gender, alive and capable status
	 */
	public String toString() {

		return "Is character male: " + male + "\nIs character alive: " + alive
				+ "\nIs character capable: " + capable;
	}
}
