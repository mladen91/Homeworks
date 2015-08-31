package homework24;

import java.io.Serializable;

public class Snake implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8304358802528030522L;
	private int[] snakeX= new int[1000];
	private int[] snakeY= new int[1000];
	private int snakeXstart;
	private static int snakeYstart = 50;
	
	
	
	
	public Snake(){
		
		this.snakeX[0]=100;
		this.snakeY[0]=snakeYstart;
		snakeYstart +=50;
		
	}

	public int getSnakeXstart() {
		return snakeXstart;
	}

	public int getSnakeYstart() {
		return snakeYstart;
	}


	public int[] getSnakeX() {
		return snakeX;
	}

	public int[] getSnakeY() {
		return snakeY;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return snakeXstart +" "+snakeYstart;
	}
	

	
	
}
