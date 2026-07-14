class Solution {
    public int maxProfit(int[] prices) {
        //I only know Greedy Algo at this stage

        //Initial Profit of Zero
        int profit = 0 ;


        for(int i = 1 ; i < prices.length ;i++){
            if(prices[i] > prices[i - 1]){
                //Purchase the stock at yesterday's price and sell it today

                profit += (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }
}