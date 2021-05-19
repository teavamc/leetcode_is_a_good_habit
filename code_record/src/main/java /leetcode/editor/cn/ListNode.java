package leetcode.editor.cn;

import java.io.Serializable;

/**
 * @Package leetcode.editor.cn
 * @date 2021/5/19 10:21
 */
public class ListNode implements Serializable {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}