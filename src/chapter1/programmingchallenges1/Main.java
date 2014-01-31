/**
 * @author Joshua Kissoon
 * @created 20140128
 * @file Used for submission on programming-challenges.com WITHOUT ANY SUCCESS... I'm not sure why!
 * @desc This file contains the same logic as the Main.java + The3NPlus1Algo.java combined. Here I try to optimize the speed of the algorithm by removing some neatness and variables
 */
package chapter1.programmingchallenges1;

import java.io.IOException;
import java.util.StringTokenizer;

class Main implements Runnable
{

    /**
     * @desc Here we generate the sequence of numbers
     * @param n
     *
     * @return
     */
    public int getCycleLength(int n)
    {
        int cycleLength = 1;
        while (n != 1)
        {
            if ((n % 2) == 0)
            {
                n /= 2;
            }
            else
            {
                n = (n * 3) + 1;
            }
            cycleLength++;
        }

        return cycleLength;
    }

    @Override
    public void run()
    {
        String input;
        StringTokenizer idata;
        int i, j;
        int counter = 0;

        input = Main.ReadLn(255);
        while ((input != null) && !input.equals(""))
        {
            idata = new StringTokenizer(input);
            i = Integer.parseInt(idata.nextToken());
            j = Integer.parseInt(idata.nextToken());

            /* Loop through and run the algorithm on each of the integers between these numbers */
            int maxCycleLength = 0;
            for (int x = i; x <= j; x++)
            {
                /* Get the Max Cycle Length */
                int cl = this.getCycleLength(x);
                if (cl > maxCycleLength)
                {
                    maxCycleLength = cl;
                }
            }
            if (counter != 0)
            {
                System.out.print("\n");
            }
            counter++;
            System.out.print(input.concat(" " + maxCycleLength));
            input = Main.ReadLn(255);
        }
        System.exit(0);
    }

    public static void main(String args[])
    {
        Main mf = new Main();
        mf.run();
    }

    static String ReadLn(int maxLength)
    {
        // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte[maxLength];
        int length = 0;
        int input = -1;
        try
        {
            while (length < maxLength)
            {
                //Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n'))
                {
                    break; //or untill end of line ninput
                }
                line[length++] += input;
            }

            if ((input < 0) && (length == 0))
            {
                return null;  // eof
            }
            return new String(line, 0, length);
        }
        catch (IOException e)
        {
            return null;
        }
    }

}
