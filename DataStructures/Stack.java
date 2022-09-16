package DataStructures;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    private List<Object> list = new LinkedList<>();

    public void push(Object x) throws StackOverflowError {
        list.add(x);
    }

    public Object pop() {
        if (list.size() == 0)
            return null;
        Object x = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return x;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public Object peek() {
        return list.remove(list.size() - 1);
    }

    public void removeAll() {
        list.clear();
    }

    public boolean isFull() {
        return false;
    }

}
