package com.ga.dataStructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;


public class Main {

    //    Exercise 1: Rotate an Array
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

    //   Write a program using the provided Stack class to check whether the pairs and the orders of {, }, (, ), [, ] are correct in an expression string exp.
    public static boolean checkPairs(String exp) {
        SingleArrayStack stack = new SingleArrayStack(exp.length());
        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if (openChar != '[' && c == ']'
                        || openChar != '(' && c == ')'
                        || openChar != '{' && c == '}') {
                    return false;
                }
            }

        }
        return stack.isEmpty();


    }

    //reverse stack
    /*
 Reflection

 Challenges:
 The hardest part was reversing the stack without using a second stack.
 My first try just popped and pushed onto the same stack, so nothing changed.
 Recursion was confusing at first, but tracing it step by step helped me see
 how each call holds one item and puts it back on the way up.
 I also passed the wrong variable in insertElementAtBottom and lost an item.

 Efficiency:
 My solution is O(n^2) because each item has to be inserted at the bottom,
 which means going through the whole stack every time. It also uses extra
 memory for the recursive calls. Using a second stack would be faster (O(n)),
 but the exercise didn't allow it.

 Applications:
 Stacks are useful whenever the last thing added should come out first,
 like undo in editors, the back button in a browser, checking brackets
 in code, and keeping track of function calls.
*/
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        insertElementAtBottom(stack, top);
    }

    public static void insertElementAtBottom(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
        } else {
            int top = stack.pop();
            insertElementAtBottom(stack, num);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotate(arr, 2, 5)));

        System.out.println(checkPairs("{[()]}"));
        System.out.println(checkPairs("(a + [b * c])"));
        System.out.println(checkPairs("([)]"));
        System.out.println(checkPairs("(a + b"));
        System.out.println(checkPairs("a + b)"));
        System.out.println(checkPairs(""));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Before: " + stack);
        reverse(stack);
        System.out.println("After:  " + stack);

    }
}
