class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        if(right < left) return -1;

        int mid = left + (right-left)/2;

        if(nums[mid] == target) return mid;

        if(nums[mid] < target){
            return binarySearch(nums, target, mid+1, right);
        }
        return binarySearch(nums, target, left, mid-1);
    }
}

/*
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}*/