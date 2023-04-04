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

    private int firstRoot = 0;
    private Map<Integer, Integer> upperB = new HashMap();
    private Map<Integer, Integer> lowerB = new HashMap();

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;

        }else if(root.left == null && root.right == null){
            return true;

        }else if(root.left == null){
            lowerB.put(root.right.val, root.val);
            return isValid_2(root.right);

        }else if(root.right == null){
            upperB.put(root.left.val, root.val);
            return isValid_2(root.left);

        }else{
            lowerB.put(root.right.val, root.val);
            upperB.put(root.left.val, root.val);
            return isValid_2(root.left) && isValid_2(root.right);
        }
    }

    public boolean isValid_2(TreeNode node){

        if(node == null){
            return true;
        }else if(node.left == null && node.right == null){
            if(checkUbAndLb(node) == true){
                //to dooo
                return true;
            }else return false;

        }else if(node.left == null){
            if(checkUbAndLb(node) == true){
            lowerB.put(node.right.val, node.val);
            if(upperB.get(node.val) != null){
                upperB.put(node.right.val, upperB.get(node.val));
            }
            return isValid_2(node.right);
            }else return false;

        }else if(node.right == null){
            if(checkUbAndLb(node) == true){
            upperB.put(node.left.val, node.val);
            if(lowerB.get(node.val) != null){
                lowerB.put(node.left.val, lowerB.get(node.val));
            }
            return isValid_2(node.left);
            }else return false;

        }else{
            if(checkUbAndLb(node) == true){
            lowerB.put(node.right.val, node.val);
            upperB.put(node.left.val, node.val);
            if(upperB.get(node.val) != null){
                upperB.put(node.right.val, upperB.get(node.val));
            }
            if(lowerB.get(node.val) != null){
                lowerB.put(node.left.val, lowerB.get(node.val));
            }
            return isValid_2(node.left) && isValid_2(node.right);
            }else return false;

        }
    }

    public boolean checkUbAndLb(TreeNode node){

        if(lowerB.get(node.val) != null && upperB.get(node.val) != null){
            if(node.val <= lowerB.get(node.val) || node.val >= upperB.get(node.val)){
                return false;
            }else{
                return true;
            }

        }else if(lowerB.get(node.val) == null){
            if(node.val >= upperB.get(node.val)){
                return false;
            }else{
                return true;
            }

        }else{ //upperB.get(node.val) == null
            if(node.val <= lowerB.get(node.val)){
                return false;
            }else{
                return true;
            }
        }
    }
}