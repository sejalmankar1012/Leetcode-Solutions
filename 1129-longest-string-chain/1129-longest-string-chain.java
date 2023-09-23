

class Solution {
  public int longestStrChain(String[] words) {
    // Sort the words array by their lengths in ascending order.
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    
    // Initialize a map to store the longest chain length for each word.
    Map<String, Integer> dp = new HashMap<>();
    int longestChain = 0;

    // Iterate through each word in the sorted array.
    for (String word : words) {
      int currentChainLength = 1;
      
      // Generate all possible predecessors of the current word.
      for (int i = 0; i < word.length(); i++) {
        StringBuilder predecessor = new StringBuilder(word);
        predecessor.deleteCharAt(i);
        String pred = predecessor.toString();
        
        // Check if the predecessor exists in the map and update the chain length.
        if (dp.containsKey(pred)) {
          currentChainLength = Math.max(currentChainLength, dp.get(pred) + 1);
        }
      }
      
      // Update the longest chain length for the current word.
      dp.put(word, currentChainLength);
      longestChain = Math.max(longestChain, currentChainLength);
    }

    return longestChain;
  }
}
