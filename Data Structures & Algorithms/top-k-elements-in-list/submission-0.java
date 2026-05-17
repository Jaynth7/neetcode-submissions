

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Fix 1: Capitalized 'M' in HashMap
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        // Fix 2: Added 'int' data type to 'n'
        for(int n : map.keySet()){
            int freq = map.get(n);

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }

            // Fix 3: Changed 'bucket' to 'buckets' to match declaration
            buckets[freq].add(n);
        }

        int result[] = new int[k];
        int index = 0;

        // Fix 4: Changed the comma after buckets.length - 1 to a semicolon
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] != null){
                // Fix 5: Added 'int' data type to 'element'
                for(int element : buckets[i]){
                    result[index++] = element;
                    if(index == k){
                        return result;
                    }
                }
            }
        }

        return result;
    }
}