class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result  = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++){
            boolean found = false;
            int index = findIndex(nums1[i], nums2);
            for(int j = index;j<nums2.length;j++){
                if(nums2[j] > nums1[i]){
                    result[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            if(!found){
                result[i] = -1;
            }
        }
        return result;
    }
    public static int findIndex(int val, int[] nums){
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == val) return i;
        }
        return -1;
    }
}