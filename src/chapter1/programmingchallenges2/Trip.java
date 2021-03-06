/**
 * @author Joshua Kissoon
 * @created 20140201
 * @desc Solution for this problem: http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110103&format=html
 */
package chapter1.programmingchallenges2;

import java.util.ArrayList;

public class Trip
{

    private final ArrayList<Double> amountsPaid;
    private final Integer numStudents;

    /**
     * @param amountsPaid An ArrayList containing the amount spent by the students
     * @param numStudents the total number of students
     */
    public Trip(ArrayList<Double> amountsPaid, Integer numStudents)
    {
        this.amountsPaid = amountsPaid;
        this.numStudents = numStudents;
    }

    /**
     * @desc Compute the total amount to be exchanged to equalize the student's costs
     * @solution
     * - Add the costs to get total cost (TC);
     * - find average of TC
     * - Total to be paid = (sum of amounts > average) - (#amounts > average * average)
     *
     * @return Double the total amount to be exchanged between students to equalize their costs
     */
    public Double computeTotalExchangeAmount()
    {
        Double totalCost = 0d;
        for (Double amount : this.amountsPaid)
        {
            totalCost += amount;
        }

        Double averageCost = totalCost / this.numStudents;

        /**
         * @desc Get the above the average cost
         * @note There is no need to look at those students who are already average since in the end, all need to be at average
         * @variable numStudentsGTAvgCost is needed here since they have to pay the difference
         */
        Integer numStudentsGTAvgCost = 0;
        Double sumGTAverageCost = 0d;
        for (Double amount : this.amountsPaid)
        {
            if (amount > averageCost)
            {
                sumGTAverageCost += amount;
                numStudentsGTAvgCost++;
            }
        }

        return sumGTAverageCost - (averageCost * numStudentsGTAvgCost);
    }
}
