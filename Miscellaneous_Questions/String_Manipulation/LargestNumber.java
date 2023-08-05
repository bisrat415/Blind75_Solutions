import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    // class Compare implements Comparator<String> {

    //     public int compare(String a, String b) {
    //         return (b + a).compareTo(a + b);
    //     }
    // }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] stringNums = new String[n];
        for (int i = 0; i < n; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, (a, b) -> (b + a).compareTo(a + b)); // Or we can create a custom class that extends the comparator interface like the
                                                                     // above and initialize one in here
        StringBuilder sb = new StringBuilder();
        for (String num : stringNums) {
            sb.append(num);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
        // Let n be the length of the array nums
        // Time Complexity: O(nlogn) because of the sorting. The rest of the operations
        // are O(n)
        // Space Complexity: O(n) because of the array stringNums and the string builder
    }
}
