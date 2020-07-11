import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import javax.swing.*;

public class InputHBox extends HBox
{
    private Label directionLabel;
    private Label spacesLabel;
    private TextField directionText;
    private TextField spacesText;
    private Button btnMove;

    public InputHBox() {
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 0, 0, 10));
        createAndAddChildren();
    }

    private void createLabels() {
        this.directionLabel = new Label("Direction (U/D/L/R)");
        this.spacesLabel = new Label("Number of Spaces");
    }

    private void createTextFields() {
        this.directionText = new TextField();
        this.spacesText = new TextField();
        this.directionText.setPrefWidth(30);
        this.spacesText.setPrefWidth(50);
    }

    private void createMoveButton() {
        this.btnMove = new Button("Move");
    }

    private void createAndAddChildren() {
        createLabels();
        createTextFields();
        createMoveButton();
        getChildren().addAll(this.directionLabel, this.directionText,
                             this.spacesLabel, this.spacesText, this.btnMove);
    }

    public void addMoveButtonAction(Grid g, CircleMarker cm)
    {

        btnMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CharSequence characters = directionText.getCharacters();
                try {
                    char c = characters.charAt(0);

                    CharSequence spacesTextCharacters = spacesText.getCharacters();
                    int spaces = Integer.parseInt(spacesTextCharacters.toString());

                    int[] res = Direction.getNewCoordinatesForDirection(c, cm.getCoordinates(), spaces);
                    //System.out.println(res[0] + " " + res[1]);
                    if (c == ('U') || c == ('D') || c == ('L') || c == ('R')) {
                         cm.updateLocation(g, res);

                    }
                }
                catch(StringIndexOutOfBoundsException | IllegalArgumentException s)
                {JFrame f= new JFrame();
                   JOptionPane.showMessageDialog(f, "Invalid Choice. \n" +
                      " Only U/D/L/R accepted");
                }
                catch(ArrayIndexOutOfBoundsException ae)
                {
                 JFrame f= new JFrame();
                  JOptionPane.showMessageDialog(f, "Invalid Spaces. \n" +
                        " Out of Grid");
                }
                directionText.clear();
                spacesText.clear();
            }

        });


    }
}
