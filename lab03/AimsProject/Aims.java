package lab03.AimsProject;

public class Aims {
    public static void main(String[] args) {
		Order anOrder = new Order();

		DigitalDisc dvd1 = new DigitalDisc("The Lion King", "Animation", "Roger Allers", 86, 19.95f);
		anOrder.addDigitalDisc(dvd1);

		DigitalDisc dvd2 = new DigitalDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		anOrder.addDigitalDisc(dvd2);

		DigitalDisc dvd3 = new DigitalDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
		anOrder.addDigitalDisc(dvd3);
		anOrder.addDigitalDisc(dvd3);
		anOrder.removeDigitalDisc(dvd3);
		anOrder.addDigitalDisc(dvd3);

		System.out.println("Total orders: " + anOrder.getQtyOrdered());
        System.out.format("Total Cost is: %.2f$\n", anOrder.totalCost());
    }
}