//TranTrungKien-20210494
public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		
		// Create new dvd objects and remove some old one from the cart
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Deathly Hallows - Part 1", 
				"Fantasy", "J. K. Rowling", 146, 30.95f);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.removeDigitalVideoDisc(dvd3);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Harry Potter and the Deathly Hallows - Part 2", 
				"Fantasy", "J. K. Rowling", 130, 28.95f);
		anOrder.addDigitalVideoDisc(dvd5);
		anOrder.removeDigitalVideoDisc(dvd1);
		
		// Print total cost of the items in the cart
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
