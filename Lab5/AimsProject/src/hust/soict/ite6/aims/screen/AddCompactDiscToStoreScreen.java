//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.store.Store;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    private Button btnAdd;
    private Store store;
    
    public AddCompactDiscToStoreScreen(Store store) {
        super("Add CD");
        this.store = store;
        btnAdd = new Button("Add CD");
        btnAdd.setOnAction(e -> {
        	CompactDisc cd = new CompactDisc(getId(), getTitle(), getCategory(), getCost());
            store.addMedia(cd);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("CD added successfully!");
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
