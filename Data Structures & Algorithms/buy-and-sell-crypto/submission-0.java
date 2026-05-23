class Solution {
    public int maxProfit(int[] prices) {
        //Implementing the sliding window in which one variable will handle 
        int profit = 0; //only update when the current profit is bigger than the previous one
        int right = 1; //determines when to buy 
        int left = 0; //determines when to sell

        while(right < prices.length){

            if(prices[right] > prices[left]){
                profit = Math.max( profit ,prices[right] - prices[left]);
            }else{
                left = right;
            }
            //move right regardless of profit cuz thats the pointer which will reach the end when there is profit and when there isnt 
            right++;
        }

        return profit;
    }
}
