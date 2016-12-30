/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // preorderRecursive(root,res);
        preorderIterative(root,res);
        return res;
    }
    
    private void preorderRecursive(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        res.add(root.val);
        preorderRecursive(root.left,res);
        preorderRecursive(root.right,res);
        
    }
    
    private void preorderIterative(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if(node.right!=null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
            }
        }
    }
}