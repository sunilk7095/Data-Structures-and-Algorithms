class Solution {
    public int numberOfSets(int n, int k) {
        long mod = 1_000_000_007;
        long N = n + k - 1;
        long K = 2 * k;

        if (N < K) return 0;

        long num = 1;
        long den = 1;

        for (long i = 1; i <= K; i++) {
            num = (num * (N - i + 1)) % mod;
            den = (den * i) % mod;
        }

        // Divide num by den using Modular Multiplicative Inverse (Fermat's Little Theorem)
        return (int) (num * modInverse(den, mod) % mod);
    }

    private long modInverse(long base, long mod) {
        return power(base, mod - 2, mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}