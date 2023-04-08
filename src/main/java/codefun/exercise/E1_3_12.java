package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个可迭代的Stack用例，它含有一个静态的copy方法，
 * 接受一个字符串的栈作为参数并返回该栈的一个副本。注意：这种能力是达代器价值的一个重要体现，因为有了它我们无需改变基本API就能够实现这种功能。
 */
public class E1_3_12 {
    public static Stack<String> copy(Stack<String> original) {
        var stack = new Stack<String>();
        var stackOut = new Stack<String>();
        for (var s : original) {
            stack.push(s);
        }
        while(!stack.isEmpty()) {
            stackOut.push(stack.pop());
        }
        return stackOut;
    }

    public static void main(String[] args) {
        var stack = new Stack<String>();
        for(int i=0; i<5;i++) {
            stack.push(Integer.toString(i));
        }

        StdOut.print("origin");
        for (var s : stack) {
            StdOut.print(s);
            StdOut.print(" ");
        }

        StdOut.print("\ncopy");
        for (var s : copy(stack)) {
            StdOut.print(s);
            StdOut.print(" ");
        }

    }
}
