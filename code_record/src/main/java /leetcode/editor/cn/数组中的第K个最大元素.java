package leetcode.editor.cn;
 
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1093 👎 0

import java.util.PriorityQueue;

public class 数组中的第K个最大元素{
    public static void main(String[] args) {
        Solution solution = new 数组中的第K个最大元素().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (a,b) -> b-a);
        for(int i : nums){
            pq.add(i);
        }
        int max = 0;
        for (int i = 0;i<k;i++){
            max = pq.poll();
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}