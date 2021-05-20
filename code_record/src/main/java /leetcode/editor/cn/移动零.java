package leetcode.editor.cn;
 
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1062 👎 0

import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class 移动零{
    public static void main(String[] args) {
        Solution solution = new 移动零().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        // 双指针
        // zeroIdx 指针用来标记位置上不是零
        // 如果当前位置非零 ---> 索引后移
        // 如果当前位置是零 ---> 索引不变
        // 所以 i 看做快指针  zeroIdx 是慢指针
        for (int i = 0;i<nums.length;i++){
            if (nums[i] != 0){
                nums[nonZeroIdx++] = nums[i];
            }
        }
        // 当走完之后, zeroIdx 是第一个 0 的索引
        //
        while (nonZeroIdx < nums.length){
            nums[nonZeroIdx++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}