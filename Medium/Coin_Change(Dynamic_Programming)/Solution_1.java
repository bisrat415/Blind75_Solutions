// This solution uses recursion with memoization
import java.util.*;
public class Solution_1 {
    private static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
       	if (amount < 0) {
            return -1;
        }
       	int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
		    int currMin = coinChange(coins, amount - coin);
		    if (currMin >= 0 && currMin < answer) {
			    answer = 1 + currMin;
		    }
        }

        memo.put(amount, answer == Integer.MAX_VALUE ? -1 : answer);
        return memo.get(amount);
        // Let n be the size of the array, coins and s amount
        // Time Complexity: O(n * s) -  In the worst case the recursive tree of the algorithm has height of s and the algorithm solves only s subproblems because it caches precalculated solutions in a table. Each subproblem is computed with n iterations, one by coin denomination. So that will be n * s
        // Space Complexity: O(s) - in the worst case the recursive tree of the algorithm has height of s and memo also takes O(s) space
    }
}
