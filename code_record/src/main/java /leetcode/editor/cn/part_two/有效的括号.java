package leetcode.editor.cn.part_two;
 
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2411 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号{
    public static void main(String[] args) {
        Solution solution = new 有效的括号().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        int len = s.length();
        // 遍历字符串
        for (int i =0;i<len;i++){
            char c = s.charAt(i);
            // 如果是结尾的括号, 那就看当然队列是否为空, 为空就拿出最新的
            if (map.containsKey(c) && !stack.isEmpty()){
                Character stackTop = stack.peek();
                if (stackTop.equals(map.get(c))){
                    stack.pop();
                }else{
                    // 如果不能匹配, 就说明存在无效的括号
                    return false;
                }
            }else {
                // 如果是左括号, 直接放进队列就好了
                stack.add(c);
            }
        }
        // 如果都跑完了, 队列不为空, 那就说明有无效的括号
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}