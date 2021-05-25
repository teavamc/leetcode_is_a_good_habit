package leetcode.editor.cn;
 
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1745 👎 0

public class 反转链表{
    public static void main(String[] args) {
        Solution solution = new 反转链表().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 最常见的解法
    // 一个 while 解决
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        while (head != null){
//            ListNode temp = head.next;
//            head.next = pre;
//            pre = head;
//            head = temp;
//        }
//        return pre;
//    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 返回的是新的头节点 , 也就是原来的尾巴节点
        ListNode newHead = reverseList(head.next);
        // 1-2-3-4-5
        // 1 - (2-3-4-5)
        // 1.next = 2
        // 2.next = null (以为在上一层已经被翻转,2 是尾巴节点,指向 null)
        // 所以 1.next.next = null
        // 1.next.next = head 实现了 2 -> 1
        head.next.next = head;
        // 1 作为尾巴 1 -> null 完成翻转
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}