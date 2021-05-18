package leetcode.editor.cn;
 
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6207 👎 0

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 两数相加{
    public static void main(String[] args) {
        Solution solution = new 两数相加().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for singly-linked list.
  public class ListNode implements Serializable {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
// */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 放入队列的用途是方便左右对齐
        LinkedList<ListNode> s1 = new LinkedList<ListNode>();
        while (l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        LinkedList<ListNode> s2 = new LinkedList<ListNode>();
        while (l2!=null){
            s2.push(l2);
            l2 = l2.next;
        }
        // 新结果
        ListNode res = null;
        int part = 0;
        while(!s1.isEmpty()||!s2.isEmpty()||part!=0){
            int temp1 = s1.isEmpty() ? 0 : s1.pollLast().val;
            int temp2 = s2.isEmpty() ? 0 : s2.pollLast().val;
            int newVal = temp1 + temp2 + part;
            if (newVal >= 10){
                part = newVal/10;
                newVal = newVal%10;
            }else{
                part = 0;
            }
            if (res == null){
                res = new ListNode(newVal);
            }else{
                ListNode pre = res;
                res = new ListNode(newVal);
                res.next = pre;
            }
        }
        // 翻转链表
        ListNode pre = null;
        while(res != null){
            ListNode tempNode = res.next;
            res.next = pre;
            pre = res;
            res = tempNode;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}