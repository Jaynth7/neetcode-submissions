class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        


        for(int i = 0 ; i < matrix.length ;i++){

            int left = 0;
            int right = matrix[0].length - 1;

         // Since each row is sorted, the target can only be in this row
          // if it lies between the first and last elements.
          if(target < matrix[i][0] || target > matrix[i][right]){
            continue;
          }

          // Checking whether the target falls within this row's range before binary searching.


          while(left <= right){
            int mid = left + (right - left) /2;

            if(matrix[i][mid] == target){
                return true;
            }else if(matrix[i][mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }


          } 

            
        }



        return false;
    }
}
