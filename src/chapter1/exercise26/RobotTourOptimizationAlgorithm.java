/**
 * @author Joshua Kissoon
 * @desc Interface for all Robot Tour Optimization Algorithms
 */
package chapter1.exercise26;

public interface RobotTourOptimizationAlgorithm
{
    /**
     * @desc Executes the algorithm
     */
    public void executeAlgorithm();
    
    /**
     * @desc Method that computes the total distance traveled
     * @return double The total distance traveled
     */
    public double getTotalDistanceTraveled();
    
    /**
     * @return The graph plotted by the Algorithm for the tour
     */
    public Graph getTourGraph();
}
