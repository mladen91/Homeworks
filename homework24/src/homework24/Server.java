package homework24;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static ArrayList<Snake> snakes;

	public static void main(String[] args) {

		Thread t = null;

		try {
			ServerSocket server = new ServerSocket(5555);
			BufferedWriter writer;
			Socket client = null;
			snakes = new ArrayList<Snake>();

			while (true) {
				client = server.accept();
				System.out.println("Client connected");

				ClientThread ct = new ClientThread(client);
				snakes.add(new Snake());

				t = new Thread(ct);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class is used for communication between client and server. It sends
	 * lists of object to clients
	 * 
	 * @author Mladen13
	 *
	 */
	public static class ClientThread implements Runnable {

		private Socket client;
		public String ip;
		ObjectOutputStream writer = null;

		public ClientThread(Socket client) {
			this.client = client;
			this.ip = client.getInetAddress().getHostAddress();
		}

		public void run() {
			try {

				writer = new ObjectOutputStream(client.getOutputStream());
				System.out.println(snakes);
				writer.writeObject(snakes);

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}
}
