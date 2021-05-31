package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1382 👎 0

import java.util.List;

public class 删除链表的倒数第 N 个结点 {
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第 N 个结点 ().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // case 判空
            if (head == null){
                return null;
            }
            // 搞一个虚拟头,用来从头返回
            ListNode dummy = new ListNode();
            dummy.next = head;
            // 暂存当前节点的前置位节点
            ListNode pre = dummy;
            // 快慢指针
            // 慢指针表示需要删除的节点
            ListNode slow = head;
            // 快指针用来制造倒数
            ListNode fast = head;
            // 快指针先走 N 步, 再与慢指针一起走
            // 等快指针为 null, 此时慢指针所处位置就是倒数 N
            for (int i=0;i<n;i++){
                fast = fast.next;
            }
            while (fast!=null){
                pre = pre.next;
                slow = slow.next;
                fast = fast.next;
            }
            // 将慢指针前置节点直接指向慢指针后一个节点
            pre.next = slow.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}