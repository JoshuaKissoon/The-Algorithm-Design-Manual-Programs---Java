/**
 * @author Joshua Kissoon
 * @created 20140201
 * @desc Controlling class for the Trip
 */
package chapter1.programmingchallenges2;

import java.util.ArrayList;
import java.util.Scanner;

public class TripController
{

    public static void main(String[] args)
    {
        ArrayList<Double> amountsPaid;
        Scanner in = new Scanner(System.in);

        Integer numStudents = in.nextInt();

        /* Loop until the termination operator is entered */
        while (numStudents != 0)
        {
            /* Now we need to do the computation for numStudents students */
            amountsPaid = new ArrayList<>(numStudents);

            /* Collect the amountsPaid for these students */
            for (int i = 0; i < numStudents; i++)
            {
                amountsPaid.add(in.nextDouble());
            }

            /* Now we have all data, lets do the computation */
            Trip trip = new Trip(amountsPaid, numStudents);
            System.out.println("$" + trip.computeTotalExchangeAmount());

            /* Read in the next numStudents value */
            numStudents = in.nextInt();
        }

        System.exit(0);
    }
}
