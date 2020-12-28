package leetcode.editor.cn;
 
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 306 👎 0

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205{
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings205().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        // 两个容器互相映射
        Map<Character,Character> s_map = new HashMap<Character,Character>();
        Map<Character,Character> t_map = new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char s_c = s.charAt(i);
            char t_c = t.charAt(i);
            if ((s_map.containsKey(s_c) && !s_map.get(s_c).equals(t_c))
            || (t_map.containsKey(t_c) && !t_map.get(t_c).equals(s_c))){
                return false;
            }
            s_map.put(s_c,t_c);
            t_map.put(t_c,s_c);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}