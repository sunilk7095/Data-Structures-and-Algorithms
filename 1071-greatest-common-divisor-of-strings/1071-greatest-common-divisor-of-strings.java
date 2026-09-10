class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Verify if a common string divisor is possible
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Step 2: Get the length of the GCD string
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Step 3: Return the prefix of that length
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}