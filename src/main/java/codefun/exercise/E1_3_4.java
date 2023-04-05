package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个Stack的用例Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如，对于[OJ{H{[OOJ0}程序应该打印true，对于[（]）则打印false。
 */
public class E1_3_4 {
    static boolean isLeft(char c)
    {
        return c == '{' || c == '[' || c == '(';
    }

    static boolean isRight(char c)
    {
        return c == '}' || c == ']' || c == ')';
    }

    static boolean isMatch(char left, char right)
    {
        if(left == '[') return right == ']';
        if(left == '(') return right == ')';
        if(left == '{') return right == '}';
        throw new IllegalArgumentException();
    }

    static boolean test(String input)
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<input.length();++i) {
            var c = input.charAt(i);
            if(!isLeft(c) && !isRight(c))
            {
                throw new IllegalArgumentException("input has invalid chars");
            }
            if(isLeft(c)) {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty())
            {
                return false;
            }
            char leftChar = stack.pop();
            if(!isMatch(leftChar, c))
            {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println(test("[()]{({})}"));
        StdOut.println(test("[()]{({})"));
    }
}
