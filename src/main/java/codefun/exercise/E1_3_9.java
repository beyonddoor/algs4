package codefun.exercise;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 编写一段程序，从标准输人得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。例如，给定输人：
 */
public class E1_3_9 {
    public static final String LEFT_BRACE = "(";
    public static final String RIGHT_BRACE = ")";
    static HashMap<String, Integer> operatorsMap= new HashMap<>();

    static {
        operatorsMap.put("+", 1);
        operatorsMap.put("-", 1);
        operatorsMap.put("*", 2);
        operatorsMap.put("/", 2);
        operatorsMap.put("^", 3);
    }

    static boolean isOperator(String s) {
        return operatorsMap.containsKey(s);
    }

    /**
     * 遍历表达式中的每一个字符，如果是操作数或右括号，则直接输出；
     * 如果是操作符，则将其压入栈中；如果是左括号，则直接压入栈中；
     * 当遇到右括号时，弹出栈顶的操作符，并将当前字符与弹出的操作符和前一个字符组合成一个新的表达式输出，直到弹出一个左括号为止。
     *  * TODO 未完成
     * @param tokens
     * @return
     */
    public static List<String> completeExpression(String[] tokens) {
        Stack<String> stack = new Stack<>();
        var outTokens = new ArrayList<String>();
        for(var token:tokens) {
            if("(".equals(token)) {
                stack.push(token);
            } else if(")".equals(token)) {

            } else if(!isOperator(token)) {

            }
        }
        return outTokens;
    }

    public static void main(String[] args) {
        String infix = "a+b*c-d/e+f*g-h";
        var charArray = infix.toCharArray();
        var strArray = new String[charArray.length];
        for(int i=0;i<charArray.length;i++) {
            strArray[i] = Character.toString(charArray[i]);
        }
        var result = completeExpression(strArray);
        System.out.println(String.join("", result));
    }
}
