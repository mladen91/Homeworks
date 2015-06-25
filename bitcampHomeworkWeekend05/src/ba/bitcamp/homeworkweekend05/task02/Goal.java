package ba.bitcamp.homeworkweekend05.task02;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task01.StoryElement;

/**
 * This class extends StoryElement and contains attributes gameMode, goal and
 * eventCharacter It also contains getters and setters, and toString method.
 * 
 * @author Mladen13
 *
 */
public class Goal extends StoryElement {

	private int gameMode;
	private int goal;
	private Character eventCharacter;

	// game mode possibility
	public static final int EASY = 1;
	public static final int HARD = 2;
	public static final int IMPOSSIBLE = 3;

	/**
	 * <h1>Making constructor that will generate goal from class Event and event
	 * character from class Character</h1>
	 * <p>
	 * 
	 * @param name
	 *            - represents Story element name
	 * @param weight
	 *            - how hard is to fulfill character goal
	 * @param goal
	 *            - represents character goal
	 * @param eventCharacter
	 *            - character that will be part of event
	 */
	public Goal(String name, int weight, int goal, Character eventCharacter) {
		super(name);
		this.gameMode = weight;
		this.goal = goal;
		this.eventCharacter = eventCharacter;
	}

	/**
	 * Getting game mode (easy, hard, or impossible)
	 * 
	 * @return - gameMode
	 */
	public int getWeight() {
		return gameMode;
	}

	/**
	 * Setting gameMode
	 * 
	 * @param weight
	 *            - represents game mode (easy, hard or impossible)
	 */
	public void setWeight(int weight) {
		this.gameMode = weight;
	}

	/**
	 * Getting character main goal
	 * 
	 * @return - goal
	 */
	public int getGoal() {
		return goal;
	}

	/**
	 * Setting character main goal
	 * 
	 * @param goal
	 */
	public void setGoal(int goal) {
		this.goal = goal;
	}

	/**
	 * Getting character event
	 * 
	 * @return - characterEvent
	 */
	public Character getEventCharacter() {
		return eventCharacter;
	}

	/**
	 * Setting character event
	 * 
	 * @param eventCharacter
	 */
	public void setEventCharacter(Character eventCharacter) {
		this.eventCharacter = eventCharacter;
	}

	/**
	 * Printing game mode, main event, and character that takes part in event
	 */
	public String toString() {

		return "Game mode: " + gameMode + "\nEvent for meeting the goal:"
				+ goal + "\nCharacter that takes part in event: "
				+ eventCharacter;
	}

}
