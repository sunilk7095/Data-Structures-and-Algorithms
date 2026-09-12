
class Solution {
    // Helper class to hold interval metadata
    static class Interval {
        int l, r, weight, id;
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    // Helper class to track DP states and index sequences
    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        // Sort intervals primarily by right endpoint 'r'
        Arrays.sort(arr, (a, b) -> Integer.compare(a.r, b.r));

        // Binary search: precompute largest index j where arr[j].r < arr[i].l
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, best = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].r < arr[i].l) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = best;
        }

        // dp[k][i] represents best state taking at most k intervals from arr[0...i-1]
        State[][] dp = new State[5][n + 1];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dp[k][i] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {
            Interval curr = arr[i - 1];
            int p = prev[i - 1] + 1; // 1-based index in DP table

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip current interval
                State bestState = dp[k][i - 1];

                // Option 2: Include current interval
                State prevChoice = dp[k - 1][p];
                long newWeight = prevChoice.weight + curr.weight;
                List<Integer> newIndices = new ArrayList<>(prevChoice.indices);
                newIndices.add(curr.id);
                Collections.sort(newIndices);

                State takeState = new State(newWeight, newIndices);

                // Compare takeState vs bestState
                if (isBetter(takeState, bestState)) {
                    bestState = takeState;
                }

                dp[k][i] = bestState;
            }
        }

        // Retrieve best result across all k <= 4
        State bestResult = dp[0][n];
        for (int k = 1; k <= 4; k++) {
            if (isBetter(dp[k][n], bestResult)) {
                bestResult = dp[k][n];
            }
        }

        int[] result = new int[bestResult.indices.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bestResult.indices.get(i);
        }
        return result;
    }

    private boolean isBetter(State a, State b) {
        if (a.weight != b.weight) {
            return a.weight > b.weight;
        }
        // Lexicographical check on index sequences
        int len = Math.min(a.indices.size(), b.indices.size());
        for (int i = 0; i < len; i++) {
            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i);
            }
        }
        return a.indices.size() < b.indices.size();
    }
}