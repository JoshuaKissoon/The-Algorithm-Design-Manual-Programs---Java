/**
 * @author Joshua Kissoon
 * @created 20140128
 * @desc Controller file for running the 3N + 1 Algorithm to solve the input cases
 */
package chapter1.programmingchallenges1;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoController
{

    public static void main(String args[])
    {
        ArrayList<String> output = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (line != null && !line.equals(""))
        {
            /* Do the computations for the given line of input */
            String[] parts = line.split(" ");
            Integer i = Integer.parseInt(parts[0]);
            Integer j = Integer.parseInt(parts[1]);

            /* Loop through and run the algorithm on each of the integers between these numbers */
            int maxCycleLength = 0;
            for (int x = i; x <= j; x++)
            {
                The3NPlus1Algo algo = new The3NPlus1Algo(x);
                algo.generateSequence();

                /* Get the Max Cycle Length */
                if (algo.getSequence().size() > maxCycleLength)
                {
                    maxCycleLength = algo.getSequence().size();
                }
            }
            output.add(line.concat(" " + maxCycleLength));

            /* Read the next line */
            line = in.nextLine();
        }

        for (String s : output)
        {
            System.out.println(s);
        }
    }
}
