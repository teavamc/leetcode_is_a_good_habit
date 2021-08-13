package leetcode.editor.cn.part_two;
 
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1402 👎 0

import java.util.HashMap;
import java.util.Map;

public class LRU 缓存机制{
    public static void main(String[] args) {
        Solution solution = new LRU 缓存机制().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    Integer capacity;

    Integer size;

    Map<Integer,ListNode> map;

    ListNode dummyHead;

    ListNode dummyTail;

    class ListNode{
        // 缓存键
        private Integer key;
        // 缓存值
        private Integer value;
        // 前指针
        ListNode pre;
        // 后指针
        ListNode next;

        ListNode(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }

        ListNode(){
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        // 初始化容器
        this.capacity = capacity;
        // 初始化 map
        this.map = new HashMap<>();
        // 初始化虚拟头尾
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        // 最开始, 虚拟头 -> 虚拟尾巴
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            // 如果存在数据,用过就更新
            refresh(map.get(key));
            return map.get(key).value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // 判断是否存在
        if (map.containsKey(key)){
            // 存在就更新值, 将链表刷到头部
            ListNode node = map.get(key);
            node.value = value;
            refresh(node);
            return;
        }
        // 不存在就新建
        ListNode newNode = new ListNode(key,value);
        // 判断当前缓存大小
            // 放入链表
            putNew(newNode);
            // 放入 map
            map.put(key,newNode);
            size++;
            // 如果 size 超出了容量
            while (size>capacity){
                // 满了就先删掉最少使用的
                ListNode oldTail = removeLast();
                // 清空 map
                map.remove(oldTail.key);
                size--;
            }
    }

    ListNode removeLast(){
        ListNode tail = dummyTail.pre;
        removeNode(tail);
        return tail;
    }

    void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    void putNew(ListNode node){
        // 拿到之前的头
        ListNode oldHead = dummyHead.next;
        // 放入新头
        dummyHead.next = node;
        // 重设 node 指针
        node.pre = dummyHead;
        node.next = oldHead;
        // 重设老头指针
        oldHead.pre = node;
    }

    void refresh(ListNode node){
        // 先清除之前
        removeNode(node);
        // 再放在头部
        putNew(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}