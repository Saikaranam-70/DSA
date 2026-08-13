class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        List<Character>[] buckets = new List[s.length()+1];

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = s.length();i>=1;i--){
            if(buckets[i] != null){
                for(char ch: buckets[i]){
                    sb.append(String.valueOf(ch).repeat(i));
                }
            }
        }
        return sb.toString();
    }
}