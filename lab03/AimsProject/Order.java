package lab03.AimsProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;

//	private DigitalDisc itemsOrdered[] = new DigitalDisc[MAX_NUMBER_ORDERED];
	private List<DigitalDisc> itemsOrdered = new ArrayList<>();
	private int qtyOrdered;

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public void addDigitalDisc(DigitalDisc disc) {
		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(disc);
			qtyOrdered = itemsOrdered.size();
			System.out.format("The disc \"%s\" has been added\n", disc.getTitle());
		} else {
			System.out.println("The order is full");
		}
	}

	public void removeDigitalDisc(DigitalDisc disc) {
		if (qtyOrdered != 0) {
			itemsOrdered = itemsOrdered.stream().filter(d -> d != disc).collect(Collectors.toList());
			qtyOrdered = itemsOrdered.size();
			System.out.format("The disc \"%s\" has been removed\n", disc.getTitle());
		} else {
			System.out.println("Order is empty. Please add!");
		}
	}

	public double totalCost() {
		return itemsOrdered.stream().mapToDouble(d -> d.getCost()).sum();
	}

}
