// Best Time to Buy and Sell Stock
// Leetcode 121 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStock {
    static int maxProfit(int[] prices){
        // IDeclare a variable minPrice which will store the minimum element, initialized with prices[0]
        int minPrice = prices[0];
        // Declaree a variable maxProf which will store the maximum profit, initialized with 0
        int maxProf = 0;

        // Run a loop from 0 to arr.length (exclusive)
        for(int i = 0; i < prices.length; i++){
            // Profit will be (current price - minPrice)
            int profit =  prices[i] - minPrice;
            // maxProf will be the maximum between the two -  maxProf and profit
            // Update maxPrice if it is less than the current profit
            maxProf = Math.max(maxProf, profit);
            // minPrice will be the minimum between the two - minPrice and current price
            // Update minPrice if it is greater than the current price
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

        System.out.println(maxProfit(arr));
    }
}
