// This a a brute-force approach that finds max(prices[i], prices[j]) for all i and j such that j > i 
public class Solution_1 {
    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
    // Time Complexity: O(n^2) because of the  double forloop and the all operations in the forloop are constant time
    // Space Complexity: O(1) because only constant extra space os is used

}
