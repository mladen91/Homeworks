package ba.bitcamp.safe;

public class Main {

	public static void main(String[] args) {

		//Creating safe
		Safe s = new Safe("Tuzna godina");
		//Calling methods from Safe class
		s.printInformation();
		s.addToSafe(30);
		s.printInformation();
		s.addToSafe(100);
		s.printInformation();
		s.clear();
		s.printInformation();

	}

}
