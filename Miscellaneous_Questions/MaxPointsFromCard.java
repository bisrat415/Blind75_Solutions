// This files solves Question.1423 (Maximum Points You Can Obtain from Cards) from leetcode
public class MaxPointsFromCard {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int nMinusK = cardPoints.length - k;
        int currSum = 0;
        for (int i = 0; i < nMinusK; i++) {
            currSum += cardPoints[i];
        }
        int minSum = currSum;
        for (int j = nMinusK; j < cardPoints.length; j++) {
            currSum = currSum - cardPoints[j - nMinusK] + cardPoints[j];
            minSum = Math.min(minSum, currSum);
        }
        int total = 0;
        for (int cardPoint : cardPoints) {
            total += cardPoint;
        }
        return total - minSum;
        // Time Complexity: O(n) because all forloops are going through the array once and all the operations in the forloops are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
    
}
