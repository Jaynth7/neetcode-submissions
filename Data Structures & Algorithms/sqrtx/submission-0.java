class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }

        int left = 1;
        int right = x / 2;
        int result = 0;


        //We know that the root of x would be between 1 and x/2

        while(left <= right){
            int mid = left + (right -left) / 2;

            //mid *mid <= x , fundamental rule 
            if(mid <= x / mid){
                result = mid ;

                //What if we have another element in the sequence?
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }


        return result;
    }
}