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
 */
class Solution {
    //The list is accessible from anywhere
    private List<Integer> traversed ;
    public List<Integer> preorderTraversal(TreeNode root) {
        traversed = new ArrayList<>();
        //Method that will initiate the traversal
        preorder(root);
        return traversed;
    }

    private void preorder(TreeNode node){
        //Base case for recursion
        if(node == null){
            return;
        }

        traversed.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}