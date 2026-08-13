class Solution {
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int num : nums){
    //         map.put(num, map.getOrDefault(num, 0)+1);
    //     }
    //     PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
    //         new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

    //     for(Map.Entry<Integer, Integer> entry: map.entrySet()){
    //         minHeap.offer(entry);
    //         if(minHeap.size()>k) minHeap.poll();
    //     }
    //     int[] result = new int[k];
    //     int s = 0;
    //     while(!minHeap.isEmpty()){
    //         result[s++] = minHeap.poll().getKey();
    //     }
    //     return result;
    // }
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length)return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)->a.getValue()-b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k)pq.poll();
        }
        int[] result = new int[k];
        int s = 0;
        while(!pq.isEmpty()){
            result[s++] = pq.poll().getKey();
        }
        return result;
    }
}