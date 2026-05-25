class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        
        int [] substring = new int[26];
        int [] string = new int[26];

         
        for(int i = 0 ; i < s1.length()  ; i++){
            substring[s1.charAt(i) - 'a']++;
            //additional operation to shorten the time of execution
            string[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(substring , string)){
            return true;
        }


        int windowSize = s1.length();

        // Slide window starting AFTER the initial window
        for(int i = s1.length() ; i < s2.length() ; i++){
            string[s2.charAt(i) - 'a']++;

            //we compare the window size to the position of index i 
            //if greater , we have to iterate off the last element and consequently decrement the count of that character

            if(windowSize <= i){
                // Shrink: drop leftmost character of previous window
                // i - windowSize gives the index that just fell out
                string[s2.charAt(i - windowSize) - 'a']--;
            }

            if(Arrays.equals(substring , string)){
            return true;
        }

        }

        return false;
        
    }
}
    

