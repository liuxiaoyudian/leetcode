package 设计模式.简单工厂模式;

import 设计模式.简单工厂模式.ConcreteProduct1;
import 设计模式.简单工厂模式.ConcreteProduct2;
import 设计模式.简单工厂模式.Product;

public class SimpleFactory {

    public static Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else {
            return new ConcreteProduct2();
        }
    }

}
