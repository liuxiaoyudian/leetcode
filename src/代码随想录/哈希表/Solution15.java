package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0015.三数之和.md
 *
 * 这一题虽然被归位哈希表，但是其最简单的实现方式是通过排序+双指针
 */
public class Solution15 {

    /**
     * 排序+双指针法
     * 时间复杂度：O(NlogN)
     *
     * 几个关键点：
     * 1. 通过排序减少重复
     *    我们枚举的三元组(a,b,c) 满足 a≤b≤c，保证了只有 (a,b,c) 这个顺序会被枚举到，而 (b,a,c)、 (c,b,a) 等等这些不会，这样就减少了重复。
     * 2. 去除前两重循环的重复
     *    对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复。
     * 3. 采用双指针将第二层循环和第三层循环压成一层循环，时间复杂度从O(n^3) -> O(n^2)
     *    因为数组是有序的，second从左往右，third从右往左，依次判断就行
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // O(NlogN)
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < n; first++) { // 优化：first < n - 2
            if (nums[first] > 0) { // 第一个数大于 0，后面的数都比它大，肯定不成立了（这个判断也可以没有，但是会多执行几次）
                break;
            }
            if (first > 0 && nums[first] == nums[first -1]) { // 需要和上一次枚举的数不相同
                continue;
            }
            int third = n - 1;
            for (int second = first + 1; second < n; second++) { // 优化：second < n - 1
                if (second > first + 1 && nums[second] == nums[second - 1]) { // 需要和上一次枚举的数不相同
                    continue;
                }
                while (second < third && nums[first] + nums[second] + nums[third] > 0) { // 需要保证 b 的指针在 c 的指针的左侧
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
