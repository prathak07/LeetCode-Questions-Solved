/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // postorderRecursive(root,res);
        postorderIterative(root,res);
        return res;
    }
    
    private void postorderRecursive(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        postorderRecursive(root.left,res);
        postorderRecursive(root.right,res);
        res.add(root.val);
        
    }
    
    private void postorderIterative(TreeNode root,List<Integer> res) {
        if(root==null) {
            return;
        }
        
        TreeNode prev = null;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        
        while(!stack.isEmpty()) {
            curr = stack.peek();
            
            if(prev==null || prev.left==curr || prev.right==curr) { // this helps in travelling till left subtree
                if(curr.left!=null) {
                    stack.push(curr.left);
                }
                else if(curr.right!=null) {
                    stack.push(curr.right);
                }
                else {
                    stack.pop();
                    res.add(curr.val);
                }
            }
            
            else if(curr.left==prev) { // this will travel the right subtree
                if(curr.right!=null) {
                    stack.push(curr.right);
                }
                else {
                    stack.pop();
                    res.add(curr.val);
                }
            }
            
            else if(curr.right==prev) { // if both subtrees are travelled then add current val
                stack.pop();
                res.add(curr.val);
            }
            prev = curr;
        }
    }
}