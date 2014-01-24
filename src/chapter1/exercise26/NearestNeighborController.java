/**
 * @author Joshua Kissoon
 * @desc Class that controls and runs the Nearest Neighbor algorithm
 */

package chapter1.exercise26;

public class NearestNeighborController
{
    public static void main(String[] args)
    {
        /* Setting up a graph */
        Graph g = new Graph(20);
        g.addPoint(new Point(4, 81));
        g.addPoint(new Point(10, 34));
        g.addPoint(new Point(14, 56));
        g.addPoint(new Point(3, 1));
        g.addPoint(new Point(34, 90));
        g.addPoint(new Point(22, 87));
        g.addPoint(new Point(54, 35));
        g.addPoint(new Point(21, 56));
        g.addPoint(new Point(76, 25));
        g.addPoint(new Point(89, 68));
        g.addPoint(new Point(33, 98));
        g.addPoint(new Point(45, 77));
        g.addPoint(new Point(67, 63));
        g.addPoint(new Point(78, 49));
        g.addPoint(new Point(89, 56));
        
        NearestNeighborAlgo nna = new NearestNeighborAlgo(g);
        nna.executeAlgorithm();
        
    }
}
