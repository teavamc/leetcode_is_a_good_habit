package leetcode.editor.cn;
 
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1486 👎 0

public class 搜索旋转排序数组{
    public static void main(String[] args) {
        Solution solution = new 搜索旋转排序数组().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 旋转后的数组, 可以分成两段, 每段都是有序的, 要找到旋转点
        // 找到旋转点后, 就得到有序的两个数组, 判断这两个数组的首尾
        // 就能知道目标值在哪个数组里面, 再去那个数组里面二分就好了
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){
                // 进到这里,说明 mid - right 都是同一个子数组
                // 在同一个子数组中, 不存在旋转点, 就说明是升序
                // 如果 mid 上值小于 target,说明 left 可以挪到 mid 来了
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }else{
                    // target 不在 mid - right 之间,就去对面找
                    right = mid -1;
                }
            }else{
                // 同上
                if(nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}