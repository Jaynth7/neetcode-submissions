class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Sorting + Two Pointers
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int numOfBoats = 0;

        while(left <= right){

            if(people[left] + people[right] <= limit){
                left++;
            }
            //Add the rightmost element into a boat and decrement right
            //Statement will also get triggered whenever right == left
            numOfBoats++;
            right--;
        }

        return numOfBoats;
    }
}


/*Absolutely Wrong

int numOfBoats = 0;
        int left = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < people.length ; i++){
            map.put(people[i] , map.getOrDefault(people[i] , 0) + 1);
        }

        for(int p : people){
            int diff = limit - p;
            if(map.containsKey(diff) && map.get(p) > 0){
                 map.put(diff , map.get(diff) - 1);
                 numOfBoats++;
            }

            if(diff == 0){
                numOfBoats++;
            }
            map.put(p , map.get(p) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                 if(entry.getValue() != 0){
                    if(entry.getValue() * entry.getKey() <= limit){
                        numOfBoats++;
                    }
                 }
        }



        return numOfBoats;
    }
*/