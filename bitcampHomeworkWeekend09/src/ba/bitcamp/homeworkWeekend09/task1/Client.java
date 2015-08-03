package ba.bitcamp.homeworkWeekend09.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class is used for sending path to server, and getting response if file
 * exists on server.
 * 
 * @author Mladen13
 *
 */
public class Client {

	public static void main(String[] args) {

		try {
			System.out.println("Client started");

			Socket client = new Socket("localhost", 8888);
			System.out.println("Client connected");

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
            //Inserting path which will be send to server
			Scanner in = new Scanner(System.in);
			System.out.println("Insert path: ");
			String line = in.nextLine();

			bw.write(line);
			bw.newLine();
			bw.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
            //Reading response from server
			System.out.println(br.readLine());

			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
