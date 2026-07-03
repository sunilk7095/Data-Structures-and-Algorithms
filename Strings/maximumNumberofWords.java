class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s: sentences){
            int word =1;
            for( char ch : s.toCharArray()){
                if(ch == ' '){
                    word++;
                }

                if (max<word){
                    max = word;
                }
            }
        }
        return max;
    }
}