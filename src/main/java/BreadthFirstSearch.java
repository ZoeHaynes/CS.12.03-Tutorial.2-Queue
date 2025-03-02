
public class BreadthFirstSearch {


    /** bfs will take an Adjacency List as input and return an array containing the order of nodes traversed.
     *
     * @param graph - an Adjacency List
     * @return - an array containing the order of nodes traversed
     */
    public static int[] bfs(int[][] graph) {

        // Create a Queue and add the first node (0) to it.
        // Use your Queue class that you just created!
        CISQueue queue = new CISQueue(0);
        // Create a visited array.
        // This array will track whether we have visited a specific node.
        boolean[] visited = new boolean[graph.length];

        // Create a bfs array and a bfs index.
        // This array will track the order that the nodes were visited.
        int[] bfs = new int[graph.length];
        int bfsIndex = 0;

        // Add the first node (0) to the bfs array.
        // Record the first node as having been visited.
        visited[0] = true;
        bfs[bfsIndex++] = 0;
        queue.enqueue(0);

        // Time to traverse the graph!
        // While the queue is not empty ...
        while (!queue.isEmpty()) {
            // Dequeue (poll) the queue and store this value in a variable called currentNode.
            int curNode = (int) queue.dequeue();
            // Record this node as visited.
            visited[curNode] = true;

            // Explore the current nodes neighbouring nodes.
            // For each neighbouring node ...
            for (int neighbour : graph[curNode]) {
                // Store the neighbour in a variable called neighbour.
                // If neighbour hasn't been visited before ...
                if (!visited[neighbour]) {
                    // Mark neighbour as visited.
                    queue.enqueue(neighbour);
                    visited[neighbour] = true;
                    // Add neighbour to the queue.
                    // Add neighbour to bfs.
                    bfs[bfsIndex++] = neighbour;
                }
            }
        }
        // Return bfs.
        return bfs;
    }
}
