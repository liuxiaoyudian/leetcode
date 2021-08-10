package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0349.两个数组的交集.md
 */
public class Solution349 {

    /**
     * Set的交集，并集，差集
     * result.retainAll(set2);
     * result.addAll(set2);
     * result.removeAll(set2);
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            res[i++] = num;
        }
        return res;
    }

}
