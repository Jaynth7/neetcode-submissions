class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0 ;

        //left pointer will keep on iterating till the duplicate is found and removed 
        // the reasoning is that it should be a substring that contains unique elements 
        // if there is any duplicate the whole condition breaks so the substring which has the duplicate will also have to break

        int left = 0;

        for(int right = 0 ; right < s.length() ; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
                // duplicate found — shrink window from left until it's removed
            }


            set.add(s.charAt(right));


            maxLength = Math.max(maxLength , set.size());
             // set.size() = current window size, track the max seen so far

        }

        return maxLength;
    }
}
