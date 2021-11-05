/**
 * Anthony Castillo
 * Panther Id: 5910063
 *
 */





import java.util.ArrayList;

/**
 * This class implements several algorithms.
 */
public class Algorithms
{
    /**
     * Determines the closest pair of points. Brute-force solution is used.
     *
     * @param points input points. Array is assumed to be fully populated.
     * @param indices output array containing indices of closest pair
     */
    public static void closestPairOfPoints(Point[] points, int[] indices)
    {
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<points.length; i++)
        {
            for (int j=i+1; j<points.length; j++)
            {
                double d = points[i].distance(points[j]);
                if (d<minDistance)
                {
                    minDistance = d;
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
    }

    /**
     * For the given list of geometric objects (points) and rectangle, finds
     * points that are contained in the given rectangle.
     *
     * @param g list of geometric objects (points)
     * @param r rectangle
     *
     * @return array of points from g contained in r
     */
    public static Point[] inRectangle(GeometricObject[] g, Rectangle r)
    {
        int inputLength = g.length; //number of points in input array
        Point[] pArray = (Point[])g; //input points

        K2Tree k2Tree = new K2Tree();
        for(int i=0; i<inputLength; i++)
        {
            k2Tree.add(pArray[i]);
        }

        ArrayList<Point> pList = k2Tree.pointsInRange(r);
        Point[] output = pList.toArray(new Point[pList.size()]);

        return output;
    }
}
