/**
 * @author Joshua Kissoon
 * @created 20130124
 * @desc Implementation of the Closest Pair Algorithm
 */
package chapter1.exercise26;

import java.util.ArrayList;

public final class ClosestPairAlgo implements RobotTourOptimizationAlgorithm
{

    private final Graph tourGraph;
    private final ArrayList<VertexChain> vertexChains;

    /**
     * @desc We initialize the tour graph to an input graph in this constructor
     * @param initialGraph The graph we start with
     */
    public ClosestPairAlgo(Graph initialGraph)
    {
        this.tourGraph = initialGraph;
        vertexChains = new ArrayList<>();
    }

    /**
     * Here we actually execute the Closest pair algorithm
     */
    @Override
    public void executeAlgorithm()
    {

        System.out.println("\n\n\n\n\n\n***************** CLOSEST PAIR ALGORITHM EXECUTION STARTED ************************");
        /* Get n: the number of points in the set P of points */
        int n = this.tourGraph.getPoints().size();

        /* For i=1 to (n-1) do */
        for (int i = 1; i <= (n - 1); i++)
        {
            double d = 99999999d;
            Point sm = null, tm = null;

            /**
             * For each pair of endpoints from distinct vertex chains, look into them
             * In this algorithm, we only set a vertex as visited if it has been added to 2 edges, otherwise the vertex is still set as unvisited
             * We traverse all unvisited vertices and compare every possible pair of vertices:
             * - If they are not in any edge, or if they are from distinct endpoints, then we consider them for creating an edge
             */
            int numUnvisitedPoints = tourGraph.getUnvisitedPoints().size();

            /* Lets traverse every pair of unvisited verticies */
            for (int j = 0; j < numUnvisitedPoints; j++)
            {
                for (int k = j + 1; k < numUnvisitedPoints; k++)
                {
                    try
                    {
                        /* Get 2 points */
                        Point s = tourGraph.getUnvisitedPoints().get(j);
                        Point t = tourGraph.getUnvisitedPoints().get(k);

                        /* Check if these 2 points are from distinct vertex chains */
                        boolean fromDiffVertexChain = true;
                        for (VertexChain vc : vertexChains)
                        {
                            if (vc.containsPoint(s) && vc.containsPoint(t))
                            {
                                fromDiffVertexChain = false;
                                break;
                            }
                        }

                        /* If the vertices are from different vertex chains && their distance between them is < d, then we set them as the selected endpoints to create an edge from */
                        if (fromDiffVertexChain && (s.distanceFromPoint(t) < d))
                        {
                            sm = s;
                            tm = t;
                            d = s.distanceFromPoint(t);
                        }
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("Indexes " + j + " & " + k + " are out of bound, it seems that no point exists in the unvisited point list at one of these indices.");
                    }
                }
            }

            /* Now we have 2 verticies from distinct vertex chains */
            if (sm != null && tm != null)
            {
                System.out.println("Points selected to create a new edge are: " + sm + " & " + tm + ". Distance between these points: " + sm.distanceFromPoint(tm));
                /* Create an edge with these vertices */
                Edge newEdge = new Edge(sm, tm);
                tourGraph.addEdge(newEdge);

                /* Create a vertex chain or add the vertex/vertices to a vertex chain */
                boolean inVertexChain = false;
                for (VertexChain vc : vertexChains)
                {
                    /**
                     * @note In the case the points join 2 vertex chains, we do not make them into one vertex chain,
                     * but rather add each point to the necessary vertex chain, thereby showing where the vertex chains are joined
                     */
                    if (vc.containsPoint(sm))
                    {
                        /* The vertex chain contains sm, we need to add tm to the vertex chain */
                        vc.addVertex(tm);
                        inVertexChain = true;
                    }
                    if (vc.containsPoint(tm))
                    {
                        /* The vertex chain contains tm, we need to add sm to the vertex chain */
                        vc.addVertex(sm);
                        inVertexChain = true;
                    }
                }

                /* If these points are not in any vertex chain, create a new vertex chain and add them to it */
                if (!inVertexChain)
                {
                    System.out.println("A new vertex chain has to be created since none exist with these points.");
                    VertexChain vc = new VertexChain(sm, tm);
                    this.addVertexChain(vc);
                }

                /* Check if these points are used twice and add them to visited points if they are */
                int smCount = 0, tmCount = 0;
                for (Edge e : tourGraph.getEdges())
                {
                    if (e.hasPoint(sm))
                    {
                        smCount++;
                    }
                    if (e.hasPoint(tm))
                    {
                        tmCount++;
                    }
                }

                if (smCount == 2)
                {
                    System.out.println("Point " + sm + " added to visited points.");
                    tourGraph.setPointVisited(sm);
                }
                if (tmCount == 2)
                {
                    System.out.println("Point " + tm + " added to visited points.");
                    tourGraph.setPointVisited(tm);
                }
            }

        }

        /* Now we connect our endpoints by an edge, these endpoints will be the only points remaining in the unvisited points array */
        Point sm = tourGraph.getUnvisitedPoints().get(0);
        Point tm = tourGraph.getUnvisitedPoints().get(1);
        this.tourGraph.addEdge(new Edge(sm, tm));
        System.out.println("Created final edge between the 2 points: " + sm + " & " + tm + ". Distance between these points: " + sm.distanceFromPoint(tm));
        tourGraph.setPointVisited(sm);
        System.out.println("Point " + sm + " added to visited points.");
        tourGraph.setPointVisited(tm);
        System.out.println("Point " + tm + " added to visited points.");

        /* Add these points to the new vertex chains they are a part of */
        for (VertexChain vc : this.vertexChains)
        {
            /**
             * @note In the case the points join 2 vertex chains, we do not make them into one vertex chain,
             * but rather add each point to the necessary vertex chain, thereby showing where the vertex chains are joined
             */
            if (vc.containsPoint(sm))
            {
                /* The vertex chain contains sm, we need to add tm to the vertex chain */
                vc.addVertex(tm);
            }
            if (vc.containsPoint(tm))
            {
                /* The vertex chain contains tm, we need to add sm to the vertex chain */
                vc.addVertex(sm);
            }
        }

        System.out.println("***************** CLOSEST PAIR ALGORITHM EXECUTION COMPLETED ************************");

    }

