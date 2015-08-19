package ba.bitcamp.homework21.tasks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JTextArea;

public class Handler {

	private String line = "";
	private JTextArea area = new JTextArea();

	public Handler(String line, JTextArea area) {
		this.area = area;
		this.line = line;
	}

	public void checkLine() throws IOException {
		if ("/web ".startsWith(line)) {
			try {
				Desktop.getDesktop().browse(
						new URI("http://"
								+ line.substring(line.indexOf(" ") + 1,
										line.length())));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} else if ("/open ".startsWith(line)) {
			String path = line.substring(line.indexOf(" ") + 1, line.length());
			Desktop.getDesktop().open(new File(path));

		} else if ("/delete ".startsWith(line)) {
			String path = line.substring(line.indexOf(" ") + 1, line.length());
			File f = new File(path);
			f.delete();

		} else if ("/list ".startsWith(line)) {
			String path = line.substring(line.indexOf(" ") + 1, line.length());
			File f = new File(path);
			String[] arr = f.list();
			for (int i = 0; i < arr.length; i++) {
				area.append(arr[i] + "\n");
			}

		} else {
			area.append("Server: " + line + "\n");
		}
	}

}
