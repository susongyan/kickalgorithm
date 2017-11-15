import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left == null && root.right == null){
            result.add(root.val+"");
            return result;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for(String path : leftPaths){
            result.add(root.val + "->" + path);
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for(String path: rightPaths){
            result.add(root.val + "->" + path);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}