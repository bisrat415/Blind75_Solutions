// Solution added for Q.2332 (The Latest Time to Catch a Bus) 
// It's a greedy approach that tries to find the latest possible time at each iteration

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatestTimeToCatchBus {
    public static void main(String[] args) {
        int[] buses = {10, 20};
        int[] passengers = {2,17,18,19};
        int capacity = 2;
        System.out.println(latestTimeCatchTheBus(buses, passengers, capacity));
    }
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int latestTime = 0;
        int j = 0;
        Set<Integer> departedPassengers = new HashSet<>();
        for (int i = 0; i < buses.length; i++) {
            int count = 0;
           while (j < passengers.length && count < capacity && passengers[j] <= buses[i]) {
                if (!departedPassengers.contains(passengers[j] - 1)) {
                    latestTime = passengers[j] - 1;
                }
                departedPassengers.add(passengers[j]);
                j++;
                count++;
            }
            if (count < capacity && !departedPassengers.contains(buses[i])) {
                latestTime = buses[i];
            }
        }
        
        return latestTime;
        // Let m be the length of buses and n be the length of passengers
        // Time Complexity: O(nlogn + mlogm) - sorting dominates the time. 
        // The forloop and the while loop together take O(n + m). Be mindful that it is not O(n*m) even though its nested because j is initialized outside the forloop (meaning we interate through passengers array only once) 
        // Space Complexity: O(n) because of the hashset
    }
}