    @Override
    public Graph getTourGraph()
    {
        return this.tourGraph;
    }

    @Override
    public double getTotalDistanceTraveled()
    {
        Double totalDistance = 0d;

        for (Edge e : this.tourGraph.getEdges())
        {
            totalDistance += e.length();
        }

        return totalDistance;
    }

    /**
     * @desc Adds a new vertex chain
     * @param vc The new vertex chain to add
     */
    private void addVertexChain(VertexChain vc)
    {
        this.vertexChains.add(vc);
    }

    /**
     * @desc A class that manages a single vertex chain
     */
    private final class VertexChain
    {

        public ArrayList<Point> vertices;

        public VertexChain(Point p, Point q)
        {
            this.vertices = new ArrayList<>();
            this.addVertex(p);
            this.addVertex(q);
        }

        /**
         * @desc Adds a new point to this vertex chain
         * @param p The point to add tho this vertex chain
         */
        public final void addVertex(Point p)
        {
            this.vertices.add(p);
        }

        /**
         * @desc Checks if the vertex chain contain a point
         * @param p a point to check for
         *
         * @return boolean if the vertex chain contain the given point
         */
        public boolean containsPoint(Point p)
        {
            return this.vertices.contains(p);
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();

            sb.append("\n\n **************** Printing vertex chain started ************************");

            sb.append("\n Verticees: \n");
            sb.append(this.vertices);
            sb.append("\n\n");

            sb.append("\n **************** Printing vertex chain completed ************************ \n\n");

            return sb.toString();
        }
    }

}
