package ba.bitcamp.homeworkweekend05.task05;

import ba.bitcamp.homeworkweekend05.task01.Character;
import ba.bitcamp.homeworkweekend05.task02.Event;
import ba.bitcamp.homeworkweekend05.task02.Goal;
import ba.bitcamp.homeworkweekend05.task03.Protagonist;

public class MainStory {

	public static void main(String[] args) {

		// Three brothers went to mission to find monster that kidnaped
		// princess.
		Character c1 = new Character("Odysseus", true, true);
		Character a1 = new Character("Theseus", true, true);
		Character a2 = new Character("Achiles", true, true);
		Character a3 = new Character("Forest Guy", true, true);

		// They found some Minotaur allies. They were having a hostages, and our
		// heroes decided to fight them.

		Character c3 = new Character("Infantry", true, false);
		Goal g1 = new Goal("Kill the Infantry", Goal.EASY, Event.DEFEAT, c3);
		Protagonist p1 = new Protagonist(c1.getName(), c1.isMale(),
				c1.isCapable(), g1);
		p1.addOneAlly(a1);
		p1.addOneAlly(a2);
		p1.setMainEnemy(c3);
		p1.attainGoal();

		// They defeated Minotaur infantry, release one hostage that would fight
		// for them and then they proceeded into forest.
		//

		// They found nest from one of the Minotaur's main warriors, Centurion.
		Character c4 = new Character("Centurion", true, true);

		Goal g2 = new Goal("Kill the Centurion", Goal.EASY, Event.DEFEAT, c4);

		p1 = new Protagonist(c1.getName(), c1.isMale(), c1.isCapable(), g2);
		p1.addOneAlly(a1);
		p1.addOneAlly(a2);
		p1.addOneAlly(a3);
		p1.setMainEnemy(c4);
		p1.attainGoal();
		// When they defeated him, he told them about Minotaur location, so they
		// continued their mission.

		// They came to Minotaur castle, and had few fights.. After that they
		// went to his quaters to fight him.
		// Princess was looking their fight from top of the castle.
		Character c5 = new Character("Minotaur", true, true);
		Goal g3 = new Goal("Kill the Minotaur", Goal.IMPOSSIBLE, Event.DEFEAT,
				c5);

		p1 = new Protagonist(c1.getName(), c1.isMale(), c1.isCapable(), g3);
		p1.addOneAlly(a1);
		p1.addOneAlly(a2);
		p1.addOneAlly(a3);
		p1.addOneAlly(a3);
		p1.setMainEnemy(c5);
		p1.attainGoal();
		// Minotaur was too strong and he defeated all of our heroes. Princess
		// wasn't rescued, but she wasn't to sad about it.
		// Because minotaur WAS RICH!
	}

}
