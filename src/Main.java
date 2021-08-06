
public class Main {

    public static void main(String[] args) {
        System.out.println(test());
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
