class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(0);
            }else{
                if(!stack.isEmpty()){
                    int val = stack.pop();
                    int sum = Math.max(2*val, 1);
                    stack.push(stack.pop()+sum);
                }
            }
        }
        return stack.pop();
    }
}