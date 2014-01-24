/**
 * @author Joshua Kissoon
 * @created 20140124
 * @desc A class used to represent an Edge on a graph
 */
package chapter1.exercise26;

public final class Edge
{

    private final Point a, b;

    public Edge(Point a, Point b)
    {
        this.a = a;
        this.b = b;
    }

    public Point getA()
    {
        return this.a;
    }

    public Point getB()
    {
        return this.b;
    }

}
