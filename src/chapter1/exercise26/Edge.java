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
    
    /**
     * @desc Computes the length of this edge: the distance between the 2 points
     * @return double The length of this edge
     */
    public double length()
    {
        return this.b.distanceFromPoint(this.a);
    }
    
    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("[[ Edge Data: ");
        out.append("Point A: ");
        out.append(this.a);
        out.append(" Point B: ");
        out.append(this.b);
        out.append(" Edge Length: ");
        out.append(this.length());
        out.append(" ]]");
        return out.toString();
    }

}
