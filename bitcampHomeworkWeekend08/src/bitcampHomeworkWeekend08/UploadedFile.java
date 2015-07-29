package bitcampHomeworkWeekend08;

import java.io.File;

public class UploadedFile {

	private String name;
	private String extension;
	private double size;
	private File f;

	public UploadedFile(String name, String extension, double size, File f) {
		super();
		this.name = name;
		this.extension = extension;
		this.size = size;
		this.f = f;
	}

}
