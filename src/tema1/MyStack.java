package tema1;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List<Integer> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(Integer x) {
        stack.add(x);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public int getNElements() {
        return stack.size();
    }

}
