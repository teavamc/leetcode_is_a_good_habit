package leetcode.editor.cn.part_two;
 
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 955 👎 0

import leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历{
    public static void main(String[] args) {
        Solution solution = new 二叉树的中序遍历().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
// */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> midOrderList = new ArrayList<>();
        midOrder(root,midOrderList);
        return midOrderList;
    }

    /**
     * 中序遍历 左-中-右
     * 递归的解法
     * @param root
     * @param midOrderList
     */
    void midOrder(TreeNode root,List midOrderList){
        if (root==null){
            return;
        }
        if (root.left!=null){
            midOrder(root.left,midOrderList);
        }
        midOrderList.add(root.val);
        if (root.right!=null){
            midOrder(root.right,midOrderList);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}