package Miscellaneous_Questions;

public class findMaxConsecutiveOnes {
    public static void main(String[] args) {
        
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            while (zeroCount >  1) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                } 
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            right++;

        }
        return right - left > maxLength ? right - left : maxLength;
    }
}
