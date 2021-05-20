package leetcode.editor.cn;
 
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 905 👎 0

import java.util.Stack;

public class 最小栈{
    public static void main(String[] args) {
        Solution solution = new 最小栈().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    // 正常的栈
    Stack<Integer> common;
    // 最小栈, 始终保存最小元素
    Stack<Integer> min;


    /** initialize your data structure here. */
    public MinStack() {
        common = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        common.push(val);
        if (min.isEmpty()){
            min.push(val);
        }else{
            // 最小栈始终放当前最小的元素
            // 如果元素比最小的栈要小, 那就放入当前元素在最小栈
            if (val < min.peek()){
                min.push(val);
            }else{
                // 否则还是放之前最下最小的元素
                min.push(min.peek());
            }
        }
    }
    
    public void pop() {
        common.pop();
        min.pop();
    }
    
    public int top() {
        return common.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}