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
    public boolean isSymmetric(TreeNode root) {
        
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();

        if(root.right==null && root.left==null){
            return true;

        }
        else if((root.right!=null && root.left==null)||(root.right==null && root.left!=null)||(root.left.val!=root.right.val)){
            return false;
            
        }
        else{
            return checkSymm(root.left,root.right);

        }
    }

    public boolean checkSymm(TreeNode n1, TreeNode n2){
        if((n1==null && n2==null)){
            return true;

        }
        else if(n1==null||n2==null||n1.val!=n2.val){
            return false;

        }
        else{
            return (checkSymm(n1.left,n2.right)&&checkSymm(n1.right,n2.left));

        }
    }
}