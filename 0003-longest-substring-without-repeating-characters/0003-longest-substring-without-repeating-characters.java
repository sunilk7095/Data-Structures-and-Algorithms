class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxCnt=0;
        int i = 0;
        int j =0;
        HashSet<Character> set= new HashSet();
        while(j<n){
            while (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxCnt = Math.max(maxCnt, j-i+1);
            j++;
        }
        
    return maxCnt;
    }
}