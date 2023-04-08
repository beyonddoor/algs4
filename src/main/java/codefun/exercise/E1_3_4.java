package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * 编写一个Stack的用例Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如，对于[OJ{H{[OOJ0}程序应该打印true，对于[（]）则打印false。
 */
public class E1_3_4 {
    static Map<String, String> leftOps = new HashMap<>();
    static Map<String, String> rightOps = new HashMap<>();

    static {
        leftOps.put("{", "}");
        leftOps.put("[", "]");
        leftOps.put("(", ")");
        leftOps.forEach((key, value) -> rightOps.put(value, key));
    }

    public static boolean isLeft(String c)
    {
        return leftOps.containsKey(c);
    }

    public static boolean isRight(String c)
    {
        return rightOps.containsKey(c);
    }

    static boolean test(String input)
    {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<input.length();++i) {
            var c = input.substring(i, i+1);
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
            String leftChar = stack.pop();
            if(!leftOps.get(leftChar).equals(c))
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
