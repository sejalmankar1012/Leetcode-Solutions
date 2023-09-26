

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // Store the last index of each character
        boolean[] inStack = new boolean[26]; // Keep track of characters in the stack
        Stack<Character> stack = new Stack<>();

        // Populate lastIndex array
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is already in the stack, continue
            if (inStack[c - 'a']) {
                continue;
            }

            // Pop characters from the stack if they are greater than the current character
            // and there are more instances of them later in the string
            while (!stack.isEmpty() && c < stack.peek() && lastIndex[stack.peek() - 'a'] > i) {
                inStack[stack.pop() - 'a'] = false;
            }

            // Push the current character into the stack
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
