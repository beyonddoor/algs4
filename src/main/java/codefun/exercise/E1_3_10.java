package codefun.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式转为后序表达式。
 * (a+b)*c
 * a b + c *
 * a+(b*c)
 * a b c * +
 */
public class E1_3_10 {
    public static final String LEFT_BRACE = "(";
    public static final String RIGHT_BRACE = ")";
    static HashMap<String, Integer> operatorsMap= new HashMap<>() {

    };

    static {
        operatorsMap.put("+", 1);
        operatorsMap.put("-", 1);
        operatorsMap.put("*", 2);
        operatorsMap.put("/", 2);
        operatorsMap.put("^", 3);
    }

    /**
     * 这个函数接受一个中缀表达式的字符串作为输入，输出对应的后缀表达式字符串。
     * 算法的思路是从左到右扫描中缀表达式，用一个栈来存储运算符，遇到操作数就直接输出到后缀表达式列表，遇到左括号就入栈，
     * 遇到右括号就一直出栈并输出，直到遇到左括号。
     * 对于运算符，如果栈顶元素的优先级大于或等于当前运算符，就不断出栈并输出，
     * 直到栈为空或栈顶元素的优先级小于当前运算符，然后把当前运算符入栈。
     * 最后把栈里的剩余运算符全部出栈并输出到后缀表达式列表中，再把列表用空格连接成字符串即可。
     * @param expression
     * @return
     */
    public static String infixToPostfix(String expression) {
        var inExpressions = expression.split(" ");
        var postExpressions = infixToPostfix(inExpressions);
        return String.join(" ", postExpressions);
    }

    public static List<String> infixToPostfix(String[] tokens) {
        var outTokens = new ArrayList<String>();
        var operatorStack = new Stack<String>();

        for (var token : tokens) {
            if(token.equals(LEFT_BRACE)) {
                operatorStack.push(token);
            } else if(token.equals(RIGHT_BRACE)) {
                var operator = operatorStack.pop();
                while (!operator.equals(LEFT_BRACE) && !operatorStack.isEmpty()) {
                    outTokens.add(operator);
                    operator = operatorStack.pop();
                }
            } else if(!isOperator(token)) {
                outTokens.add(token);
            } else {
                while(!operatorStack.isEmpty()
                        && !operatorStack.peek().equals(LEFT_BRACE)
                        && operatorsMap.get(operatorStack.peek())>=operatorsMap.get(token)) {
                    outTokens.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while(!operatorStack.isEmpty()) {
            outTokens.add(operatorStack.pop());
        }

        return outTokens;
    }

    private static boolean isOperator(String expr) {
        return operatorsMap.containsKey(expr);
    }

    public static void main(String[] args) {
        StdOut.println(infixToPostfix("( a + b ) * c").equals("a b + c *"));
    }
}
