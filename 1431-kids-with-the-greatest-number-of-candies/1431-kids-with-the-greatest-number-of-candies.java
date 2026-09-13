class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n =candies.length;
        int max =0;
        for(int i : candies){
            max =Math.max(max, i);
        }

        List<Boolean> list = new ArrayList<>();
        for(int i =0 ; i< n; i++){
            list.add((candies[i] + extraCandies)  >= max);
        }
        return list;
    }
}