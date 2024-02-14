// Given two strings s1 and s2. Modify both the strings such that all the common characters of s1 and s2 are to be removed and the uncommon characters of s1 and s2 are to be concatenated.
// Note: If all characters are removed print -1.

class Solution {
    // Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1, String s2) {
        // Your code here
        Map<Character, Integer> freqS1 = new HashMap<>();
        Map<Character, Integer> freqS2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            freqS1.put(c, freqS1.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            freqS2.put(c, freqS2.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (char c : s1.toCharArray()) {
            if (!freqS2.containsKey(c)) {
                result.append(c);
            }
        }

        for (char c : s2.toCharArray()) {
            if (!freqS1.containsKey(c)) {
                result.append(c);
            }
        }

        if (result.length() == 0) {
            return "-1";
        }

        return result.toString();
    }
}
