class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int a : asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a && a < 0){
                stack.pop();
            }

            if(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                if(stack.peek() == -a) stack.pop();
            }else{
                stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}