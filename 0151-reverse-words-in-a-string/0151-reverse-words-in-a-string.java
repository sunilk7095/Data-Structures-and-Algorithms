class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {

            if (sb.charAt(i) != ' ') {
                temp.append(sb.charAt(i));
            } 
            else {
                if (temp.length() == 0) {
                    continue;
                }

                res.append(temp.reverse());
                res.append(' ');
                temp.setLength(0);
            }
        }

        if (temp.length() > 0) {
            res.append(temp.reverse());
        }

        return res.toString();
    }
}