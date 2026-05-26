class Solution {
    public String minWindow(String s, String t) {
        Map<Character , Integer> need = new HashMap<>();
        //We add the elements of t and their count into the hashmap

        for(int i = 0 ; i < t.length() ; i++){
            need.put(t.charAt(i) , need.getOrDefault(t.charAt(i) , 0) + 1);
        } 

        int bestlength = Integer.MAX_VALUE;
        int left = 0;
        int have = 0;
        int total = need.size();
        int bestleft = -1;

        //these variables determine the size of the window


        Map<Character , Integer> windows = new HashMap<>();

        for(int right = 0 ; right < s.length() ; right++){
            char c = s.charAt(right);
            windows.put(c , windows.getOrDefault(c , 0) + 1);

            if (need.containsKey(c) && need.get(c).equals(windows.get(c))){
                have++;
            }
            

            //Loop only operates when all the elements in the t are found within the window
            while(have == total){

                //this operation saves the position of the array which follows the pre-defined conditions and is valid
                if(right - left + 1 < bestlength ){
                    bestlength = right - left + 1;
                    bestleft = left;
                }

                char lc = s.charAt(left);
                windows.put(lc , windows.get(lc) - 1);
                //decrements the count of that element in windows

                if(need.containsKey(lc)  && windows.get(lc) < need.get(lc)){
                    have--;
                    //if that very element is a part of need and if the count within the windows drops below the necessary , we dont "have" a substring
                }

                left++;
            }

        }

        return bestleft == -1 ? "" : s.substring(bestleft, bestleft + bestlength);
    }
}
