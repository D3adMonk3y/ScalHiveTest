package Test3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl<E> implements TSStack<E> {

    // structure that store elements of stack
    private List<E> elements = new ArrayList<>();

    //add element to stack and returned it
    @Override
    public E push(E item) {
        elements.add(item);
        return item;
    }

    // return the next element in stack and remove it from the stack
    @Override
    public synchronized E pop() {
        E       obj;
        int     len = elements.size();

        obj = peek();
        elements.remove(len - 1);

        return obj;
    }

    // return next element that gon be popped or throw EmptyStackException if stack is empty
    @Override
    public synchronized E peek() {
        int     len = elements.size();

        if (len == 0)
            throw new EmptyStackException();
        return elements.get(len - 1);
    }

    // return false if stack is empty and true if not
    @Override
    public boolean empty() {
        return elements.size() == 0;
    }

    // search for specific element in stack and return its index or a '-1' if there no such element
    @Override
    public synchronized int search(Object o) {
        int i = elements.lastIndexOf(o);

        if (i >= 0) {
            return elements.size() - i;
        }
        return -1;
    }
}

