package 代码随想录.字符串;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/剑指Offer05.替换空格.md
 */
public class Offer5 {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;  // 空格的数量
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        char[] ans = new char[n + count * 2];
        int i = 0, j = 0;
        while (j < n) {
            if (chars[j] != ' ') {
                ans[i++] = chars[j++];
            } else {
                ans[i++] = '%';
                ans[i++] = '2';
                ans[i++] = '0';
                j++;
            }
        }
        return new String(ans);
    }

    /**
     * 利用类库完成
     */
    public String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
