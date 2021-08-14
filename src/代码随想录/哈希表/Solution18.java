package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/submissions/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0018.四数之和.md
 *
 * 同Solution15的解题思路，同样是双指针法
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < n; first++ ) {
            // 注意这个判断在这里就不适用了，因为target可能为负，只有target为正的时候才能用这个判断
//            if (nums[first] > target) {
//                break;
//            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int fourth = n - 1;
                for (int third = second + 1; third < n; third++) { //
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    while (third < fourth && nums[first] + nums[second] + nums[third] + nums[fourth] > target) {
                        fourth--;
                    }
                    if (third == fourth) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 优化速度的版本，但时间复杂度依然是O(N^3)
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < n - 3; first++ ) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if (nums[first] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if (nums[first] + nums[second] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int fourth = n - 1;
                for (int third = second + 1; third < n - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    while (third < fourth && nums[first] + nums[second] + nums[third] + nums[fourth] > target) {
                        fourth--;
                    }
                    if (third == fourth) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

}
