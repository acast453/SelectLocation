/**
 * Anthony Castillo
 * Panther Id: 5910063
 *
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class GraphDisplay extends JPanel implements MouseMotionListener, MouseListener
{
    GeometricObject[] gArray; //geometric objects
    Point begin; //initial point of the selection rectangle
    Rectangle selectionRectangle; //rectangle that the user draws dynamically
    private BufferedImage image;


    /**
     * Parameterized constructor.
     */
    public GraphDisplay(int width, int height, GeometricObject[] g)
    {
        this.gArray = g;
        begin = null;
        selectionRectangle = null;

        addMouseMotionListener(this);
        addMouseListener(this);

        setBackground(Color.white);
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        try
        {
            image = ImageIO.read(new File("src/fiu map.png"));
        }
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        }


    }

    @Override
    public void mouseClicked(MouseEvent e){}

    /**
     * Continuously redefines the second corner of the selection rectangle
     * as the user drags the mouse.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseMoved(MouseEvent e){}

    /**
     * The first corner of the selection rectangle is set in this method.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        begin = new Point(e.getX(), e.getY());
    }

    /**
     * The final value of the second corner of the selection rectangle is set
     * in this method (the first corner was set in mousePressed); range search
     * is then performed.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        begin = null;

        Point[] pArray = Algorithms.inRectangle(gArray, selectionRectangle);

        for(int i=0; i<pArray.length; i++)
        {
            pArray[i].setInteriorColor(Color.green);
        }

        repaint();
    }

    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); //clears window

       Dimension d = getSize();
       g.drawImage(image, 0,0,d.width,d.height,this);

        //draws geometric objects
        if (selectionRectangle != null)
            selectionRectangle.draw(g);

        for (GeometricObject e:gArray)
        {
            e.draw(g); //invokes object's draw method through polymorphism
        }

    }
}
