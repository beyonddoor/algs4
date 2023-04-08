package codefun.utils;

import java.util.NoSuchElementException;

/**
 * 单链表的方法
 * @author admin
 * @param <T>
 */
public class OpenLinkList<T> {
    /**
     * expose its inner data struct
     */
    public Node<T> head;

    /**
     * create link list by values
     * @param values
     * @param <T>
     * @return the first node
     */
    public static <T> OpenLinkList<T> createNodes(T[] values) {
        Node<T> prevOfFirst = new Node<T>();
        Node<T> prev = prevOfFirst;

        for(var value:values) {
            var node = new Node<T>();
            node.value = value;
            prev.next = node;
            prev = node;
        }

        OpenLinkList<T> result = new OpenLinkList<T>();
        result.head = prevOfFirst.next;
        return result;
    }

    /**
     * @param first
     * @param separator
     * @param <T>
     * @return
     */
    public static <T> String toString(Node<T> first, String separator) {
        if(first == null) {
            return null;
        }
        var sb = new StringBuilder();
        sb.append(first.value);
        var current = first.next;
        while(current != null) {
            sb.append(separator);
            sb.append(current.value);
            current = current.next;
        }
        return sb.toString();
    }

    public String toString(String separator) {
        return toString(head, separator);
    }

    /**
     * 删除链表的尾结点，其中链表的首结点为first。
     * @return
     */
    public T deleteTail() {
        if(head == null) {
            throw new RuntimeException("list null");
        }

        T result;
        // only head
        if(head.next == null) {
            result = head.value;
            head = null;
            return result;
        }

        Node<T> prevOfLastNode = head;
        while(prevOfLastNode.next.next != null) {
            prevOfLastNode = prevOfLastNode.next;
        }
        result = prevOfLastNode.next.value;
        prevOfLastNode.next = null;
        return result;
    }

    /**
     * n从0开始，0是第一个node
     * @param n
     * @return
     */
    public T deleteNthNode(int n) {
        if(n<0) {
            throw new IllegalArgumentException("n cannot be negative");
        }

        if(head == null) {
            throw new IllegalArgumentException("first node null");
        }

        T result;
        // delete head
        if(n == 0) {
            result = head.value;
            head = head.next;
            return result;
        }

        var prevNode = head;
        // find the n-1 th node
        for(int i=0; i<n-1; i++) {
            prevNode = prevNode.next;
            if(prevNode == null) {
                throw new NoSuchElementException();
            }
        }

        if(prevNode.next == null) {
            throw new NoSuchElementException();
        }

        var value = prevNode.next.value;
        prevNode.next = prevNode.next.next;
        return value;
    }
}
