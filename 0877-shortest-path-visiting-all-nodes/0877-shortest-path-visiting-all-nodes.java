
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetState = (1 << n) - 1; // Target state with all bits set to 1, indicating all nodes visited.

        // Queue to perform BFS and store the current node and its state.
        Queue<int[]> queue = new ArrayDeque<>();
        // Set to keep track of visited nodes and their corresponding states to avoid cycles.
        Set<String> visited = new HashSet<>();

        // Add all nodes to the queue with their initial state (bitmask) and mark them as visited.
        for (int i = 0; i < n; i++) {
            int initialState = 1 << i;
            queue.offer(new int[]{i, initialState});
            visited.add(i + "-" + initialState);
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int state = curr[1];

                // Check if the target state is reached.
                if (state == targetState) {
                    return steps;
                }

                // Explore neighbors of the current node.
                for (int neighbor : graph[node]) {
                    int nextState = state | (1 << neighbor);
                    String key = neighbor + "-" + nextState;

                    // If the neighbor with the same state has not been visited, add it to the queue and mark it as visited.
                    if (!visited.contains(key)) {
                        queue.offer(new int[]{neighbor, nextState});
                        visited.add(key);
                    }
                }
            }

            steps++;
        }

        return -1; // If the target state is not reached, return -1.
    }
}
