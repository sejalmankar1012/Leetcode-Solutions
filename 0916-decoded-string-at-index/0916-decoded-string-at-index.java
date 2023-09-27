class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedSize = 0;

        // Calculate the size of the decoded string without actually decoding it
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedSize *= digit;
            } else {
                decodedSize++;
            }
        }

        // Traverse the string in reverse to find the k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            k %= decodedSize;

            if (k == 0 && Character.isLetter(currentChar)) {
                return Character.toString(currentChar);
            }

            if (Character.isDigit(currentChar)) {
                int digit = currentChar - '0';
                decodedSize /= digit;
            } else {
                decodedSize--;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }
}

