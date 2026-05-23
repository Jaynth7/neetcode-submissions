class Solution {
    public int maxProfit(int[] prices) {
        //Implementing the sliding window in which one variable will handle 
        int profit = 0; //only update when the current profit is bigger than the previous one
        int right = 1; //determines when to sell 
        int left = 0; //determines when to buy

        while(right < prices.length){

            if(prices[right] > prices[left]){
                profit = Math.max( profit ,prices[right] - prices[left]);
            }else{
                left = right; // update left when we found a cheaper price from which we could make a profit
            }
            
            right++;
        }

        return profit;
    }
}
