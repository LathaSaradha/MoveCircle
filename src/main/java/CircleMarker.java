import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.*;


public class CircleMarker extends Circle {

    private int[] coordinates;

    public CircleMarker(int size)
    {
        double r=Math.sqrt(Math.pow(size,2))/Math.PI;
        setRadius(r);
        setStroke(Color.BLACK);
        setFill(Color.BLACK);

        coordinates=new int[2];
        for(int i=0;i<coordinates.length;i++)
        {
            coordinates[i]=0;
        }
    }

    public int[] getCoordinates() {
        return coordinates;
    }

   public void drawCircle(Grid g, int[] coords)
   {
    int x= coords[0];
    int y= coords[1];
     Grid.Cell c=g.getCell(x,y);

       g.getCell(x,y).getChildren().add(this);

      c.setAlignment(this,Pos.CENTER);
      this.coordinates[0]=x;
       this.coordinates[1]=y;

   }

    public void updateLocation(Grid g, int[] coords){

        int x=coords[0];
        int y=coords[1];
        int size=g.getSize();

    if(x<size && y <size && x>=0 && y>=0)
        {
            int currentx=this.coordinates[0];
            int currenty=this.coordinates[1];
            //System.out.println("current cordinates are"+currentx+" "+currenty);
            Grid.Cell c=g.getCell(currentx,currenty);
            g.getChildren().remove(this);

            drawCircle( g, coords);
        }
    //when the entered number of cells go beyond the limit
    else
    {
        JFrame f= new JFrame();
        JOptionPane.showMessageDialog(f, "Invalid Spaces. \n" +
                " Out of Grid");
    }


    }
}
