/**
 * @author Joshua Kissoon
 * @created 20140128
 * @desc Class that provides methods for integer division without using * or /
 * @results After simple testing, the fast method is way faster (thousands of times faster for large numbers) than the simple method
 * @copyright Joshua Kissoon
 */
package chapter1.exercise28;

public class Divisor
{

    /**
     * @desc Computes the dividend of y/x without the use of * or / in a fast way
     * @desc This is my method to compute the quotient, it will be much faster than constantly subtracting the divisor from the dividend
     * @param y the dividend
     * @param x the divisor
     *
     * @return the dividend y/x
     */
    public int getQuotientFast(int y, int x)
    {
        int quotient = 1, x2 = x;

        /* We keep multiplying x by 2 and seeing if it divides y... of course we need to multiply the quotient by 2 also if it does divide y */
        while ((x2 + x2) < y)
        {
            x2 += x2;
            quotient += quotient;
            //System.out.println("Quotient: " + quotient + "X2: " + x2);
        }

        /* Now we have come to some value around half of y, so we need to subtract that value from y, and recursively run the method */
        y -= x2;
        // System.out.println("Finished while loop, new y value: " + y);

        if ((x + x) <= y)
        {
            //System.out.println("Recursively calling getQuotient with y: " + y + " and x: " + x);
            quotient += this.getQuotientFast(y, x);
        }
        else if (x <= y)
        {
            /* If there is no recursion needed, we check if */
            quotient++;
            y -= x;
        }

        return quotient;
    }

    /**
     * @desc Computes the dividend of y/x without the use of * or / in a very simple way
     * @param y the dividend
     * @param x the divisor
     *
     * @return the dividend y/x
     */
    public int getQuotientSimple(int y, int x)
    {
        int quotient = 0;
        while (y >= x)
        {
            quotient++;
            y -= x;
        }

        return quotient;
    }

    public static void main(String[] args)
    {
        Divisor div = new Divisor();
        int y = 999985347, x = 49;
        long startTime, endTime, duration;  // Variables to test the duration of methods 

        /* Running the simple method */
        startTime = System.nanoTime();
        int quotient2 = div.getQuotientSimple(y, x);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("The quotient of y: " + y + " and x: " + x + " using the simple method is: " + quotient2);
        System.out.println("Simple method execution time: " + duration);

        /* Running the fast method */
        startTime = System.nanoTime();
        int quotient = div.getQuotientFast(y, x);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("The quotient of y: " + y + " and x: " + x + " using the fast method is: " + quotient);
        System.out.println("Fast method execution time: " + duration);
    }
}
