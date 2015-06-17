package ba.bitcamp.animal;

public class Animal {

	private String animalName;
	private Integer activeness;
	private Integer waterNeeded;
	private static Integer dayOrNight = 1;
	private static Integer habitat = 1;

	// Creating constructor
	public Animal(String animalName, Integer activeness, Integer waterNeeded) {
		this.animalName = animalName;
		this.activeness = activeness;
		this.waterNeeded = waterNeeded;
	}

	/**
	 * <h1>This method will print animal status</h1>
	 */
	public void printStatus() {
		if (activeness == dayOrNight && waterNeeded == habitat) {
			System.out
					.println("It's fine. The animal is active and has water.");
		} else if (activeness != dayOrNight && waterNeeded == habitat) {
			System.out
					.println("The animal is not active, but has enough water.");
		} else if (activeness == dayOrNight && waterNeeded != habitat) {
			System.out
					.println("The animal is active, but does not have enough water.");
		} else if (activeness != dayOrNight && waterNeeded != habitat) {
			System.out
					.println("The animal is not active and it does not have enough water.");
		}
	}

	/**
	 * <h1>This method will change cycles from day to night</h1>
	 */
	public static void cycleDayNight() {
		if (dayOrNight == 1) {
			dayOrNight = 2;
		} else {
			dayOrNight = 1;
		}
	}

	/**
	 * <h1>This method will set amount of water
	 * <p>
	 * 
	 * @param w
	 *            - represents new amount of water
	 */
	public static void setAmountOfWater(int w) {
		if (habitat >= 0 && habitat <= 3) {
			habitat = w;
		}
	}

}
