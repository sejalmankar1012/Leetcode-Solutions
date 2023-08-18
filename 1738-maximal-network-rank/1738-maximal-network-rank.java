class Solution {
    
    private Map<Integer, Set<Integer>> graph;
    
    public int maximalNetworkRank(int n, int[][] roads) {
        
        graph = new HashMap<>();
        
        for(int i = 0; i < n; i += 1) graph.put(i, new HashSet<>());
        
        for(int[] road : roads) {
            int a = road[0], b = road[1];
            // edge insertions
            graph.get(a).add(b); 
            graph.get(b).add(a);
        }
        
        int maxNetworkRank = 0;
        
        // trying all possible pairs of cities
        for(int i = 0; i < n; i += 1) {
            for(int j = i + 1; j < n; j += 1) {
                int city_a = i, city_b = j, networkRank = 0;
                int degreeA = graph.get(city_a).size();
                int degreeB = graph.get(city_b).size();
                if(graph.get(city_a).contains(city_b)) {
                    networkRank = degreeA + degreeB - 1;
                } else {
                    // not connected directly adjacently. Might be in the same component or in different components.
                    networkRank = degreeA + degreeB;
                }
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }
        }
        return maxNetworkRank;
    }
}