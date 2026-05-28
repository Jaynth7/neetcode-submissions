class Solution {
    public boolean validPalindrome(String s) {

        int count = 0;
        

        int left = 0 ;
        int right = s.length() -1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return palinchecker(s , left + 1 , right) ||  palinchecker(s , left ,right - 1);
            }

            left++;
            right--;
        }

        


        return true;  
    }
}

private boolean palinchecker(String s , int left , int right){
    while(left < right){
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }


        left++;
        right--;
    }

    return true;
}