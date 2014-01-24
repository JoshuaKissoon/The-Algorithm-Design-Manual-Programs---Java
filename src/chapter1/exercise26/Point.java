/**
 * @author Joshua Kissoon
 * @created 20140124
 * @desc A class that represents a Point
 */
package chapter1.exercise26;

public final class Point
{

    private final int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    /**
     * @desc Computes the distance between this point and some other point by adding the x and y differences
     * The distance is computed using the Pythagoras theorem based distance formula: distance = sqrt(sqr(x2-x1) + sqr(y2-y1))
     * @param from The point from which we compute the distance
     *
     * @return double Value for the distance between points
     */
    public double distanceFromPoint(Point from)
    {
        Double xDiff = (double) (this.x - from.x);
        Double yDiff = (double) (this.y - from.y);
        Double xSqr = Math.pow(xDiff, 2);
        Double ySqr = Math.pow(yDiff, 2);
        return Math.sqrt(xSqr + ySqr);
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("Point (");
        out.append(this.x);
        out.append(", ");
        out.append(this.y);
        out.append(")");
        return out.toString();
    }
}
