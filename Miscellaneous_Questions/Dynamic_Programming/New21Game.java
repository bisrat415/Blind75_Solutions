// This is a solution for Q.837 (New 21 Game)

import java.util.HashMap;
import java.util.Map;

public class New21Game {
    private static Map<Integer, Double> memo = new HashMap<>();
    public static void main(String[] args) {
        int n = 6;
        int k = 1;
        int maxPts = 10;
        System.out.println(new21Game(n, k, maxPts));
    }
     public static double new21Game(int n, int k, int maxPts) {
        int score = 0;
        return helper(score, n, k, maxPts);
    }
    public static double helper(int score, int n, int k, int maxPts) {
        if (score >= k) {
            if (score <= n) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo.containsKey(score)) {
            return memo.get(score);
        }
        double sum = 0;
        for (int i = 0; i <= maxPts; i++) {
            sum += helper(score + i, n, k, maxPts);
        }
        memo.put(score, sum / maxPts);
        return memo.get(score);
    }
}
