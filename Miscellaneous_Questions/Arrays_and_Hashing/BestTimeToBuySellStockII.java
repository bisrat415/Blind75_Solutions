// This is a solution for Q.122(Best Time to Buy and Sell Stock II) from Leetcode
public class BestTimeToBuySellStockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
	    for (int i = 1; i < prices.length; i++) {
		    if (prices[i] > prices[i - 1]) {
	            maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
        // Time Complexity: O(n) because we are traversing through the array once and all the operations in the forloop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
}
