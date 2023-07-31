import java.util.Random;

public class ShuffleArray {
    int[] array;
    int[] original;
    Random rand = new Random();
    public ShuffleArray(int[] nums) {
        array = nums;
        original = array.clone();
    }
    
    public int[] reset() {
        array = original;
        original = array.clone();
        return array;
    }
    
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(i, j);
        }
        return array;
        // Let n be the length of the array
        // Time Complexity: O(n) - we are traversing through the array once and generating a random index and swapping two values can be done in constant time
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
