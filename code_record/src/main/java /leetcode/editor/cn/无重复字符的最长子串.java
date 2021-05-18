package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5468 👎 0

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 边界校验
            if (s.length() == 0) {
                return 0;
            }
            // 保存没有元素的最大位置
            // key - 字符  value - 位置
            Map<Character, Integer> map = new HashMap<>();
            // 累计最大不重复的字符串
            int max = 0;
            // 左指针
            int left = 0;
            // i 是右指针
            for (int right = 0; right < s.length(); right++) {
                // 如果出现重复的元素
                if (map.containsKey(s.charAt(right))) {
                    // 看两个 case
                    // case_1 : abca
                    // 初始化 left = 0, 如果走到了第二个 a(3) 的时候,map 出现重复
                    // 此时 left = max(0,1) = 1 则窗口移除重复从 1 开始, 窗口取 bca
                    // 此时窗口左侧为 left = 1, 窗口右侧为 charAt('b') = 3 ,
                    // 此时窗口元素长度为 len = (3 - 1) + 1 =  3
                    //
                    // case_2 : abba
                    // 初始化 left = 0 , 走到 abb 的时候, b出现重复, 此时 left = 1
                    // 走到 ba 的时候, map 中已经存在了 'a', 此时 map.get('a') = 0
                    // 但如果此时按照 case1 的思路, 取重复字符上一个出现位置, 就会出现问题,
                    // 因为 abba 中, a(0) 与 b(2) 中还夹了另外一个重复字符 b(1)
                    // 所以,需要判断当前窗口左侧与重复字符上一次出现的位子谁更近
                    // 因为如果字符上一次出现位置在滑窗外, 实际是无效的, 所以还是以滑窗范围内的元素为有效元素
                    // 基于以上, 得出
                    // left = Math.max(left, map.get(s.charAt(right)) + 1)
                    left = Math.max(left, map.get(s.charAt(right)) + 1);
                }
                // 每次必须更新元素的出现位置,不然上述逻辑失效
                // 因为窗口是从左往右, 如果不更新位置, 将无法知道重复元素是否处于窗口内, 是否是有效元素
                map.put(s.charAt(right), right);
                // 每次窗口, 对比之前的窗口大小, 保存最大长度
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}