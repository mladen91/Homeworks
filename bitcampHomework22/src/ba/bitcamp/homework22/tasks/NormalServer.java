package ba.bitcamp.homework22.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents server that is used for collecting links and names from
 * clients.
 * 
 * @author Mladen13
 *
 */
public class NormalServer {

	public static void main(String[] args) {

		try {
			// Creating client and server
			System.out.println("Server started");
			ServerSocket server = new ServerSocket(5555);
			Socket client = server.accept();
			System.out.println("Client connected");
			// Creating buffered reader and writer
			BufferedReader br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"links.txt"), true));

			String s = "";
			String link = "";
			String name = "";
			// Reading client output
			while ((s = br.readLine()) != null) {

				if (s.contains(".")) {
					link = s.substring(0, s.indexOf(" "));
					name = s.substring(s.indexOf(" ") + 1, s.length());
				}
			}
			// Writing to file
			writer.newLine();
			if (!link.contains("www.")) {
				writer.write("www." + link + " " + name);
			} else {
				writer.write(link + " " + name);
			}

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
