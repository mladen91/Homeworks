package ba.bitcamp.homeworkWeekend09.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This server receives path from client and returns 1 if file exists, and 0
 * otherwise. ServerSocket, BufferedReader and BufferedWriter are used in this
 * class.
 * 
 * @author Mladen13
 *
 */
public class Server {

	public static void main(String[] args) {
		try {
			System.out.println("Server started");
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("Client connected");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			//Reading line from client
			String line = br.readLine();
            //Making new file using path given
			File f = new File(line);
            //Checking if file exists 
			bw.write( f.exists() ? "1" : "0");
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
