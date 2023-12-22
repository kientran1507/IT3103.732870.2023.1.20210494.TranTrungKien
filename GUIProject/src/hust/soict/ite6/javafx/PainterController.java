package hust.soict.ite6.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;
    
    @FXML
    private ToggleGroup Tools;
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    
    private boolean isDrawing = true; // Default to drawing mode
    @FXML
    void initialize() {
        penButton.setToggleGroup(Tools);
        eraserButton.setToggleGroup(Tools);
        Tools.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == penButton) {
                isDrawing = true;
            } else if (newVal == eraserButton) {
                isDrawing = false;
            }
        });
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isDrawing) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            Circle eraserCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(eraserCircle);
        }
    }
}
