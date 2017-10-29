import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); i++){
            String item = String.valueOf(s.charAt(i));
            if(isLeftPart(item)){
                stack.push(item);
            }
            else if(stack.size() > 0){
                String left = stack.pop();
                if(left == null || !isMatch(left, item)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.size() > 0 ? false : true;
    }

    private boolean isLeftPart(String s){
        if(s == null){
            return false;
        }
        if(s.equals("{")|| s.equals("[")|| s.equals("(")){
                return true;
        }
        return false;
    }

    private boolean isMatch(String left, String right){
        if(left.equals("(") && right.equals(")"))
            return true;
        if(left.equals("[") && right.equals("]"))
            return true;
        if(left.equals("{") && right.equals("}"))
            return true;
        return false;
    }
}