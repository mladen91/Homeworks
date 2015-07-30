package ba.bitcamp.homework22.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is used as server that will send files to local host, where client
 * will get links of visited sites.
 * 
 * @author Mladen13
 *
 */
public class HtmlServer {

	public static void main(String[] args) {

		try {
			// Creating server
			ServerSocket server = new ServerSocket(5555);
			// Creating one list for link, and another for names
			ArrayList<String> linkSet = new ArrayList<>();
			ArrayList<String> nameSet = new ArrayList<>();
			// Reader that will read lines from file
			BufferedReader linkReader = new BufferedReader(new FileReader(
					"links.txt"));
			while (true) {
				Socket client = server.accept();
				// Adding names and links to lists
				while (linkReader.ready()) {
					String line = linkReader.readLine();
					String link = line.substring(0, line.indexOf(" "));
					String name = line.substring(line.indexOf(" ") + 1,
							line.length());

					if (!link.contains("www.")) {
						linkSet.add("www." + link);
					} else {
						linkSet.add(link);
					}
					nameSet.add(name);
				}
				// Creating buffered reader and writer
				BufferedReader br = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						client.getOutputStream()));

				BufferedReader fileReader = null;
				String htmlDoc = "";

				try {

					fileReader = new BufferedReader(new FileReader(new File(
							"files.html")));

				} catch (NullPointerException e) {
					continue;
				}
				// Reading from html file and saving lines to string
				while (fileReader.ready()) {
					htmlDoc += fileReader.readLine();
				}
				// Putting lists and names to html file
				Iterator<String> it = linkSet.iterator();
				int i = 0;
				while (it.hasNext()) {
					it.next();
					htmlDoc += "Site link: " + "<a href =" + linkSet.get(i)
							+ ">" + linkSet.get(i) + "</a> " + "Site Name: "
							+ nameSet.get(i) + "<br>\n";
					i++;
				}

				htmlDoc += "</p></body></html>";
				bw.write(htmlDoc);
				bw.close();
				client.close();
				fileReader.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
