import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class Test {

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true); // 设置为允许访问私有内容
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        Field id = Student.class.getDeclaredField("id");
        Field name = Student.class.getDeclaredField("name");
        long idOffset = unsafe.objectFieldOffset(id);
        long nameOffset = unsafe.objectFieldOffset(name);
        Student stu = new Student();
        unsafe.compareAndSwapInt(stu, idOffset, 0, 1);
        unsafe.compareAndSwapObject(stu, nameOffset, null, "张三");
        System.out.println(stu);
    }
}

class Student {
    int id;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}