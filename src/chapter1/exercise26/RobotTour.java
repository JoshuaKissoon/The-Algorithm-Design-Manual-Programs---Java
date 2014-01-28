/**
 * @author Joshua Kissoon
 * @desc Class that controls and runs the Robot Tour algorithms
 */
package chapter1.exercise26;

public class RobotTour
{

    private final int numPoints = 20;
    private final int maxPointValue = 100;
    private final Graph g;

    public RobotTour()
    {
        /* Setting up a graph */
        g = new Graph(20);
        for (int i = 0; i < numPoints; i++)
        {
            g.addPoint(new Point(Math.random() * this.maxPointValue, Math.random() * this.maxPointValue));
        }
    }

    /**
     * @desc Execute the Nearest Neighbor Algorithm
     */
    private void runNearestNeighborAlgo()
    {
        NearestNeighborAlgo nna = new NearestNeighborAlgo(new Graph(g));
        nna.executeAlgorithm();

        System.out.println("Total Distance via Nearest Neighbor Algorithm: " + nna.getTotalDistanceTraveled());
        System.out.println("Nearest Neighbor Algorithm Graph: ");
        System.out.println(nna.getTourGraph());
    }

    /**
     * @desc Execute the Closest Pair Algorithm
     */
    private void runClosestPairAlgo()
    {
        ClosestPairAlgo cpa = new ClosestPairAlgo(new Graph(g));
        cpa.executeAlgorithm();

        System.out.println("Total Distance via Closest Pair Algorithm: " + cpa.getTotalDistanceTraveled());
        System.out.println("Closest Pair Algorithm Graph: ");
        System.out.println(cpa.getTourGraph());
    }

    public static void main(String[] args)
    {
        RobotTour rt = new RobotTour();
        rt.runNearestNeighborAlgo();
        rt.runClosestPairAlgo();
    }
}
