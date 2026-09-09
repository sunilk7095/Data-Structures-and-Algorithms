class Solution {
    public long countCommas(long n) {
        long commas = 0;
        long x = n;

        if (n < 1000) return 0;

        if (n >= 1000L)                 commas += (x - 999L);
        if (n >= 1000000L)              commas += (x - 999999L);
        if (n >= 1000000000L)           commas += (x - 999999999L);
        if (n >= 1000000000000L)        commas += (x - 999999999999L);
        if (n >= 1000000000000000L)     commas += (x - 999999999999999L);
        if (n >= 1000000000000000000L)  commas += (x - 999999999999999999L);

        return commas;
    }
}