class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);


        for(int i =1; i < words.length; i++){
            if(!isAnagram(res.get(res.size()-1),words[i]))
                res.add(words[i]);
        }

        return res;
    }


    private boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1,a2);
    }
}