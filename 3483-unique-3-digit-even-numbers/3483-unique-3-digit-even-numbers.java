class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int total = 0;
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100; //1
            int d2 = (num / 10) % 10; // 2
            int d3 = num % 10; 

            int[] tempCount = new int[10];
            tempCount[d1]++;
            tempCount[d2]++;
            tempCount[d3]++;

            if (tempCount[d1] <= count[d1] &&
                tempCount[d2] <= count[d2] &&
                tempCount[d3] <= count[d3]) {
                total++;
            }
        }

        return total;
    }
}