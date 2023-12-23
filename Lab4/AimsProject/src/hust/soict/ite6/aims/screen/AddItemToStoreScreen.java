//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AddItemToStoreScreen {
    protected Stage stage;
    protected TextField tfTitle;
    protected TextField tfCategory;
    protected TextField tfCost;
    protected TextField tfID;
    
    public AddItemToStoreScreen(String title) {
        stage = new Stage();
        stage.setTitle(title);

        VBox root = new VBox(10);
        root.setPadding(new javafx.geometry.Insets(10));
        
        Label lblID = new Label("ID:");
        tfID = new TextField();
        root.getChildren().addAll(lblID, tfID);
        
        Label lblTitle = new Label("Title:");
        tfTitle = new TextField();
        root.getChildren().addAll(lblTitle, tfTitle);

        Label lblCategory = new Label("Category:");
        tfCategory = new TextField();
        root.getChildren().addAll(lblCategory, tfCategory);

        Label lblCost = new Label("Cost:");
        tfCost = new TextField();
        root.getChildren().addAll(lblCost, tfCost);

        stage.setScene(new Scene(root, 300, 300));
    }

    public abstract void show();

    public String getTitle() {
        return tfTitle.getText();
    }

    public String getCategory() {
        return tfCategory.getText();
    }

    public float getCost() {
        try {
            return Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }

    public int getId() {
        try {
            return Integer.parseInt(tfID.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
