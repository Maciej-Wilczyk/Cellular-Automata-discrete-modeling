package gui;
import functions1.Functions1;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @FXML
    public AnchorPane pane;

    @FXML
    public TextField textFieldW;

    @FXML
    public TextField textFieldH;

    @FXML
    public TextField textFieldR;

    @FXML
    public TextField textFieldS;

    @FXML
    public ChoiceBox choiceBox;

    Functions1 functions1;

    Group group;
    int sq;
    String choice;

    public void drawSth() {
        functions1 = new Functions1();
        group = new Group();
        choice = choiceBox.getValue().toString();

        sq = Integer.parseInt(textFieldS.getText());

        Rectangle r;
        int width = Integer.parseInt(textFieldW.getText());
        int height = Integer.parseInt(textFieldH.getText());
        int rules = Integer.parseInt(textFieldR.getText());

        int[] firstTab = functions1.makeFirstTable(width);

        int[] newTab = null;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    if (firstTab[j] == 1) {

                        r = new Rectangle(j * sq, 0, sq, sq);
                        r.setFill(Color.BLACK);
                        group.getChildren().add(r);
                    }
                } else {

                    if (newTab[j] == 1) {
                        r = new Rectangle(j * sq, i * sq, sq, sq);
                        r.setFill(Color.BLACK);
                        group.getChildren().add(r);
                    }
                }
            }
            if (i == 0 && height > 1) {
                newTab = functions1.makeTable(rules, firstTab, choice);
            } else {
                newTab = functions1.makeTable(rules, newTab, choice);
            }
        }

        pane.getChildren().add(group);
    }

    public void clear() {
        pane.getChildren().remove(group);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(FXCollections.observableArrayList(
                "Ones at the ends", "Periodic"));
        choiceBox.setValue("Ones at the ends");
        sq = 1;
        textFieldS.setText(Integer.toString(sq));
    }
}