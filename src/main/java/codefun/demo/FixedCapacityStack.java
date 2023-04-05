package codefun.demo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * stack
 * @param <T>
 */
public class FixedCapacityStack<T> implements Iterable<T> {
    T[] array;
    int size;

    public FixedCapacityStack(int capacity)
    {
        array = (T[])new Object[capacity];
    }

    public void push(T value)
    {
        if(size == array.length)
        {
            throw new RuntimeException("stack is full");
        }
        array[size++] = value;
    }

    public T pop()
    {
        if(isEmpty())
        {
            throw new RuntimeException("stack is empty");
        }
        return array[--size];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        var stack = new FixedCapacityStack<Integer>(3);
        for (int i =0;i<3;i++)
        {
            stack.push(i);
        }

        StdOut.println("test iterator");
        for (var item: stack) {
            StdOut.println(item);
        }

        while (!stack.isEmpty())
        {
            StdOut.println(stack.pop());
        }
        stack.pop();
    }

    class StackIterator implements Iterator<T>
    {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return array[index++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
