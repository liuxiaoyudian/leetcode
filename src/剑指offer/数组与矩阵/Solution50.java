package 剑指offer.数组与矩阵;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution50 {

    public static int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        char[] l = str.toCharArray();
        for (char c : l) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < l.length; i++) {
            if (map.get(l[i]) == 1) {
                return i;
            }
        }
        return -1;
    }


    public int FirstNotRepeatingChar1(String str) {
        // ASCII 码只有 128 个字符，因此可以使用长度为 128 的整型数组来存储每个字符出现的次数。
        int[] cnts = new int[128];
        for (char c : str.toCharArray()) {
            cnts[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

}
