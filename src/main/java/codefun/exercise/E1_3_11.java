package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一段程序EvaluatePostfix，从标准输入中得到一个后序表达式，
 * 求值并打印结果（将上一题的程序中得到的输出用管道传递给这一段程序可以得到和Evaluate相同的行为）。
 */
public class E1_3_11 {
    /**
     * 运算符的抽象
     */
    interface Operator {
        int argCount();
        String func(String[] args);
    }

    /**
     * 一元运算符
     */
    static abstract class UnaryOperator implements Operator {
        @Override
        public int argCount() {
            return 1;
        }
    }

    /**
     * 二元运算符
     */
    static abstract class BinaryOperator implements Operator {
        @Override
        public int argCount() {
            return 2;
        }
    }

    static class Plus extends BinaryOperator {
        @Override
        public String func(String[] args) {
            return Float.toString(Float.parseFloat(args[0]) + Float.parseFloat(args[1]));
        }
    }

    static class Minus extends BinaryOperator {
        @Override
        public String func(String[] args) {
            return Float.toString(Float.parseFloat(args[0]) - Float.parseFloat(args[1]));
        }
    }

    static class Multiply extends BinaryOperator {
        @Override
        public String func(String[] args) {
            return Float.toString(Float.parseFloat(args[0]) * Float.parseFloat(args[1]));
        }
    }

    static class Divide extends BinaryOperator {
        @Override
        public String func(String[] args) {
            return Float.toString(Float.parseFloat(args[0]) / Float.parseFloat(args[1]));
        }
    }

    static class Abs extends UnaryOperator {
        @Override
        public String func(String[] args) {
            return Float.toString(Math.abs(Float.parseFloat(args[0])));
        }
    }

    static Map<String, Operator> maps = new HashMap<String, Operator>();

    static {
        maps.put("+", new Plus());
        maps.put("-", new Minus());
        maps.put("*", new Multiply());
        maps.put("/", new Divide());
        maps.put("abs", new Abs());
    }

    public static float evaluate(String exp) {
        var parts = exp.split(" ");
        var stack = new Stack<String>();
        for (var part: parts) {
            if(isOperator(part)) {
                var oper = maps.get(part);
                var args = new String[oper.argCount()];
                for (int i =0;i<args.length;i++) {
                    args[i] = stack.pop();
                }
                stack.push(oper.func(args));
            } else {
                stack.push(part);
            }
        }
        if(stack.size() == 1)
        {
            return Float.parseFloat(stack.peek());
        }
        throw new RuntimeException("evaluate error");
    }

    private static boolean isOperator(String part) {
        return maps.containsKey(part);
    }

    public static void main(String[] args) {
        StdOut.println(evaluate("1 2 + 5 * 20 - abs"));
    }
}
