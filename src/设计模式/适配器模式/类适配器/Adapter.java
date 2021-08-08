package 设计模式.适配器模式.类适配器;

public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        this.specificRequest();
    }
}
