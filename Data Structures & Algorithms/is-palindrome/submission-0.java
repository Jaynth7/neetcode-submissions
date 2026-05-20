class Solution {
    public boolean isPalindrome(String s) {

        int i = 0 ;
        int j = s.length() - 1;

        //can use two methods 
        //1 . Remove all the non-alphanumeric characters - replaceall(regex ,"")
        // String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); - anything that is NOT a-z, A-Z, or 0-9
        //2 . if there is non-alphanumeric characters , skip to the next character in the String

        while (i < j){

            while(i < j && !(Character.isLetterOrDigit(s.charAt(i)))){
                i++;
            }

            while(i < j && !(Character.isLetterOrDigit(s.charAt(j)))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            

            i++;
            j--;
        }

        return true;
    }
}
