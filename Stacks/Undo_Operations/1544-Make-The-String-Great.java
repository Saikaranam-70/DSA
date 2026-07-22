class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length();i++){
            char c1 = s.charAt(i);
            char top  = (stack.isEmpty())?' ': stack.peek();
            if(!stack.isEmpty() &&  (Character.toLowerCase(top) == Character.toLowerCase(c1)) && top != c1){
                stack.pop();
            }else{
                stack.push(c1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}