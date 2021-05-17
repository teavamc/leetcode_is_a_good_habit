package leetcode.editor.cn;
 
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 202 👎 0

public class 二叉树的堂兄弟节点{
    public static void main(String[] args) {
        Solution solution = new 二叉树的堂兄弟节点().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
// */
class Solution {
//    设置全局变量,方便递归调用
    int x;
    int leftLevel = 0;
    TreeNode leftPar = null;
    Boolean findLeft = false;

    int y;
    int rightLevel = 0;
    TreeNode rightPar = null;
    Boolean findRight = false;


    //判断是否是兄弟节点
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root,0,null);
//        两个条件, 处于同一个位置 并且 父节点不同
        return (leftLevel == rightLevel) && (leftPar != rightPar);
        
    }

    void dfs(TreeNode root,int level,TreeNode par){

        if (root == null){
            return;
        }
        // 如果当前找到对应的值就存入全局变量
        if (root.val == x){
            leftPar = par;
            findLeft = true;
            leftLevel = level;
        }else if(root.val == y){
            rightPar = par;
            findRight = true;
            rightLevel = level;
        }
        // 如果两个节点都找到了就返回
        if (findLeft && findRight){
            return;
        }
        // 否者找左子树
        dfs(root.left,level+1,root);
        // 如果左子树都找完了 看下都找到了没有
        if (findLeft && findRight){
            return;
        }
        // 没有就接着找右子树
        dfs(root.right,level+1,root);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}