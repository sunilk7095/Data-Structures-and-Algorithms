class Solution {
    public String reverseVowels(String s) {
HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'));
        StringBuilder str = new StringBuilder(s);

        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(set.contains(str.charAt(i)) && set.contains(str.charAt(j))){
                char temp = str.charAt(i);
                str.setCharAt(i, str.charAt(j));
                str.setCharAt(j, temp);
                i++;
                j--;
            }else if (!set.contains(str.charAt(i))){
                i++;
            }
            else if (!set.contains(str.charAt(j))){
                j--;
            }
        }
        return str.toString();
    }
}