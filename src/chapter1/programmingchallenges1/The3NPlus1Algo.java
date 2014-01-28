/**
 * @author Joshua Kissoon
 * @created 20140128
 * @desc Algorithm that solves the 3n + 1 Problem
 */
package chapter1.programmingchallenges1;

import java.util.ArrayList;

public class The3NPlus1Algo
{

    private final int n;
    private final ArrayList<Integer> sequence;

    /**
     * @param n The number we need to run the algorithm on
     */
    public The3NPlus1Algo(int n)
    {
        this.n = n;
        this.sequence = new ArrayList<>();
    }

    /**
     * @desc Here we generate the sequence of numbers
     */
    public void generateSequence()
    {
        int num = this.n;
        this.sequence.add(num);

        while (num != 1)
        {
            if ((num % 2) == 0)
            {
                num /= 2;
            }
            else
            {
                num = (num * 3) + 1;
            }            
            this.sequence.add(num);
        }        
    }
    
    public ArrayList<Integer> getSequence()
    {
        return this.sequence;
    }
}
