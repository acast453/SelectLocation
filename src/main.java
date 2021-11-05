/**
 * Anthony Castillo
 * Panther Id: 5910063
 *
 */



import java.awt.Color;
import java.util.Random;
import javax.swing.*;

public class main
{
    public static void main(String[] args)
    {
        new main();
    }

    public main()
    {
        //frame size
        int frameWidth = 1200;
        int frameHeight = 600;

        //Defining the geometric objects that represent the problem data
        int pointNumber = 10000;
        Point[] pArray = new Point[pointNumber];

        //creating a set of random points
        Random rnd = new Random();
        for(int i=0; i<pointNumber; i++)
        {
            double x = rnd.nextInt(frameWidth);
            double y = rnd.nextInt(frameHeight);
            pArray[i] = new Point(x, y);
            pArray[i].setInteriorColor(Color.pink);
        }

        //graphing
        FrameDisplay frame = new FrameDisplay(frameWidth, frameHeight, pArray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
