// Problem Statement: You are given n items whose weights and values are known, as well as a knapsack to carry these items. 
// The knapsack cannot carry more than a certain maximum weight, known as its capacity.
// You need to maximize the total value of the items in your knapsack, while ensuring that the sum of the weights of the selected items does not exceed the capacity of the knapsack.
// If there is no combination of weights whose sum is within the capacity constraint, return 0
// Notes: An item may not be broken up to fit into the knapsack, i.e., an item either goes into the knapsack in its entirety or not at all.
//          We may not add an item more than once to the knapsack.
public class ZeroOneKnapsack {
    private static Integer[][] memo;
    public static void main(String[] args) {
        int[] weights = {10, 20,30};
        int[] values = {22, 33, 44};
        int capacity = 30;
        System.out.println(findMaxKnapsackProfit(capacity, weights, values));
    }
    
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        // Your code will replace the placeholder below
        memo = new Integer[weights.length + 1][capacity + 1];
        return helper(capacity, weights, values, weights.length - 1);
    }
    public static int helper(int capacity, int[] weights, int[] values, int i) {
        if (capacity == 0 || i < 0) {
            return 0;
        }
         if (memo[i][capacity] != null) {
            return memo[i][capacity];
        }
        int result = 0;
        if (weights[i] > capacity) {
            result = helper(capacity, weights, values, i - 1);
        } else {
            result = Math.max(values[i] + helper(capacity - weights[i], weights, values, i - 1), helper(capacity, weights, values, i - 1));
        }
        memo[i][capacity] = result;
        return result;
        

    }
}