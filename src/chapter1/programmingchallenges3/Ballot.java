/**
 * @author Joshua Kissoon
 * @created 20140201
 * @desc Class used to represent a ballot in the Australian voting problem
 */
package chapter1.programmingchallenges3;

public final class Ballot
{

    /**
     * @desc Initialize the ballot data structures
     * @param numCandidates How many candidates should this ballot cater for
     */
    private int candidatesRank[];
    private final int numCandidates;

    public Ballot(Integer numCandidates)
    {
        this.numCandidates = numCandidates;
        candidatesRank = new int[numCandidates];
    }

    /**
     * @desc Get the candidate that the voter ranked at some given position
     * @param position The rank at which the required candidate is at
     *
     * @return int The id of the candidate
     */
    public int getCandidateRankedAt(int position)
    {
        if (position < this.numCandidates)
        {
            return candidatesRank[position];
        }
        else
        {
            return -1;
        }
    }

    /**
     * @desc Populate the candidates ranks for this ballot
     * @param ranking An array with the ranks
     */
    public void setCandidatesRanking(int[] ranking) throws IndexOutOfBoundsException
    {
        if (ranking.length > numCandidates)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            this.candidatesRank = ranking;
        }
    }

    /**
     * @desc Set the rank for a single candidate for this ballot
     * @param rank        the rank of where to set this candidate
     * @param candidateId The id of the candidate to put at this rank
     */
    public void setCandidateAtRank(int rank, int candidateId) throws IndexOutOfBoundsException
    {
        if (rank >= this.numCandidates)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            this.candidatesRank[rank] = candidateId;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        output.append("\n\n PRINTING BALLOT STARTED \n");
        output.append("Candidates: ");
        for (int i = 0; i < this.numCandidates; i++)
        {
            output.append("\n Candidate ");
            output.append(i);
            output.append(" : ");
            output.append(candidatesRank[i]);
        }
        output.append("\n PRINTING BALLOT FINISHED \n\n");

        return output.toString();
    }
}
