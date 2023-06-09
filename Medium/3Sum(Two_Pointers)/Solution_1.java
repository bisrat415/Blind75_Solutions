// This solution is a brute force approach going through each and every number in the array with triple forloop

import java.util.*;

public class Solution_1 {
    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Set<Integer>> check = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        Set<Integer> set = new HashSet<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        if (!check.contains(set)) {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            ans.add(list);
                            check.add(set);
                        }
                        
                    }
                }
            }

        }
        return ans;
        // Let n be the size of the array
        // Time Complexity: O(n^3) because of a triple forloop
        // Space Complexity: O()
    }
    
}
