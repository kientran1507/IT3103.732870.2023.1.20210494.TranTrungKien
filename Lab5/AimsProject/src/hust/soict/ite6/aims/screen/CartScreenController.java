//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import java.util.function.Predicate;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;
import hust.soict.ite6.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {
	
	private Cart cart;
	
	private Store store;
    @FXML
    private MenuItem mnViewCart; 
    
    @FXML
    private MenuItem mnViewStore;
    
    @FXML
    private MenuItem mnAddBook;
    
    @FXML
    private MenuItem mnAddDVD;
    
    @FXML
    private MenuItem mnAddCD;
    
    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterID;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaID;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label lblTotalCost;
    
    @FXML
    private Button btnPlaceOrder;
    

    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    private void initialize() {
        if (cart == null) {
            tblMedia.setItems(FXCollections.observableArrayList());
        }
        
        colMediaID.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("ID"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue,
    						Media newValue) {
    					if(newValue!=null) {
    						updateToolBar(newValue);
    					}
    				}
    			});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>(){
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue,
    				String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    	
        updateTotalCost();
    }
    
    @FXML
    private void viewCartPressed() {
        // Refresh the cart display (if necessary)
        refreshCartDisplay();

        // Inform the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("You are currently viewing the cart.");
        alert.showAndWait();
    }

    private void refreshCartDisplay() {
        // Logic to refresh the cart display (e.g., update the TableView)
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        updateTotalCost();
    }

    
 // Declare a class-level variable to store the reference to the StoreScreen
    private Stage storeStage;

    @FXML
    private void viewStorePressed() {
        // Check if the StoreScreen is already open
        if (storeStage != null && storeStage.isShowing()) {
            storeStage.toFront();  // Bring the StoreScreen to the front if it's already open
            return;
        }

        // Load and display the StoreScreen
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
            		.getResource("/hust/soict/ite6/aims/screen/Store.fxml"));
            StoreScreenController controller = new StoreScreenController(store);
            loader.setController(controller);
            Parent root = loader.load();
            
            // Create the StoreStage and set the scene
            storeStage = new Stage();
            storeStage.setScene(new Scene(root));
            storeStage.setTitle("Store");
            storeStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    private void addDVDPressed() {
    	AddDigitalVideoDiscToStoreScreen dvdScreen = new AddDigitalVideoDiscToStoreScreen(store);
        dvdScreen.show();    
    }
    
    @FXML
    private void addCDPressed() {
    	AddCompactDiscToStoreScreen cdScreen = new AddCompactDiscToStoreScreen(store);
        cdScreen.show();
    }
    
    @FXML
    private void addBookPressed() {
    	AddBookToStoreScreen book = new AddBookToStoreScreen(store);
    	book.show();
    }
    
    void updateToolBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	
        updateTotalCost();
    }
    
    @FXML
    void showFilteredMedia(String filter) {
        Predicate<Media> predicate = media -> {
            if (radioBtnFilterID.isSelected()) {
                return String.valueOf(media.getID()).contains(filter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(filter.toLowerCase());
            }
            return false;
        };

     // Update the table view with the filtered items
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered().filtered(predicate)));
    }

    @FXML
    void PlaceOrder(ActionEvent event) {
    	
    	// Inform the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Order created. Thank you!");
        alert.showAndWait();

        // Clear the cart
        cart.clearCart();

        // Update the total cost label
        updateTotalCost();
    }

    @FXML
    void Play(ActionEvent event) {
        // Implement logic to play selected item
    }

    private void updateTotalCost() {
            float total = cart.totalCost();
            lblTotalCost.setText(String.format("%.2f $", total));
    }
}
