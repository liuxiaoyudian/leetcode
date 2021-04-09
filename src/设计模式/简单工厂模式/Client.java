package 设计模式.简单工厂模式;

public class Client {

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct(1);
    }

}
