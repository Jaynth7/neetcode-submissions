
class Solution {
    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        
        Set<Integer> seq = new HashSet<>();
        for(int elements : arr){
            seq.add(elements);
        }

        int max_length = 1;

        for(int element : seq){
            if((seq.contains(element - 1))) {
                continue;
            }

            int offset = 1;
            int currentCount = 1;
            while(seq.contains(offset + element)){
                offset++; 
                currentCount++;
            }

            max_length = Math.max(max_length , currentCount);
        } // 1. Closes the for-loop

        return max_length; // 2. Now safely inside the method!
    } 
}