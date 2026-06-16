class TimeMap {
    

    //Creating my own static class that will serve as the value in the key-value pair 
    public static class DataPair{
        String value;
        int timestamp;

        public DataPair(String s , int t){
            this.value = s;
            this.timestamp = t;
        } 
    }


    private Map<String , List<DataPair>> map ;
    public TimeMap() {
        map = new HashMap<>();
        //Initializing the Hashmap
    }
    
    public void set(String key, String value, int timestamp) {
        //Condition when key doesnt exist

        map.putIfAbsent(key , new ArrayList<>());
        //Get the key , and append the value to the array of type DataPair
        map.get(key).add(new DataPair(value , timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }


        //Now we will have to get the list that corresponds to that key

        List<DataPair> list = map.get(key);

        //Implementing Binary Search
        int left = 0;
        int right = list.size() - 1;
        String res = "";


        if (list.get(right).timestamp <= timestamp) {
           return list.get(right).value; // Instant O(1) return!
        }

    // Quick check for the alternative extreme: requested time is BEFORE our very first entry
        if (list.get(0).timestamp > timestamp) {
            return "";
        }

        while(left < right){
            //Formula is changed
            int mid = left + (right - left + 1)/2;

            //We are taking the position of each DataPair object within the list and checking their timestamp value
            if(list.get(mid).timestamp <= timestamp){
                //Change in the usual operation of left = mid + 1 , bcz the while condition is left < right 
                left = mid ;
            }else{
                right = mid - 1;
                //This operation also executes when the timestamp does not exist
            }
        }

        

        return list.get(left).value;
    }
}
