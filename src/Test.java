public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("leetcode.ListNode");
        System.out.println(aClass.getClassLoader());
        System.out.println(aClass.getClassLoader().getParent());
        System.out.println(aClass.getClassLoader().getParent().getParent());
    }
}
