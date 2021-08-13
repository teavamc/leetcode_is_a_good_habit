package leetcode.editor.cn.part_two;
 
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1766 👎 0

public class 最长递增子序列{
    public static void main(String[] args) {
        Solution solution = new 最长递增子序列().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 代表长度为 idx 的序列的尾部元素的值,这个值只保留最小值
        int[] tails = new int[nums.length];
        // 记录了最长的上升子序列
        int ans = 0;
        // 遍历整个数组
        for(int num:nums){
            // 左右指针
            int l = 0;
            int r = ans;
            // 做二分
            while(l<r){
                // 拿到中点
                int m = l + (r - l)/2;
                // 如果
                if(tails[m] < num){
                    l = m+1;
                }else{
                    r = m;
                }
            }
            tails[l] = num;
            if (ans == r){
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}