package codefun.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个Queue的用例，接受一个命令行参数k并打印出标准输入中的倒数第k个字符串（假设标准输人中至少有k个字符串）
 */
public class E1_3_15 {
    public static void main(String[] args) {
        StdOut.print(read(Integer.parseInt(args[0])));
    }

    private static String read(int k1) {
        var queue = new Queue<String>();
        while(true) {
            String line = StdIn.readLine();
            if(line == null) {
                break;
            }
            queue.enqueue(line);
            if(queue.size() > k1) {
                queue.dequeue();
            }
        }
        return queue.dequeue();
    }
}
