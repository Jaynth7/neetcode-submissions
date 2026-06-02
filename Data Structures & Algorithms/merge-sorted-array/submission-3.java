class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int last  = m + n - 1;

        //This solution is with the consideration that all operations are done on nums1
        //Three pointers last , m , n 
        //last pointer will iterate through the whole array
        //m and n will iterate only within its valid array 
        //m and n's respective elements are compared , and if nums1[m - 1] > nums2[n - 1] , then nums[m - 1] is added into the position of last which is at the vacant position(0)
       while(m > 0 && n > 0){
        if(nums1[m - 1] > nums2[n - 1]){
            nums1[last] = nums1[m - 1];
            m--;
        }else{
            nums1[last] = nums2[n - 1];
            n--;
        }

        last--;
       }

       //each and every pointer should decrement after its operation

        //This is when elements of nums2 still remain , the array is already sorted therefore we only have to add in the elements from nums2 -> nums1
       while(n > 0){
        nums1[last] = nums2[n - 1];
        last--;
        n--;
       }
        
    }
}

/*
for(int i = 0 ; i < n ;i++){
        nums1[m + i] = nums2[i];
       }

       Arrays.sort(nums1);

       System.out.print(nums1);
*/