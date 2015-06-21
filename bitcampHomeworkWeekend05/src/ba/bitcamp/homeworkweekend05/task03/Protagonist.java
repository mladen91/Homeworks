package ba.bitcamp.homeworkweekend05.task03;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task02.Event;
import ba.bitcamp.homeworkweekend05.task02.Goal;

public class Protagonist extends Character {

	private Goal goalCharacter;
	private Character[] helpingMainCharacter = { null, null, null };
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

	// Adding allies to character
	public void addOneAlly(Character ally) {

		for (int i = 0; i < helpingMainCharacter.length; i++) {
			if (helpingMainCharacter[i] == null) {
				helpingMainCharacter[i] = ally;
				break;
			} else if(helpingMainCharacter[helpingMainCharacter.length-1] != null){
				System.out.println("Can't add more allies.");

			}
		}

	}

	// This method will simulate actions between two characters
	public void attainGoal() {
		int chance = 0;
		// Generating random number between 0-100 to compare with chances to win
		int randNum = (int) (Math.random() * 100);
		// If character is capable, chances will grow by 40%
		if (isCapable() == true) {
			chance = 40;
		}
		// If main enemy is capable, chances will be lowered by 30%
		if (mainEnemy.isCapable() == true) {
			chance -= 30;
		}
		// Every ally will increase win chance by 20%
		for (int i = 0; i < helpingMainCharacter.length; i++) {
			if (helpingMainCharacter[i] == null) {
				break;
			} else if (helpingMainCharacter[i].isCapable() == true) {
				chance += 20;
			}
		}

		// If game mode is HARD, chances will be lowered by 20%, if impossible
		// chances will be 0%
		if (goalCharacter.getWeight() == Goal.HARD) {
			chance -= 20;
		} else if (goalCharacter.getWeight() == Goal.IMPOSSIBLE) {
			chance = 0;
		}
		// If chances goes under 0, we will set value to 0, if it goes upper
		// 100, we will set value on 100
		if (chance < 0) {
			chance = 0;
		} else if (chance > 100) {
			chance = 100;
		}
		System.out.println(chance);
		// If our character is dead, game over.
		if (isAlive() != true) {
			System.out.println("Character is dead!");
		} else {
			// If our chance is greater than random number that goes between 0
			// and 100
			// Character would succeed in his goal.
			if (chance > randNum) {
				if (goalCharacter.getGoal() == Event.DEFEAT) {
					System.out.println("Character succeded. He defeated: "
							+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.FRIENDSHIP) {
					System.out
							.println("Character succeeded. He became friend with: "
									+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.LOVE) {
					System.out
							.println("Character succeeded. He fell in love with: "
									+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.VENGEANCE) {
					System.out.println("Character succeeded. He avenged: "
							+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.MANIPULATION) {
					System.out.println("Character succeeded. He manipulates: "
							+ mainEnemy.getName());

				}
			//If chance is lower than random number, character would be defeated.
			} else if (chance <= randNum) {
				if (goalCharacter.getGoal() == Event.DEFEAT) {
					System.out.println("Character failed to defeat: "
							+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.FRIENDSHIP) {
					System.out
							.println("Character failed to become friend with: "
									+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.LOVE) {
					System.out
							.println("Character failed to fall in love with: "
									+ mainEnemy.getName());
				} else if (goalCharacter.getGoal() == Event.VENGEANCE) {
					System.out.println("Character failed in avenging.: ");
				} else if (goalCharacter.getGoal() == Event.MANIPULATION) {
					System.out.println("Character failed to manipulate: "
							+ mainEnemy.getName());

				}
			}
		}
	}

}
