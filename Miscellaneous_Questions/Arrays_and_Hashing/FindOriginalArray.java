// This is a solution for Q.2007 (Find Original Array From Doubled Array) from Leetcode

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArray {
    public static void main(String[] args) {
        int[] changed = {1,3,4,2,6,8};
        System.out.println(Arrays.toString(findOriginalArray(changed)));
    }
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        int[] result = new int[changed.length / 2];
        for (int i = 0; i < changed.length; i++) {
            int currNum = changed[i];
            if (map.get(currNum) > 0) {
                map.put(currNum, map.get(currNum) - 1);
                int doubled = currNum * 2;
                if (map.containsKey(doubled) && map.get(doubled) > 0) {
                    result[idx] = currNum;
                    idx++;
                    map.put(doubled, map.get(doubled) - 1);
                } else {
                    return new int[]{};
                }
            }
        }
        return result;
        // Let n be the length of the input array changed
        // Time Complexity: O(nlogn) because of the sorting
        // Space Complexity: O(n) because of the hashmap 
    }

}
