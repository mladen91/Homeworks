package ba.bitcamp.homeworkweekend05.task02;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task01.StoryElement;

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

	// Getters and setters
	public int getWeight() {
		return gameMode;
	}

	public void setWeight(int weight) {
		this.gameMode = weight;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public Character getEventCharacter() {
		return eventCharacter;
	}

	public void setEventCharacter(Character eventCharacter) {
		this.eventCharacter = eventCharacter;
	}

	// Basic toString method
	public String toString() {
		String s = "";
		s = "Game mode: " + gameMode;
		s = s + "\nEvent for meeting the goal:" + goal;
		s = s + "\nCharacter that takes part in event: " + eventCharacter;
		return s;
	}

}
