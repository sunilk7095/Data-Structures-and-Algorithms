/**
 * Problem No: 9
 * Problem Title: Palindrome Number
 * URL: https://leetcode.com/problems/palindrome-number/
 * - Time Complexity: O(log10(x)) 
 * - The number of digits in x is roughly log10(x). We divide x by 10 in every iteration.
 * - Space Complexity: O(1)
 * - Constant extra space is used as we only store a few integer variables.
 */

class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 reads as 121- from right)
        // 2. Numbers ending in 0 are not palindromes (except 0 itself) because a number cannot start with 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            // A small optimization hint from the discussion panels
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > 0) {
            int lastDigit = x % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            x /= 10;
        }

        // If the reversed number equals the original, it's a palindrome
        return originalNumber == reversedNumber;
    }
}