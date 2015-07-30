package ba.bitcamp.homework22.tasks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Basic client class that is used for testing html and normal server
 * 
 * @author Mladen13
 *
 */
public class NormalClient {

	public static void main(String[] args) {

		try {
			System.out.println("Client started");

			Socket client = new Socket("192.168.0.101", 5555);
			System.out.println("Client connected");

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			Scanner in = new Scanner(System.in);
			System.out.println("Insert link and site name: ");
			String s = in.nextLine();

			if (s.length() > 0 && s.contains(" ")) {
				bw.newLine();
				bw.write(s);
				bw.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
