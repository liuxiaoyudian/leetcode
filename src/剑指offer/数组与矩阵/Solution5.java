package 剑指offer.数组与矩阵;

public class Solution5 {

    public String replaceSpace (String s) {
        // write code here
        if (s == null) {
            return null;
        }
        return s.replace(" ", "%20");
    }

    public String replaceSpace1 (String s) {
        // write code here
        if (s == null) {
            return null;
        }

        StringBuilder str = new StringBuilder(s);

        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) ==  ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 < p2) { // 结束条件是p1 == p2
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }

        return str.toString();
    }

}
