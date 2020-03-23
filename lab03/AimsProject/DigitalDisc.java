package lab03.AimsProject;

public class DigitalDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;

	// public DigitalDisc() {
	// }

	// public DigitalDisc(String title) {
	// 	this.title = title;
	// }

	// public DigitalDisc(String title, String category) {
	// 	this.title = title;
	// 	this.category = category;
	// }

	// public DigitalDisc(String title, String category, String directory) {
	// 	this.title = title;
	// 	this.category = category;
	// 	this.directory = directory;
	// }

	public DigitalDisc(String title, String category, String directory, int length, float cost) {
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "DigitalDisc [title=" + title + ", category=" + category + ", directory=" + directory + ", length="
				+ length + ", cost=" + cost + "]";
	}

}
