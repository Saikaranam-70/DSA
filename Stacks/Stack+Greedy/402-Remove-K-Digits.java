class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        for(char ch: num.toCharArray()){
            int n = ch - '0';
            while(!stack.isEmpty() && stack.peek() > n && k>0){
                stack.pop();
                k--;
            }
            stack.push(n);

            
        }
        while(k>0){
                stack.pop();
                k--;
            }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
    }
}