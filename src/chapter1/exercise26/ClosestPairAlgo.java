/**
 * @author Joshua Kissoon
 * @created 20130124
 * @desc Implementation of the Closest Pair Algorithm
 */
package chapter1.exercise26;

public final class ClosestPairAlgo implements RobotTourOptimizationAlgorithm
{

    private final Graph tourGraph;

    /**
     * @desc We initialize the tour graph to an input graph in this constructor
     * @param initialGraph The graph we start with
     */
    public ClosestPairAlgo(Graph initialGraph)
    {
        this.tourGraph = initialGraph;
    }

    /**
     * Here we actually execute the Closest pair algorithm
     */
    @Override
    public void executeAlgorithm()
    {
        /* Get n: the number of points in the set P of points */
        int n = this.tourGraph.getPoints().size();
        
        double d = 99999999d;

        /* For i=1 to n do */
        for (int i = 1; i < (n - 1); i++)
        {
            
        }

    }

    @Override
    public Graph getTourGraph()
    {
        return this.tourGraph;
    }

    @Override
    public double getTotalDistanceTraveled()
    {
        double totalDistance = 0d;

        return totalDistance;
    }

}
