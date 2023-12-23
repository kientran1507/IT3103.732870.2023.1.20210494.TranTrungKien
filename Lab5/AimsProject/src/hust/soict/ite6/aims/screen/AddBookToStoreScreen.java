//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.store.Store;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    private Button btnAdd;
    private Store store;
    public AddBookToStoreScreen(Store store) {
        super("Add Book");
        this.store = store;
        btnAdd = new Button("Add Book");
        btnAdd.setOnAction(e -> {
        	Book book = new Book(getId(), getTitle(), getCategory(), getCost());
            store.addMedia(book);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Book added successfully!");
            alert.showAndWait();
            
            stage.close(); 
        });

        VBox root = (VBox) stage.getScene().getRoot();
        root.getChildren().add(btnAdd);
    }

    @Override
    public void show() {
        stage.show();
    }
}
