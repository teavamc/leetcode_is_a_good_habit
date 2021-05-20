package leetcode.editor.cn;
 
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 989 👎 0

import java.util.Arrays;

public class 多数元素{
    public static void main(String[] args) {
        Solution solution = new 多数元素().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 根据题意, "多数"的数量已经超过了 n/2 了
        // 那直接排序,取中位数就肯定正确
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}