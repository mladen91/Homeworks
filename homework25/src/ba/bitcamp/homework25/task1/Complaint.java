package ba.bitcamp.homework25.task1;

/**
 * This class represents one complaint that has id, timeDate and text
 * attributes. It is used for GUI application for inserting data into database,
 * and selecting them
 * 
 * @author Mladen13
 *
 */
public class Complaint {

	private int id;
	private String timeDate;
	private String text;

	/**
	 * Getting id from database
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setting id that will be send to database
	 * 
	 * @param id
	 *            - represents complaint id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting time and date when complaint has been saved from database
	 * 
	 * @return
	 */
	public String getTimeDate() {
		return timeDate;
	}

	/**
	 * Setting time and date when data has been recorded to database
	 * 
	 * @param timeDate
	 *            - represents time and date as string
	 */
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	/**
	 * Getting complaint text from database
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setting complaint text into database
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {

		return "ID: " + id + " Time and Date: " + timeDate + " Complaint: "
				+ text + "\n";
	}
}

