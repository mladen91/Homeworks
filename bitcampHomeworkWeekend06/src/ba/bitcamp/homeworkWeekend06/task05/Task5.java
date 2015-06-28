package ba.bitcamp.homeworkWeekend06.task05;

public class Task5 {

	public static void main(String[] args) {

		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));

	}

	/**
	 * Recursive method that calculates square of one number
	 * 
	 * @param i
	 *            - represents base
	 * @param j
	 *            - represents exponent
	 * @return - result
	 */
	private static double getPower(double i, double j) {

		// If exponent reaches zero return 1
		if (j == 0) {
			return 1;
		} else {
			// Decreasing exponent by one, and multiplying by base
			return i * Math.pow(i, j - 1);
		}
	}

}
