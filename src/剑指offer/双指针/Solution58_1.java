package 剑指offer.双指针;

/**
 * 58.1 翻转单词顺序列
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/58.1%20翻转单词顺序列.md
 */
public class Solution58_1 {

    /**
     * 自己实现的方法
     */
    public String ReverseSentence(String str) {
        String[] list = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            sb.append(list[i] + " ");
        }
        return sb.length() - 1 > 0 ? sb.substring(0, sb.length() - 1) : str;
    }

    /**
     * 输入 student. a am I
     * 处理的整体思路是先对每一个单词进行翻转，然后在对输入的句子的整体进行翻转
     */
    public String ReverseSentence1(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        // i和j分别用来标记输入句子中，每一个单词的起始和终止的位置
        int i = 0, j = 0;
        // 这一步是对输入的每一个单词进行反转，如果输入是student. a am I，则执行完后这个循环就变成了.tneduts a ma I
        // 循环条件j <= n和if(j==n)是为了捕捉最后一次循环的情况！！！！！！记住这个用法
        while (j <= n) {
            // 限制j==n的条件是为了处理输入句子最后一个单词的情况
            // 并且当j==n成立的时候，chars[j]是会报空指针错误的，但是这个条件是||，所以并不会执行到chars[j]
            if (j == n || chars[j] == ' ') {
                // 因为chars[j]是空格，所以j-1才是这个单词终止的位置（注意n的大小！！！！）
                reverse(chars, i, j - 1);
                // 此时j的位置是空格，因此i=j+1，i直接跳到下一个单词的开始位置
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }


}
