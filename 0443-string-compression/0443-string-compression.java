class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int count=0;
        for(int i =0; i < n; i++){
            count++;
            if(i == n-1 || chars[i] != chars[i+1] ){
                sb.append(chars[i]);
                if(count>1) sb.append(count);
                count = 0;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}