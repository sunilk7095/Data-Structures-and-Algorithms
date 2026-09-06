
 class Solution {
    public boolean isSubsequence(String s, String t) {

        int n=s.length();
        int freq = 0;
        int j = 0;
        int i = 0;
        
        while(i < n && j <t.length()){
            if(s.charAt(i) == t.charAt(j)){
                freq++;
                i++;
                j++;

            }else{
                j++;
            }
        }

        if(freq == n){
            return true;
        }else{
            return false;
        }
    }
}