package leetcode.editor.cn;
 
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 983 👎 0

import java.util.HashMap;
import java.util.List;

public class 回文链表{
    public static void main(String[] args) {
        Solution solution = new 回文链表().new Solution();

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
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        // 先快慢指针找到中位
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast 快 slow 2 倍, 所以 fast 到达链表边界时, slow 正好在中间
        // 翻转 slow 后面的链表, 翻转后将 slow 以翻转后的链表的起点开始
        // case: [1,2,3,2,1]
        // 原本 slow = 3, 将 2 送去翻转 -> [1,2]
        // 拿到翻转后, slow = 1 , 挪到翻转后的第一个位置
        slow = reverse(slow.next);
        fast = head;
        boolean res = true;
        // 出现一个不相等的值就不是回文串
        while (fast!=null&&slow!=null){
            if (fast.val != slow.val){
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return res;
    }

    ListNode reverse(ListNode list){
        ListNode pre = null;
        while(list!=null){
            ListNode temp = list.next;
            list.next = pre;
            pre = list;
            list = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}