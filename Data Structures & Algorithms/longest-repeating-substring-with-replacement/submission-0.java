class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0 ;
        //left will only iterate when the condition windowSize - maxFreq > k
        int maxfreq = 0;
        int result = 0;
        int [] count = new int[26];
        //Will hold the characters in the string
        //Objective is to replace k characters to get the longest substring of repeated characters

        for(int right = 0 ; right < s.length() ; right++){
            count[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq , count[s.charAt(right) - 'A']);
            //maxfreq is storing the maximum number of a repeating character , it will update when the left pointer iterates

            int windowSize = right - left + 1;

            int replacements = windowSize - maxfreq ;
            //replacements will determine the number of characters that can be replaced in the string , if the replacements are more than k ; windowSize should shrink such that the number of replaceble characters decrease

            if(replacements <= k){
                result = Math.max(result , windowSize);
            }else{
                count[s.charAt(left) - 'A']--;
                left++;
                //the count of the character at left should decrease to maintain the size of the windows with the conditionals
            }
        }
        

        return result;
    }
}
