/**
 * @author Joshua Kissoon
 * @created 20140124
 * @desc A class used to represent a graph
 */
package chapter1.exercise26;

import java.util.ArrayList;

public class Graph
{

    private final ArrayList<Point> points = new ArrayList<>();
    private final ArrayList<Point> visitedPoints = new ArrayList<>();
    private final ArrayList<Point> unvisitedPoints = new ArrayList<>();
    private final ArrayList<Edge> edges = new ArrayList<>();

    public void addPoint(Point p)
    {
        this.points.add(p);
        this.unvisitedPoints.add(p);
    }

    /**
     * @desc Set a point from the unvisited points list as visited
     * @param index The index in the unvisited points List of the point to set as visited
     */
    public void setUnvisitedPointVisited(Integer index)
    {
        try
        {
            Point p = this.unvisitedPoints.get(index);
            this.unvisitedPoints.remove(p);
            this.visitedPoints.add(p);
        }
        catch (NullPointerException e)
        {
            System.out.println("No point exists at the given index in the Unvisited points list.");
        }
    }

    public ArrayList<Point> getPoints()
    {
        return this.points;
    }

    public ArrayList<Point> getUnvisitedPoints()
    {
        return this.unvisitedPoints;
    }

    public ArrayList<Point> getVisitedPoints()
    {
        return this.visitedPoints;
    }

    public void addEdge(Edge e)
    {
        this.edges.add(e);
    }

    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }

}
