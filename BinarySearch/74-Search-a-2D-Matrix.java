class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m*n-1;

        while(left<=right){
            int mid = (left +  right)/2;
            int row = mid/m, col = mid%m;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}