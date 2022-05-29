package Java;

import java.util.Arrays;
import java.util.Random;

// Binary search is an algorithm with O(log n) time-complexity. Due to the nature of the 
//     algorithm, the sample space is reduced in half for each pass of the function. A precondition
//     for the algorithm is that the collection must be sorted. Because the list is sorted, we can 
//     exploit the natural progression in order to quickly locate our target.
// General Proccess:
//     1. Compare the midpoint of the collection to the target
//     2. If they are the same - return the midpoint
//        If the target is greater, it must be in the upper half. Search again in upper sub-array
//        If the target is lesser, it must be in the lower half. Search again in lower sub-array       
//        If our search bounds become invalid, we have exhausted the list. Return null.
public class BinarySearch {
    // Fields //
    private static final Random randomGenerator = new Random();

    // Methods //
    // BinarySearchIterative is a generic, iterative implementation of the Binary Search Algorithm
    // Inputs: T[], a sorted array of type T which can be compared
    //         T, the target element to find within the given array
    public static <T extends Comparable<T>> int BinarySearchIterative(T[] elems, T target) {
        int leftIdx = 0;
        int rightIdx = elems.length - 1;
        int midIdx = rightIdx / 2;

        while(leftIdx <= rightIdx) {
            int res = target.compareTo(elems[midIdx]);
            
            if(res>0) { leftIdx = midIdx + 1; } 
            else if(res<0) { rightIdx = midIdx - 1; }
            else { return midIdx; }

            midIdx = (rightIdx + leftIdx) / 2;
        }
        return -1;
    }

    // BinarySearchRecursive is a generic, recursive implementation of the Binary Search Algorithm
    // Inputs: T[], a sorted array of type T which can be compared
    //         T, the target element to find within the given array
    public static <T extends Comparable<T>> int BinarySearchRecursive(T[] elems, T target) {
        return BinarySearchRecursive(elems, target, 0, elems.length - 1);
    }

    // BinarySearchRecursive is a generic, recursive implementation of the Binary Search Algorithm using
    //     sliding window.
    // Inputs: T[], an array of type T which can be compared
    //         T, the target element to find within the given array
    //         int, the index of the left-most element of the subarray
    //         int, the index of the right-most element of the subarray
    // Outputs: T, the target 
    private static <T extends Comparable<T>> int BinarySearchRecursive(T[] elems, T target, int leftIdx, int rightIdx) {
        // Base Case
        if(leftIdx>rightIdx) { return -1; }
        
        int midIdx = (leftIdx + rightIdx) / 2;
        int res = target.compareTo(elems[midIdx]);

        if(res>0) { leftIdx = midIdx + 1; } 
        else if(res<0) { rightIdx = midIdx - 1; }
        else { return midIdx; }

        // Recursive call
        return BinarySearchRecursive(elems, target, leftIdx, rightIdx);
    }

    public static void main(String[] args) {
        // Generate random sorted array
        int len = 100;
        int lenSquared = len * len;
        Integer[] nums = new Integer[len];
        for (int i=0; i<len; i++) {
            nums[i] = randomGenerator.nextInt(lenSquared);
        }
        Arrays.sort(nums);

        // Test success case
        int targetIdx = randomGenerator.nextInt(len);
        int target = nums[targetIdx];
        int iterativeResult = BinarySearchIterative(nums, target);
        int recursiveResult = BinarySearchRecursive(nums, target);
        System.out.println("Targeting: " + target + " at nums[" + targetIdx + "]");
        System.out.println("\tIteratively found " + nums[iterativeResult] + " at nums[" + iterativeResult + "]");
        System.out.println("\tRecursively found " + nums[recursiveResult] + " at nums[" + recursiveResult + "]");
        assert iterativeResult==targetIdx;
        assert recursiveResult==targetIdx;
        System.out.println("Success!");

        System.out.println();
        
        // Test fail case
        targetIdx = -1;
        target = nums[0] - 10;
        iterativeResult = BinarySearchIterative(nums, target);
        recursiveResult = BinarySearchRecursive(nums, target);
        System.out.println("Targeting: " + target + " which is not in the array");
        System.out.println("\tIteratively got " + iterativeResult);
        System.out.println("\tRecursively got " + recursiveResult);
        assert iterativeResult==targetIdx;
        assert recursiveResult==targetIdx;
        System.out.println("Success!");
    }
}