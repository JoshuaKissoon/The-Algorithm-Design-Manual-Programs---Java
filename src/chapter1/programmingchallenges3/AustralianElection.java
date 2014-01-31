/**
 * @author Joshua Kissoon
 * @created 20140201
 * @desc Solution to the "Australian Voting" problem at http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110108&format=html
 */
package chapter1.programmingchallenges3;

import java.util.ArrayList;
import java.util.HashMap;

public class AustralianElection
{

    private final HashMap<Integer, String> candidates;
    private final HashMap<Integer, String> activeCandidates;
    private final int numCandidates;
    private int numActiveCandidates;
    private final ArrayList<Ballot> ballots;
    private HashMap<Integer, Integer> votesCount;
    private final double halfNumVoters;

    /**
     * @desc Initialize the election data
     * @param candidates The names of candidates taking part in this election
     * @param ballots    The ballot of voters for the candidates
     */
    public AustralianElection(HashMap<Integer, String> candidates, ArrayList<Ballot> ballots)
    {
        this.numCandidates = candidates.size();
        this.numActiveCandidates = this.numCandidates;
        this.candidates = candidates;
        this.activeCandidates = candidates;
        this.ballots = ballots;
        this.halfNumVoters = this.ballots.size() / 2d;

        System.out.println("A candidate needs " + this.halfNumVoters + " votes to win from the " + this.ballots.size() + " voters.");
    }

    /**
     * @desc Compute the winning candidate from the given data
     * @return String The name of the winner
     */
    public String getWinner()
    {
        while (true)
        {
            /* Now we need to do this process over and over until we get a winner */
            this.countVotes();

            /* Check if anyone have > 50% votes */
            for (int candidateId : this.activeCandidates.keySet())
            {
                if (this.votesCount.get(candidateId) > this.halfNumVoters)
                {
                    /* This person is the winner!! */
                    return this.activeCandidates.get(candidateId);
                }
            }

            /* If we got here, means no one won as yet, so lets eliminate the loser(s) */
            int lowestVoteCount = 999999999, higestVoteCount = 0;
            for (int candidateId : this.activeCandidates.keySet())
            {
                int votes = this.votesCount.get(candidateId);
                if (votes < lowestVoteCount)
                {
                    lowestVoteCount = votes;
                }
                else if (votes > higestVoteCount)
                {
                    higestVoteCount = votes;
                }
            }

            /* We have a tie here, lets return all of these candidates! */
            if (lowestVoteCount == higestVoteCount)
            {
                StringBuilder str = new StringBuilder();
                for (int candidateId : this.activeCandidates.keySet())
                {
                    str.append(this.activeCandidates.get(candidateId));
                    str.append("\n");
                }
                return str.toString();
            }
            else
            {
                /* Eliminage all candidates with lowest votes */
                for (int candidateId : this.activeCandidates.keySet())
                {
                    if (lowestVoteCount == this.votesCount.get(candidateId))
                    {
                        this.eliminateCandidate(candidateId);
                    }
                }
            }
        }
    }

    /**
     * @desc Counts the votes of the active candidates
     */
    private void countVotes()
    {
        /* Re-initialize the votes count */
        votesCount = new HashMap<>();
        for (Integer candidateId : this.activeCandidates.keySet())
        {
            votesCount.put(candidateId, 0);
        }

        int candidateId;

        for (Ballot b : this.ballots)
        {
            for (int i = 0; i < numCandidates; i++)
            {
                candidateId = b.getCandidateRankedAt(i);

                if (this.activeCandidates.containsKey(candidateId))
                {
                    /* If this candidate still exist in the race, give him the vote for this ballot */
                    this.votesCount.put(candidateId, this.votesCount.get(candidateId) + 1);
                    break;
                }
            }
        }
        
        System.out.println("\n ******************* Votes counting started ***************** ");
        System.out.println("Votes by Candidate ID: " + this.votesCount);
        System.out.println("******************* Votes counting finished ***************** \n");

    }

    /**
     * @desc Removes a candidate from the active candidates list
     * @param candidateId The id of the candidate to remove
     */
    private void eliminateCandidate(int candidateId)
    {
        System.out.println("Eliminating candidate: " + this.activeCandidates.get(candidateId));
        this.activeCandidates.remove(candidateId);
        this.numActiveCandidates--;
    }

}
