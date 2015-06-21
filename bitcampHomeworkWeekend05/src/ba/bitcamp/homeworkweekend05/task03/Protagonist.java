package ba.bitcamp.homeworkweekend05.task03;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task02.Goal;

public class Protagonist extends Character {

	private Goal goalCharacter;
	private Character[] helpingMainCharacter;
	private Character mainEnemy;

	public static final int MAXALLIES = 3;

	/**
	 * <h1>Creating constructor that initializes name, gender, capability and character goal.</h1>
	 * <p>
	 * @param name - represents character name
	 * @param isMale - represents character gender
	 * @param isCapable - capability of character
	 * @param goalCharacter - character goal
	 */
	public Protagonist(String name, boolean isMale, boolean isCapable,
			Goal goalCharacter) {
		super(name, isMale, isCapable);
		this.goalCharacter = goalCharacter;
		this.helpingMainCharacter = helpingMainCharacter;
		this.mainEnemy = mainEnemy;
	}

	// Getters and setters
	public Goal getGoalCharacter() {
		return goalCharacter;
	}

	public void setGoalCharacter(Goal goalCharacter) {
		this.goalCharacter = goalCharacter;
	}

	public Character[] getHelpingMainCharacter() {
		return helpingMainCharacter;
	}

	public void setHelpingMainCharacter(Character[] helpingMainCharacter) {
		this.helpingMainCharacter = helpingMainCharacter;
	}

	public Character getMainEnemy() {
		return mainEnemy;
	}

	public void setMainEnemy(Character mainEnemy) {
		this.mainEnemy = mainEnemy;
	}
	
	public void addOneAlly(Character ally){
		for (int i = 0; i < helpingMainCharacter.length; i++) {
			helpingMainCharacter[i]=ally;
		}
		
	}

}
