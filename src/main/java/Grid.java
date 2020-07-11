import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import java.util.Stack;

public class Grid extends GridPane {

    public class Cell extends StackPane {

        private final int size;

        public Cell(int size)
        {
            this.size=size;
            setStyle("-fx-border-color: black");

           this.setPrefSize(size,size);

            //setAlignment(Pos.CENTER);
        }
    }

    private Cell[][]  cells;
    public Grid(int n , int dimension)
    {
        cells = new Cell[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cells[i][j] = new Cell(dimension);
                this.add(cells[i][j], i, j);
            }
        }
    }

    public Cell getCell(int row,int col)
    {
        return this.cells[row][col];
    }

    public int getSize()
    {
        return this.cells.length;
    }

}
