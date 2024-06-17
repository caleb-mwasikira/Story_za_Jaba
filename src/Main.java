import java.util.Random;
import DataStructures.Stack;

public class Main {
    public static int[] genRandomArray(int size) {
        if(size <= 0) {
            System.out.printf("invalid array size %s provided\n", size);
            System.exit(1);
        }

        int[] numbers = new int[size];
        for(int i = 0; i < 10; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(100);
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = genRandomArray(10);

        Stack stack = new Stack(numbers.length);
        for (int number : numbers) {
            stack.push(number);
        }
        stack.items();

        int num_items_to_pop = (int) (Math.random() * 10);
        System.out.printf("popping %s items from stack\n\n", num_items_to_pop);
        for(int i=0; i < num_items_to_pop; i++) {
            System.out.printf("popping item %s from stack\n", stack.pop());
            stack.items();
            System.out.println();
        }
    }
}


