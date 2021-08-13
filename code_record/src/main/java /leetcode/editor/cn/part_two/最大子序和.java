package leetcode.editor.cn.part_two;
 
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3234 👎 0

public class 最大子序和{
    public static void main(String[] args) {
        Solution solution = new 最大子序和().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划
        // 最大的子序和
        int res = nums[0];
        // 每一位上的最大和
        int sum = 0;
        for (int i:nums){
            // 如果之前的最优和大于0,说明是增益,可以沿用
            if (sum>0){
                sum += i;
            }else {
                sum = i;
            }
            // 判断当前数组位置的最大和是否更大
            res = Math.max(res,sum);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}