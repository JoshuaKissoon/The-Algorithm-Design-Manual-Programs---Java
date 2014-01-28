/**
 * @author Joshua Kissoon
 * @created 20140124
 * @desc A class used to represent a graph
 */
package chapter1.exercise26;

import java.util.ArrayList;

public class Graph
{

    private final ArrayList<Point> points;
    private final ArrayList<Point> visitedPoints;
    private final ArrayList<Point> unvisitedPoints;
    private final ArrayList<Edge> edges;

    /**
     * @desc Constructor for the case no initial number of points is given
     */
    public Graph()
    {
        /* Initialize with 10 points placeholders */
        this(10);
    }

    /**
     * @desc Constructor that initialize all the graph variables
     * @param numPoints The number of points on the graph
     */
    public Graph(int numPoints)
    {
        points = new ArrayList<>();
        visitedPoints = new ArrayList<>();
        unvisitedPoints = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * @desc Basically a method to clone a graph
     * @param g The graph from which to replicate this one
     */
    public Graph(Graph g)
    {
        this.points = new ArrayList<>(g.points);
        this.visitedPoints = new ArrayList<>(g.visitedPoints);
        this.unvisitedPoints = new ArrayList<>(g.unvisitedPoints);
        this.edges = new ArrayList<>(g.edges);
    }

    public void addPoint(Point p)
    {
        this.points.add(p);
        this.unvisitedPoints.add(p);
    }

    /**
     * @desc Set a point from the unvisited points list as visited
     * @param p The point we have just visited
     */
    public void setPointVisited(Point p)
    {
        try
        {
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

    public ArrayList<Point> getVisitedPoints()
    {
        return this.visitedPoints;
    }

    public ArrayList<Point> getUnvisitedPoints()
    {
        return this.unvisitedPoints;
    }

    /**
     * @desc Finds the closest unvisited point to a given point p
     * @param from The point from which we need to find the closest point
     *
     * @return Point The point closest to the input point
     */
    public Point getClosestUnvisitedPoint(Point from)
    {
        Point closest = this.unvisitedPoints.get(0);

        /* Yes, point 0 will be checked twice... less code this way */
        for (Point p : this.unvisitedPoints)
        {
            if (from.distanceFromPoint(closest) > from.distanceFromPoint(p))
            {
                /* If p is closer to from, then we make p the new closest */
                closest = p;
            }
        }
        return closest;
    }

    public void addEdge(Edge e)
    {
        this.edges.add(e);
    }

    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("Number of Points: ");
        out.append(this.points.size());
        out.append("\n************** POINTS **************** \n ");
        out.append(this.points);
        out.append("\n\nNumber of Visited Points: ");
        out.append(this.visitedPoints.size());
        out.append("\n************* VISITED POINTS ****************\n");
        out.append(this.visitedPoints);
        out.append("\n\nNumber of Unvisited Points: ");
        out.append(this.unvisitedPoints.size());
        out.append("\n ************* UNVISITED POINTS ****************\n");
        out.append(this.unvisitedPoints);
        out.append("\n\nNumber of Edges: ");
        out.append(this.edges.size());
        out.append("\n ************* EDGES ****************\n");
        out.append(this.edges);
        return out.toString();
    }
}
