package leetcode.editor.cn.part_two;
 
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 411 👎 0

public class 字符串相加{
    public static void main(String[] args) {
        Solution solution = new 字符串相加().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        // 可变字符串
        StringBuilder res = new StringBuilder("");
        // i 与 j 是两个指针, 用于确定需要计算的字符位置
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 进位
        int carry = 0;
        // 都小于 0 时结束
        while(i >= 0 || j >= 0){
            // 分别拿到当前位置的数字
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // 求和(加上进位)
            int tmp = n1 + n2 + carry;
            // 更新进位
            carry = tmp / 10;
            // 取和的各位
            res.append(tmp % 10);
            // 指针向前进位
            i--;
            j--;
        }
        // 如果数字计算完之后, 还有进位, 向前进一
        if(carry == 1) res.append(1);
        // 翻转
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}