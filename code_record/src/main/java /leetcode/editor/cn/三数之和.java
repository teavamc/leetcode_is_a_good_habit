package leetcode.editor.cn;
 
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3381 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 三数之和{
    public static void main(String[] args) {
        Solution solution = new 三数之和().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len;++i){
            // 出界
            if (nums[i]>0){
                return ans;
            }
            // 重复
            if (i>0&&nums[i] == nums[i-1]){
                continue;
            }
            int cur = nums[i];
            int L = i+1;
            int R = len-1;
            while(L<R){
                int temp = cur + nums[L] + nums[R];
                if (temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    ans.add(list);
                    while(L<R && nums[L+1] == nums[L]){
                        ++L;
                    }
                    while(L<R && nums[R-1] == nums[R]){
                        --R;
                    }
                    ++L;
                    --R;
                }else if (temp <0){
                    ++L;
                }else{
                    --R;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}