package ba.bitcamp.tasks;

public class Main {

	public static void main(String[] args) {

		LinkedListDouble ld = new LinkedListDouble();

		ld.add(2.3);
		ld.add(2.5);
		ld.add(2.9);
		ld.add(2.8);
		ld.remove(2);
		LinkedListDouble ld2 = new LinkedListDouble(ld);
		System.out.println(ld2.getMiddle());
		System.out.println(ld2.getLast());
		System.out.println(ld2);
		ld2.add(3, 1);
		System.out.println(ld2);
		
		
		ld2.deleteLast();
		System.out.println(ld2);

	}

}

