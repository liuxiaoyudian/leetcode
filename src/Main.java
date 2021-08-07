import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        System.out.println(stack.peek());
        stack.push(1);
        new EmptyStackException();
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        System.out.println(test());
    }

    public static int test() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
        }
    }

}
