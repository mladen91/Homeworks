package ba.bitcamp.homeworkweekend06.task06;

public class Task6 {

	/**
	 * This method is used as help method for fill 2D array
	 * 
	 * @param matrix
	 *            - represents 2D array
	 */
	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	/**
	 * This method uses recursion to insert values into 2D array
	 * 
	 * @param matrix
	 *            - 2D array
	 * @param value
	 *            - values that will be inserted into 2D array
	 * @param rows
	 *            - number of rows
	 * @param cols
	 *            - number of columns
	 */
	private static void fillArray(int[][] matrix, int value, int rows, int cols) {
		// Generating two base cases to avoid stack overflow
		if (rows > matrix.length - 1 || cols > matrix[rows].length - 1) {

			return;

		}
		// Inserting values into 2D array
		matrix[rows][cols] = value;
		value++;
		// Checking if we get to the end of columns
		if (cols < matrix[rows].length - 1) {
			// Filling one row
			fillArray(matrix, value, rows, cols + 1);
			// Shifting to new row
		} else {
			rows++;
			cols = 0;
			fillArray(matrix, value, rows, cols);
		}

	}

	public static void main(String[] args) {
		// Creating array 3 x 5
		int[][] matrix = new int[3][5];
		// Filling array
		fillArray(matrix);
		// Printing 2D array
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			// Moving to next row
			System.out.println();
		}
	}
}
