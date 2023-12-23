//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private Button btnAdd;
    private Store store;
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super("Add DVD");
        this.store = store;
        btnAdd = new Button("Add DVD");
        btnAdd.setOnAction(e -> {
        	DigitalVideoDisc dvd = new DigitalVideoDisc(getId(), getTitle(), getCategory(), getCost());
            store.addMedia(dvd);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("DVD added successfully!");
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
