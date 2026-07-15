class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.strip();
        int n = str.length();
        int len = 0;

        if (n==1) return 1;
        for(int i = n-1; i >= 0; i--){
            if (str.charAt(i)==' '){
                break;
            }
            len++;
        }
        return len;
    }
}