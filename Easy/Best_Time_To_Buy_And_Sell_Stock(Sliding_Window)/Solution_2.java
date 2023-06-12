// This solution uses a one pass approach to find the lowest price and calculate the maximum profit from the lowest price
public class Solution_2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = prices[i] < minPrice ? prices[i] : minPrice;
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            
        }
        return maxProfit;
       
        // Time Complexity: O(n) because we are looping through array once
        // Space Complexity: O(1) because we only used constant extra space
    }
    
}
