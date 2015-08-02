package ba.bitcamp.homeworkWeekend09.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents http server. It is used for reading picture from
 * client, saving it, and sending to http server. When user clicks on link, it
 * will open that photo on localhost
 * 
 * @author Mladen13
 *
 */
public class HttpServer {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket client = null;

		try {
			System.out.println("Server started");
			server = new ServerSocket(8888);
			client = server.accept();

			String ip = client.getInetAddress().getHostName();
			System.out.println("Client with IP: " + ip + " connected.");
			// Creating file and giving name as ip address
			File f = new File(ip + ".jpg");
			// Calling method that will download photo from client
			photoDownloader(client, f);

			while (true) {
				System.out.println("Waiting for client");
				Socket client1 = server.accept();
				System.out.println("New client connected");

				try {
					// Calling method that simulates http server
					httpServer(client1, f);

				} catch (NullPointerException e) {
					continue;
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method is used for reading picture name and then making link to its
	 * site
	 * 
	 * @param client
	 *            - represents client that is connected to server
	 * @param f
	 *            - represents file (photo)
	 * @throws IOException
	 *             - Signals that an I/O exception of some sort has occurred.
	 *             This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 */
	private static void httpServer(Socket client, File f) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				client.getOutputStream()));

		BufferedReader fileReader = null;
		String htmlDoc = "";

		String fromClient = br.readLine();
		String address = "files.html";
		String[] wantedAddress = fromClient.split(" ");
		// Redirecting to picture link
		if (wantedAddress[1].equals("/" + f.getName())) {
			address = "/" + f.getName();

		}

		if (address.equals("files.html")) {
			fileReader = new BufferedReader(new FileReader(new File(address)));

			// Reading from html file and saving lines to string
			while (fileReader.ready()) {
				htmlDoc += fileReader.readLine();
			}
			// Making a link to photo
			htmlDoc += "Picture link: " + "<a href =" + f.getName() + ">"
					+ f.getName() + "</a> " + "Picture Name: "
					+ f.getName().substring(0, f.getName().lastIndexOf("."))
					+ "<br>\n";

			htmlDoc += "</p></body></html>";
			bw.write(htmlDoc);
			bw.flush();

			client.close();
			fileReader.close();

		} else {
			// Calling method that uploads photo to server
			photoUploader(client, f);

		}

	}

	/**
	 * This method is used for downloading photo from client
	 * 
	 * @param client
	 *            - client that is connected to server
	 * @param f
	 *            - represents file
	 * @throws IOException
	 *             - Signals that an I/O exception of some sort has occurred.
	 *             This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 */
	private static void photoDownloader(Socket client, File f)
			throws IOException {
		InputStream sReader = client.getInputStream();

		FileOutputStream sWriter = new FileOutputStream(f);

		byte[] buffer = new byte[1024];
		int readBytes;
		while ((readBytes = sReader.read(buffer, 0, 1024)) > 0) {
			sWriter.write(buffer, 0, readBytes);
		}
		System.out.println("File recieved, and saved as: " + f.getName());
		sWriter.close();
		client.close();
	}
    
	/**
	 * This method is used for uploading picture to server
	 * 
	 * @param client
	 *            - represents client that is connected to server
	 * @param f
	 *            - represents file
	 * @throws IOException
	 *             - Signals that an I/O exception of some sort has occurred.
	 *             This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 */
	private static void photoUploader(Socket client, File f) throws IOException {
		FileInputStream reader = new FileInputStream(new File(f.getName()));
		OutputStream writer = client.getOutputStream();

		byte[] bufferPic = new byte[1024];
		int readBytesPic;
		while ((readBytesPic = reader.read(bufferPic, 0, 1024)) > 0) {
			writer.write(bufferPic, 0, readBytesPic);
		}
		System.out.println("File sent");
		writer.flush();
		client.close();
	}

}
