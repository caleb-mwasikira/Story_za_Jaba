package DataStructures;

import java.util.ArrayList;

public class Stack {
    int max_size = 10;
    ArrayList<Integer> items;

    public Stack(int size) {
        if (size <= 0) {
            System.out.println("invalid stack size provided... ");
            System.out.printf("setting default stack size to %s items\n", this.max_size);
        } else {
            this.max_size = size;
        }

        this.items = new ArrayList<Integer>();
    }

    public void push(int num) {
        if (items.size() == this.max_size) {
            System.out.println("stack overflow");
        } else {
            items.add(num);
        }
    }

    public int pop() {
        if (items.isEmpty()) {
            System.out.println("stack underflow");
            return 0;
        } else {
            int item = items.getLast();
            items.removeLast();
            return item;
        }
    }

    public void items() {
        System.out.println(items);
    }
}
