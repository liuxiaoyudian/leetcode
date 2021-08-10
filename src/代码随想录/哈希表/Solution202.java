package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 第202题. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * <p>
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0202.快乐数.md
 */
public class Solution202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) { // 循环的条件，n!=1以及n不重复
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public int getNextNumber(int n) {
        int res = 0;
        while (n > 0) { // 注意这个判断
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }

    /**
     * 自己的实现（略麻烦）
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int len = String.valueOf(n).length();
            int[] nums = new int[len];
            for (int i = 0; i < len - 1; i++) {
                nums[i] = n % 10;
                n /= 10;
            }
            nums[len - 1] = n % 10;
            int sum = 0;
            for (int i : nums) {
                sum += i * i;
            }
            System.out.println(sum);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
    }

}
