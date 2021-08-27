package leetcode.中等;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/submissions/
 *
 * https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729?tpId=117&&tqId=35036&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 */
public class Solution179 {

    public String solve (int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (list.get(0).equals("0")) { // 注意是非负整数，数组里可能都是0
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
