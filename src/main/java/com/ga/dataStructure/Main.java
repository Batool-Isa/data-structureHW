package com.ga.dataStructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public class Main {

    //    Exercise 1: Rotate an Array
//    Objective: Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
//
//    Input: An array arr[], the number of positions d to rotate, and the size of the array n.
//            Output: The array rotated by d positions.
//    Instructions
//    Implement the rotation in a function called rotate.
//    Handle cases where d > n.
//    Test the function with multiple values of d and array
    public static int[] rotate(int[] arr, int d, int n) {
        if (n == 0) {
            return arr;
        }
        Queue<Integer> queue = new ArrayDeque<>(n);
        // add numbers to the queue
        for (int num : arr) {
            queue.offer(num);
        }
        // handle all cases . if d > n take full turn  and the rest
        d = d % n;

        for (int i = 0; i < d; i++) {
            // remove element from front of queue
            int frontElement = queue.poll();
            // readd at the back
            queue.offer(frontElement);
        }

        for (int k = 0; k < n; k++) {
            arr[k] = queue.poll();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotate(arr, 2, 5)));
    }
}
