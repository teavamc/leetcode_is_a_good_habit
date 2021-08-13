package leetcode.editor.cn.part_two;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1708 👎 0

import leetcode.editor.cn.ListNode;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        Solution solution = new 合并两个有序链表().new Solution();

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 边界判空
            if (l1 == null && l2 == null) {
                return null;
            }
            // 虚拟头
            ListNode dummy = new ListNode();
            ListNode newListNode = dummy;
            dummy.next = newListNode;
            // 遍历两个链表,谁小谁先挂在新链表后面
            // 因为排序是从小到大
            while (l1 != null && l2 != null) {
                // 暂存需要挪动的节点
                ListNode tempNode = null;
                // 判断l1/l2 中哪个需要挪
                if (l1.val < l2.val) {
                    tempNode = l1;
                    l1 = l1.next;
                }else{
                    tempNode = l2;
                    l2 = l2.next;
                }
                // 将缓存的节点组装到新链表
                newListNode.next = tempNode;
                newListNode = newListNode.next;
            }
            // 肯定是先诺空其中一个链表
            if (l1 != null) {
                newListNode.next = l1;
            }
            if (l2 != null) {
                newListNode.next = l2;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}