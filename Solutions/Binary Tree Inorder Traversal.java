/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // inorderRecursive(root,res);
        inorderIterative(root,res);
        return res;
    }
    
    private void inorderRecursive(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        inorderRecursive(root.left,res);
        res.add(root.val);
        inorderRecursive(root.right,res);
        
    }
    
    private void inorderIterative(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(node!=null) {
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if(node.right!=null) {
                node = node.right;
                while(node!=null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
}