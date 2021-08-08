package 设计模式.适配器模式.类适配器;

public class Main {

    public static void main(String[] args) {
        Target myAdapter = new Adapter();
        myAdapter.request();
    }

}
