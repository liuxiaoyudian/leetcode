package 设计模式.适配器模式.对象适配器;

public class Main {

    public static void main(String[] args) {
        Target myAdapter = new Adapter(new Adaptee());
        myAdapter.request();
    }

}
