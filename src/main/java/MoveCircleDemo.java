import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

public class MoveCircleDemo extends Application
{
    private final int N = 25;
    private final int GRID_SIZE = 600;
    private final int DIM = (int) Math.sqrt(GRID_SIZE  * GRID_SIZE/ (N * N));
    private Grid grid;
    private CircleMarker marker;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        grid=new Grid(N,DIM);
        marker= new CircleMarker(DIM);

        int[] array = randomGenerator();
        marker.drawCircle(grid,array);

        InputHBox hBox = new InputHBox();
        hBox.addMoveButtonAction(grid,marker);

        BorderPane borderPane = setupBorderPane(hBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Move the Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int[] randomGenerator() {
        Random rn = new Random();

        int[] array= new int[2];
        array[0]= rn.nextInt(25);
       // System.out.println(array[0]);
        array[1]=rn.nextInt(25);
        //System.out.println(array[1]);
        return array;
    }

    private BorderPane setupBorderPane(HBox hBox) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        borderPane.setCenter(grid);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setAlignment(grid, Pos.CENTER);
        return borderPane;
    }
}
