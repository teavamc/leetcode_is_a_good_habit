package leetcode.editor.cn.part_two;
 
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2536 👎 0

public class 接雨水{
    public static void main(String[] args) {
        Solution solution = new 接雨水().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        // 保存位置 i 的左边最高墙的高度
        int[] max_left = new int[height.length];
        // 保存位置 i 的右边最高墙的高度
        int[] max_right = new int[height.length];
        // 它(i)前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        // 它(i)后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列左边最高的墙了。
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        // 从左往右计算可以容纳的雨水
        for (int i = 1; i < height.length - 1; i++) {
            // 拿到当前位置 i 的左右墙的最大高度, 取最小
            int min = Math.min(max_left[i], max_right[i]);
            // 如果最小的高度比当前 i 自生还要高, 就说明可以屯雨水
            if (min > height[i]) {
                // 记录可以屯的雨水
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}