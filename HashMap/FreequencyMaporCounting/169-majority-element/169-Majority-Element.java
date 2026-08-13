class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxCount =0 ;
        int ans = nums[0];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()> maxCount){
                maxCount= entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}