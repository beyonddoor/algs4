package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 假设某个用例程序会进行一系列人栈和出栈的混合栈操作。入栈操作会将整数◎到9按顺序压人栈；出栈操作会打印出返回值。下面哪种序列是不可能产生的？
 */
public class E1_3_3 {
    public static boolean test(int[] array) {
        StdOut.println("process "+ Arrays.toString(array));
        var current = 0;
        var stack = new Stack<Integer>();
        for (var val : array) {
            while(current<=val) {
                StdOut.println("push="+current);
                stack.push(current);
                current ++;
            }

            if(!stack.isEmpty() && val == stack.peek()) {
                var popValue = stack.pop();
                StdOut.println("pop="+popValue);
            } else {
                StdOut.println("fail="+val + ", stack"+stack);
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println(test(new int[] {
                4,3,2,1, 0,9,8,7,6,5
        }));
        StdOut.println(test(new int[] {
                4,6,8,7,5,3,2,9,0,1
        }));
        StdOut.println(test(new int[] {
                2,5,6,7,4,8,9,3,1,0
        }));
        StdOut.println(test(new int[] {
                4,3,2,1,0,5,6,7,8,9
        }));
        StdOut.println(test(new int[] {
                1,2,3,4,5,6,9,8,7,0
        }));
        StdOut.println(test(new int[] {
                0,4,6,5,3,8,1,7,2,9
        }));
        StdOut.println(test(new int[] {
                1,4,7,9,8,6,5,3,0,2
        }));
        StdOut.println(test(new int[] {
                2,1,4,3,6,5,8,7,9,1
        }));
    }
}
