// Given a string n, your task is to find whether it contains an additive sequence or not. A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which returns true if the string is a valid sequence else returns false. For better understanding check the examples.

// Note: A valid string should contain at least three digit to make one additive sequence. 

// User function Template for Java
class Solution {
    public boolean isAdditiveSequence(String n) {
        int len = n.length();
        // Loop to try different combinations of first two numbers
        for (int i = 1; i <= len / 2; i++) {
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (isValid(n.substring(0, i), n.substring(i, i + j), n.substring(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(String num1, String num2, String remaining) {
        if ((num1.length() > 1 && num1.charAt(0) == '0') || (num2.length() > 1 && num2.charAt(0) == '0')) {
            // Reject if any number starts with 0 and has more than 1 digit
            return false;
        }

        String sum = addStrings(num1, num2);
        if (remaining.startsWith(sum)) {
            if (remaining.length() == sum.length()) {
                // If there is no remaining string, return true
                return true;
            }
            // Recursive call with the remaining string and num2 as the new num1 and sum as
            // the new num2
            return isValid(num2, sum, remaining.substring(sum.length()));
        }
        // If sum doesn't match with the start of remaining string, return false
        return false;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
}
