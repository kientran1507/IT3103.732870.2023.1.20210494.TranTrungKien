//TranTrungKien-20210494

package hust.soict.ite6.aims;

import java.util.Scanner;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;
import hust.soict.ite6.aims.store.Store;

public class Aims {
	// Scanner for user input
    private static final Scanner scanner = new Scanner(System.in);
    
    // Store and cart instances
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    
    // Main method
    public static void main(String[] args) {
    	
    	// Variable to store user's choice
        int choice;
        
        // Display menu and process user input until they choose to exit
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
    }
    
    // Display main menu
    private static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }
    
    // Method to view the store and interact with store-related options
    private static void viewStore() {
    	store.displayStore();
        storeMenu();
        
        // Variable to store user's choice
        int choice;
        
        // Display store menu and process user input until they choose to go back to the main menu
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
    }
    
    // Display store-specific menu
    public static void storeMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. See a media’s details");
    	System.out.println("2. Add a media to cart");
    	System.out.println("3. Play a media");
    	System.out.println("4. See current cart");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4");
    	}

    // Method to see details of a specific media in the store
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine().toLowerCase();
        
        // Use the searchMediaByTitle method to get the Media object
        Media foundMedia =  store.searchMediaByTitle(title.toLowerCase());
        		
        // Check if the media was found before proceeding
        if (foundMedia != null) {
            // Display media details
            System.out.println("Details:");
            System.out.println(foundMedia);

            // Show the media details menu
            mediaDetailsMenu();
            
            // Variable to store user's choice
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (userChoice) {
                case 1:
                    cart.addMedia(foundMedia);
                    break;
                case 2:
                    if (foundMedia instanceof Playable) {
                        Playable playableMedia = (Playable) foundMedia;
                        playableMedia.play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to store menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else System.out.println("This media is not in the store");
    }

    // Display media details-specific menu
    public static void mediaDetailsMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");
    }
    
    // Method to add a specific media to the cart
    private static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine().toLowerCase();
        
        // Use the searchMediaByTitle method to get the Media object
        Media foundMedia =  store.searchMediaByTitle(title.toLowerCase());
        		
        // Check if the media was found before proceeding
        if (foundMedia != null) {
        	cart.addMedia(foundMedia);
        } else System.out.println("This media is not in the store");
    }

    // Method to play a specific media
    private static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine().toLowerCase();
        
        // Use the searchMediaByTitle method to get the Media object
        Media foundMedia =  store.searchMediaByTitle(title.toLowerCase());
        		
        // Check if the media was found before proceeding
        if (foundMedia != null) {
        	if (foundMedia instanceof Playable) {
                Playable playableMedia = (Playable) foundMedia;
                playableMedia.play();
        	} else {
                System.out.println("This media is not playable.");
        	}
        } else System.out.println("This media is not in the store");
    }

    // Method to update the store by adding or removing media
    private static void updateStore() {
    	
    	// Variable to store user's choice
        int updateChoice;
        
        // Display update store menu and process user input until they choose to go back to the main menu
        do {
            displayUpdateStoreMenu();
            System.out.print("Enter your choice: ");
            updateChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (updateChoice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (updateChoice != 0);
    }
    
    // Display update store-specific menu
    private static void displayUpdateStoreMenu() {
        System.out.println("Update Store Menu:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to the store");
        System.out.println("2. Remove media from the store");
        System.out.println("0. Back to main menu");
        System.out.println("--------------------------------");
    }

    // Method to add new media to the store
    private static void addMediaToStore() {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();

        // Additional details depending on the type of media
        System.out.print("Enter the category of the media: ");
        String category = scanner.nextLine();

        System.out.print("Enter the cost of the media: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        // Choose the type of media to add (DVD, CD, Book) and create an instance
        System.out.println("Choose the type of media to add:");
        System.out.println("1. Digital Video Disc (DVD)");
        System.out.println("2. Compact Disc (CD)");
        System.out.println("3. Book");
        System.out.print("Enter your choice: ");
        
        // Variable to store user's choice
        int mediaTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Media newMedia = null;

        switch (mediaTypeChoice) {
            case 1:
                // For DVD, you might need additional details like director, length
                System.out.print("Enter the director of the DVD: ");
                String director = scanner.nextLine();

                System.out.print("Enter the length of the DVD: ");
                int length = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                newMedia = new DigitalVideoDisc(title, category, director, length, cost);
                break;
            case 2:
                // For CD, you might need additional details like artist, tracks
                System.out.print("Enter the artist of the CD: ");
                String artist = scanner.nextLine();

                newMedia = new CompactDisc(title, category, cost, 0, artist); // Assuming CD length is not needed for now
                break;
            case 3:
                // For Book, you might need additional details like authors
                System.out.print("Enter the author of the book: ");
                String author = scanner.nextLine();

                newMedia = new Book(title, category, author, cost);
                break;
            default:
                System.out.println("Invalid choice. Media not added to the store.");
                return; // Exit the method if the choice is invalid
        }

        // Add the new media to the store
        store.addMedia(newMedia);
        System.out.println("Media added to the store.");
    }

    // Method to remove media from the store
    private static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine().toLowerCase();

        // Use the searchMediaByTitle method to get the Media object
        Media foundMedia = store.searchMediaByTitle(title.toLowerCase());

        // Check if the media was found before proceeding
        if (foundMedia != null) {
            System.out.print("Are you sure you want to remove this media from the store? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();
            if (confirmation.equals("yes")) {
                store.removeMedia(foundMedia.getID());
                System.out.println("Media removed from the store.");
            } else {
                System.out.println("Media removal canceled.");
            }
        } else {
            System.out.println("This media is not in the store.");
        }
    }


    // Method to see the current items in the cart
    private static void seeCurrentCart() {
    	cart.printOrder();
        cartMenu();
        
        // Variable to store user's choice
        int choice;
        
        // Display cart menu and process user input until they choose to go back to the main menu
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
    }
    
    // Display cart menu
    public static void cartMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Filter medias in cart");
    	System.out.println("2. Sort medias in cart");
    	System.out.println("3. Remove media from cart");
    	System.out.println("4. Play a media");
    	System.out.println("5. Place order");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // Method to filter all the media in the cart
    private static void filterMediasInCart() {
    	
    	// Choose between 2 filter options: by ID or by Title
        System.out.println("Filter Options:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");

        // Variable to store user's choice
        int filterChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (filterChoice) {
            case 1:
                filterMediaInCartById();
                break;
            case 2:
                filterMediaInCartByTitle();
                break;
            case 0:
                System.out.println("Returning to cart menu.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
    
    // Method to filter all the media in the cart by ID
    private static void filterMediaInCartById() {
        System.out.print("Enter the ID to filter by: ");
        
        // Variable to store user's choice
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Use the Cart's searchByID method to find the media by ID
        cart.searchByID(id);
    }

    // Method to filter all the media in the cart by title
    private static void filterMediaInCartByTitle() {
        System.out.print("Enter the title to filter by: ");
        
        // Variable to store user's choice
        String title = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character

        // Use the Cart's searchByTitle method to find the media by title
        cart.searchByTitle(title);
    }

    // Method to sort media in the cart
    private static void sortMediasInCart() {

    	// Choose between 2 sort options: by title or by cost
        System.out.println("Sort Options:");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");

        // Variable to store user's choice
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (sortChoice) {
            case 1:
                cart.sortMediaByTitleCost();
                System.out.println("Cart sorted by title.");
                break;
            case 2:
                cart.sortMediaByCostTitle();
                System.out.println("Cart sorted by cost.");
                break;
            case 0:
                System.out.println("Returning to cart menu.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    // Method to remove media from cart
    private static void removeMediaFromCart() {
    	
    	// Choose between 2 remove options: remove only one media or clear all 
        System.out.println("Remove Options:");
        System.out.println("1. Remove a specific media by title");
        System.out.println("2. Clear the entire cart");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        
        // Variable to store user's choice
        int removeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        switch (removeChoice) {
        	case 1:
                System.out.print("Enter the title of the media: ");
                String title = scanner.nextLine().toLowerCase();
                scanner.nextLine(); // Consume the newline character
                
                // Use the Cart's removeMediaByTitle method to find the media by title
                cart.removeMediaByTitle(title);
                break;
            case 2:
            	// Clear the cart
                cart.clearCart();
                System.out.println("Cart cleared.");
                break;
            case 0:
                System.out.println("Returning to cart menu.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }


    private static void placeOrder() {
        // Implementation to place an order
        System.out.println("Order created. Thank you!");
        cart.clearCart(); // Clear the cart after placing the order
    }
}
