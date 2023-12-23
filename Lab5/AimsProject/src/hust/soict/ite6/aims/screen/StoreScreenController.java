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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StoreScreenController  {
	
	private Store store;
	
	private Cart cart;
	
    @FXML
    private MenuItem mnViewCart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaID;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private MenuItem mnViewStore;
    
    @FXML
    private MenuItem mnAddBook;
    
    @FXML
    private MenuItem mnAddDVD;

    @FXML
    private MenuItem mnAddCD;
    
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfSearch;

    public StoreScreenController(Store store) {
    	super();
    	this.store = store;
    }
    
    @FXML
    private void initialize() {
    	
    	colMediaID.setCellValueFactory(
     			new PropertyValueFactory<Media, Integer>("id"));
     	colMediaTitle.setCellValueFactory(
     			new PropertyValueFactory<Media, String>("title"));
     	colMediaCategory.setCellValueFactory(
     			new PropertyValueFactory<Media, String>("category"));
     	colMediaCost.setCellValueFactory(
     			new PropertyValueFactory<Media, Float>("cost"));
    	
     	tblMedia.setItems(store.getItemsInStore());
     	
     	btnAdd.setVisible(false);
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
    	
    	tfSearch.textProperty().addListener(new ChangeListener<String>(){
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue,
    				String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    }
    
    @FXML
    private void viewCartPressed() {
    	// Load and display the StoreScreen
        try {
            FXMLLoader loader = new FXMLLoader(getClass().
            		getResource("/hust/soict/ite6/aims/screen/Cart.fxml"));
            CartScreenController controller = new CartScreenController(cart);
			loader.setController(controller);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    private void viewStorePressed() {
        
        // Inform the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("You are currently viewing the store.");
        alert.showAndWait();
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
    
    @FXML
    private void showFilteredMedia(String filter) {
        // Filter the items in the store based on the entered title
        Predicate<Media> predicate = media -> media.getTitle().toLowerCase().contains(filter.toLowerCase());

        // Update the table view with the filtered items
        tblMedia.setItems(FXCollections.observableArrayList(store.getItemsInStore().filtered(predicate)));
    }
    
    void updateToolBar(Media media) {
    	btnRemove.setVisible(true);
    	btnAdd.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	store.removeMedia(media.getID());
    }
    
    @FXML
    void btnAddToCartPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.addMedia(media);
        
        // Inform the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(media.getTitle() + " has been added to the cart.");
        alert.showAndWait();
        
        store.removeMedia(media.getID());
    }
}
