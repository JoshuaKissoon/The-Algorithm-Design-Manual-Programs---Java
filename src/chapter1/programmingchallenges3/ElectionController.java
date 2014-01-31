/**
 * @author Joshua Kissoon
 * @created 20140201
 * @desc Controlling class for the Australian election
 */
package chapter1.programmingchallenges3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ElectionController
{

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        StringTokenizer tokenString;
        HashMap<Integer, String> candidates;
        ArrayList<Ballot> ballots;
        Ballot ballot;

        /* This code have to be run for n elections */
        int numElections = in.nextInt();
        in.nextLine();      // There is a blank line here, just pass it
        for (int i = 0; i < numElections; i++)
        {
            /* Initializing new variables for this elections */
            candidates = new HashMap<>();
            ballots = new ArrayList<>();

            /* Read in the candidates */
            int numCandidates = in.nextInt();
            in.nextLine();      // There is a blank line here, just pass it
            for (int j = 0; j < numCandidates; j++)
            {
                candidates.put(j + 1, in.nextLine());
            }

            /* Read in the ballots */
            String ballotString = in.nextLine();
            while (!ballotString.equals(""))
            {
                tokenString = new StringTokenizer(ballotString);
                ballot = new Ballot(numCandidates);
                for (int j = 0; j < numCandidates; j++)
                {
                    ballot.setCandidateAtRank(j, Integer.parseInt(tokenString.nextToken()));
                }

                /* Now add the ballot to the set of ballots */
                ballots.add(ballot);
                ballotString = in.nextLine();
            }

            /* Now lets get the winner */
            AustralianElection election = new AustralianElection(candidates, ballots);
            System.out.println("The winner is: " + election.getWinner());

        }

        System.exit(0);
    }
}
