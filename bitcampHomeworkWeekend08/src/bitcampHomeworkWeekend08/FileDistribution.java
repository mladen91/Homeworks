package bitcampHomeworkWeekend08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * This class is used for distribution of files trough folders. It contains GUI
 * components, so we can access files using it. It also contains method that
 * removes selected file from computer
 * 
 * @author Mladen13
 *
 */
public class FileDistribution extends JFrame {

	private static final long serialVersionUID = 331045334835313456L;

	private JButton browse = new JButton("Browse");
	private JButton remove = new JButton("Remove");
	private JPanel panel = new JPanel();
	private JTextArea area = new JTextArea("Files");
	private JLabel label = new JLabel("Folder Name");

	private File currentFolderFiles;
	private String[] arr;

	/**
	 * Default constructor that is used for creating GUI components
	 */
	public FileDistribution() {

		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		panel.add(area);
		add(remove, BorderLayout.EAST);
		area.setFont(new Font("Serif", Font.BOLD, 25));
		add(label, BorderLayout.NORTH);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 15));
		add(browse, BorderLayout.SOUTH);
		browse.addActionListener(new ButtonHandler());
		remove.addActionListener(new ButtonHandler());

		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Class that implements Action Listener and it is used for giving orders to
	 * browse and remove buttons.
	 * 
	 * @author Mladen13
	 *
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (browse == e.getSource()) {
				JFileChooser jfc = new JFileChooser();
				String s = "";

				int choose = jfc.showOpenDialog(null);

				if (choose == JFileChooser.APPROVE_OPTION) {
					File f = jfc.getSelectedFile();

					s = getExtension(jfc.getName(f));
					// Moving different types of files trough folders
					if (s.equals(".txt") || s.equals(".doc")
							|| s.equals(".docx") || s.equals(".xlsx")
							|| s.equals(".pdf") || s.equals(".pptx")) {

						moveFiles(f, jfc, "/Documents");

					} else if (s.equals(".png") || s.equals(".jpg")
							|| s.equals(".bmp") || s.equals(".gif")) {

						moveFiles(f, jfc, "/Pictures");

					} else if (s.equals(".mp3") || s.equals(".flac")
							|| s.equals(".wmv")) {

						moveFiles(f, jfc, "/Audio");

					} else if (s.equals(".mp4") || s.equals(".avi")
							|| s.equals(".mkv")) {

						moveFiles(f, jfc, "/Video");

					} else {
						moveFiles(f, jfc, "/Other");

					}
					listFiles();
					label.setText(currentFolderFiles.getName());

				}
			}
			// Removing files from computer
			if (remove == e.getSource()) {
				JFileChooser jfc = new JFileChooser();
				int open = jfc.showOpenDialog(null);

				if (open == JFileChooser.APPROVE_OPTION) {
					File f = jfc.getSelectedFile();

					f.delete();
				}

			}
		}
	}

	/**
	 * Printing list of files on panel.
	 */
	public void listFiles() {

		arr = currentFolderFiles.list();
		area.setText("");
		for (int i = 0; i < arr.length; i++) {

			area.append(arr[i] + "\n");
		}
	}

	/**
	 * Method that is used for moving different types of files trough folder
	 * 
	 * @param f
	 *            - represents file
	 * @param jfc
	 *            - represents File Chooser
	 * @param s
	 *            - String s
	 */
	public void moveFiles(File f, JFileChooser jfc, String s) {

		int chooseSave = jfc.showSaveDialog(null);

		if (chooseSave == JFileChooser.APPROVE_OPTION) {
			currentFolderFiles = jfc.getCurrentDirectory();

			File newSubFolder = new File(currentFolderFiles + s);

			if (!newSubFolder.exists()
					&& !currentFolderFiles.getName().equals(
							newSubFolder.getName())) {
				newSubFolder.mkdir();
			}

			if (!currentFolderFiles.getName().equals(newSubFolder.getName())) {

				f.renameTo(new File(newSubFolder + "/" + jfc.getName(f)));

			} else {
				f.renameTo(new File(currentFolderFiles + "/" + jfc.getName(f)));
			}

		}
	}

	/**
	 * Getting extension of file
	 * 
	 * @param s
	 *            - String
	 * @return
	 */
	public static String getExtension(String s) {
		if (s == null) {
			return null;
		}

		int dot = s.lastIndexOf(".");
		if (dot >= 0) {
			return s.substring(dot);
		} else {
			return "";
		}
	}

	public static void main(String[] args) {
		new FileDistribution();
	}
}
