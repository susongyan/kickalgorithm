import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用栈模拟递归的调用顺序
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go",root));
        while(stack.size() > 0){
            Command command = stack.pop();

            if(command.s.equals("print")){
                result.add(command.node.val);
            }else{
                // 根据栈 FILO 倒过来放入(变成中序和后序,只需要改变 push("print",command.node) 的位置)
                if(command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }
                if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print",command.node));
            }
        }
        return result;
    }

    /**
     * 经典 非递归先序遍历
     */
    public List<Integer> preorderTraversalClassical(TreeNode root){
        Stack<Integer> stack = new Stack<Integer>();
        TreeNode cur = root;
        
    }

    public class Command{
        String s; //go , print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
}
