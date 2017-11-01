/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * 树的层序遍历
  */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0)); // <TreeNode, level>  用队列主要是为了遍历的时候FIFO 递增层级
        while(!queue.isEmpty())  {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            // 这表示已经进入下一层级
            if(level  == result.size()){
                result.add(new ArrayList<>());
            }

            if(node == null)
            {
                continue;
            }

            result.get(level).add(node.val);

            if(node.left != null){
                queue.offer(new Pair<>(node.left, level + 1));
            }
            if(node.right != null){
                queue.offer(new Pair<>(node.right, level + 1));
            }
        }
        return result;
    }

    class Pair<TKey,TValue>{
        private TKey key;
        private TValue value;

        public TKey getKey() {
            return key;
        }

        public TValue getValue() {
            return value;
        }

        public Pair(TKey key, TValue value){
            this.key = key;
            this.value = value;
        }
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }
}