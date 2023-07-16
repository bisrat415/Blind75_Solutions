// This is Q.359(Logger Rate Limiter) from Leetcode
// We use a hashmap to map each unique message to a timestamp
package Miscellaneous_Questions.Hashing;

import java.util.*;
class Logger {
    Map<String, Integer> mapMessageToTime;

    public Logger() {
        mapMessageToTime = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (mapMessageToTime.containsKey(message)) {
            if (timestamp - mapMessageToTime.get(message) < 10) {
                return false;
            }
        }
        mapMessageToTime.put(message, timestamp);
        return true;
    }
    // Time Complexity: O(1) - all the operations are hashmap related so they are all constant time
    // Space Complecity; O(n) where n is the total number of the incoming unique messages
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */