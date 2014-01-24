/**
 * @author Joshua Kissoon
 * @date 20140124
 * @desc An Implementation of the Nearest Neighbor Algorithm
 */
package chapter1.exercise26;

public final class NearestNeighborAlgo implements RobotTourOptimizationAlgorithm
{

    private Point initialPoint;
    private Point currentPoint, nextPoint;
    private int i;
    private final Graph tourGraph;

    public NearestNeighborAlgo(Graph tourGraph)
    {
        this.tourGraph = tourGraph;
    }

    @Override
    public void executeAlgorithm()
    {
        System.out.println("***************** NEAREST NEIGHBOUR ALGORITHM EXECUTION STARTED ************************");
        /* Pick and visit an initial point p0 from P */
        initialPoint = tourGraph.getUnvisitedPoints().get(0);
        tourGraph.setPointVisited(initialPoint);
        System.out.println("Initial/Starting Point Visited: " + initialPoint);

        /* Set Current Point and initialize counter */
        currentPoint = initialPoint;
        i = 0;

        /* While there are still unvisited points, create edges */
        while (!tourGraph.getUnvisitedPoints().isEmpty())
        {
            i++;
            nextPoint = tourGraph.getClosestUnvisitedPoint(currentPoint);
            System.out.println("Next Point Visited: " + nextPoint + ". Distance between points: " + currentPoint.distanceFromPoint(nextPoint));

            /* Visit the next point by creating an edge between the current point and the next point */
            tourGraph.addEdge(new Edge(currentPoint, nextPoint));

            /* Now we have moved to nextPoint, so nextPoint becomes our current point */
            currentPoint = nextPoint;

            /* Now we set that we have visited our current point */
            tourGraph.setPointVisited(currentPoint);
        }

        /* After visiting all points, return to the initial point from the current point. We do this by creating an edge between these points. */
        tourGraph.addEdge(new Edge(currentPoint, initialPoint));
        System.out.println("Creating edge between the current point " + currentPoint + " and the Starting point " + initialPoint);
        System.out.println("***************** NEAREST NEIGHBOUR ALGORITHM EXECUTION COMPLETED ************************");
    }
}
