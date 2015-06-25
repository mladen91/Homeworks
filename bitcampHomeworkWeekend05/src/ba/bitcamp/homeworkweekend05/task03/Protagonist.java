package ba.bitcamp.homeworkweekend05.task03;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task02.Event;
import ba.bitcamp.homeworkweekend05.task02.Goal;

/**
 * This class extends Character and contains attributes characterGoal,
 * mainCharacterHelpers, and main enemy It also contains method for adding
 * character and for simulating events and chances to win.
 * 
 * @author Mladen13
 *
 */
public class Protagonist extends Character {

	private Goal characterGoal;
	private Character[] mainCharacterHelpers = new Character[3];
	private Character mainEnemy = null;

	public static final int MAXALLIES = 3;

	/**
	 * <h1>Creating constructor that initializes name, gender, capability and
	 * character goal.</h1>
	 * <p>
	 * 
	 * @param name
	 *            - represents character name
	 * @param isMale
	 *            - represents character gender
	 * @param isCapable
	 *            - capability of character
	 * @param goalCharacter
	 *            - character goal
	 */
	public Protagonist(String name, boolean isMale, boolean isCapable,
			Goal characterGoal) {
		super(name, isMale, isCapable);
		this.characterGoal = characterGoal;
	}

	/**
	 * Getting character goal
	 * 
	 * @return - characterGoal
	 */
	public Goal getCharacterGoal() {
		return characterGoal;
	}

	/**
	 * Setting main character goal
	 * 
	 * @param goalCharacter
	 *            - represents inserted character goal
	 */
	public void setCharacterGoal(Goal characterGoal) {
		this.characterGoal = characterGoal;
	}

	/**
	 * Getting array of character allies
	 * 
	 * @return - array of character allies
	 */
	public Character[] getMainCharacterHelpers() {
		return mainCharacterHelpers;
	}

	/**
	 * Setting array of main character helpers
	 * 
	 * @param helpingMainCharacter
	 */
	public void setMainCharacterHelpers(Character[] mainCharacterHelpers) {
		this.mainCharacterHelpers = mainCharacterHelpers;

	}

	/**
	 * Getting main character enemy
	 * 
	 * @return - character enemy
	 */
	public Character getMainEnemy() {
		return mainEnemy;
	}

	/**
	 * Setting main character enemy
	 * 
	 * @param mainEnemy
	 *            - represents inserted main enemy
	 */
	public void setMainEnemy(Character mainEnemy) {
		this.mainEnemy = mainEnemy;
	}

	/**
	 * Adding allies to main character
	 * 
	 * @param ally
	 *            - represents new ally
	 */
	public void addOneAlly(Character ally) {

		for (int i = 0; i < mainCharacterHelpers.length; i++) {
			if (mainCharacterHelpers[i] == null) {
				mainCharacterHelpers[i] = ally;
				break;
			} else if (mainCharacterHelpers[mainCharacterHelpers.length - 1] != null) {
				System.out.println("Can't add more allies.");
				break;
			}
		}
	}

	/**
	 * This method will simulate events for our story. It contains a lot of
	 * conditions that generates percents for our character It also calculates
	 * chance for winning and printing results.
	 */
	public void attainGoal() {
		int chance = 0;
		// Generating random number between 0-100 to compare with chances to win
		int randNum = (int) (Math.random() * 100);
		// If our character is dead, game over.
		if (!isAlive()) {
			System.out.println("Character is dead!");
		} else {
			// If character is capable, chances will grow by 40%
			if (isCapable()) {
				chance = 40;
			}
			// If main enemy is capable, chances will be lowered by 30%
			if (mainEnemy.isCapable()) {
				chance -= 30;
			}
			// Every ally will increase win chance by 20%
			for (int i = 0; i < mainCharacterHelpers.length; i++) {
				if (mainCharacterHelpers[i] == null) {
					break;
				} else if (mainCharacterHelpers[i].isCapable()) {
					chance += 20;
				}
			}
			// If game mode is HARD, chances will be lowered by 20%, if
			// impossible
			// chances will be 0%
			if (characterGoal.getWeight() == Goal.HARD) {
				chance -= 20;
			} else if (characterGoal.getWeight() == Goal.IMPOSSIBLE) {
				chance = 0;
			}
			// If chances goes under 0, we will set value to 0, if it goes upper
			// 100, we will set value on 100
			if (chance < 0) {
				chance = 0;
			} else if (chance > 100) {
				chance = 100;
			}
			// If our chance is greater than random number that goes between 0
			// and 100
			// Character would succeed in his goal.
			if (chance > randNum) {
				if (characterGoal.getGoal() == Event.DEFEAT) {
					System.out.println("Character succeded. He defeated: "
							+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.FRIENDSHIP) {
					System.out
							.println("Character succeeded. He became friend with: "
									+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.LOVE) {
					System.out
							.println("Character succeeded. He fell in love with: "
									+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.VENGEANCE) {
					System.out.println("Character succeeded. He avenged: "
							+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.MANIPULATION) {
					System.out.println("Character succeeded. He manipulates: "
							+ mainEnemy.getName());
				}
				// If chance is lower than random number, character would be
				// defeated.
			} else if (chance <= randNum) {
				if (characterGoal.getGoal() == Event.DEFEAT) {
					System.out.println("Character failed to defeat: "
							+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.FRIENDSHIP) {
					System.out
							.println("Character failed to become friend with: "
									+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.LOVE) {
					System.out
							.println("Character failed to fall in love with: "
									+ mainEnemy.getName());
				} else if (characterGoal.getGoal() == Event.VENGEANCE) {
					System.out.println("Character failed in avenging.: ");
				} else if (characterGoal.getGoal() == Event.MANIPULATION) {
					System.out.println("Character failed to manipulate: "
							+ mainEnemy.getName());

				}
			}
		}
	}

}
