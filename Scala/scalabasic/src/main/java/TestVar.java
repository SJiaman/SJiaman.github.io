import java.util.ArrayList;

/**
 * @Author Jiaman
 * @Date 2021/5/6 9:40
 * @Desc
 */

public class TestVar {
    // 全局变量
    String name1 = "feishou";
    public static void main(String[] args) {
        // 内部变量
        String name = "zhangq";
        int age = 19;
        System.out.println("name=" + name + "age=" +age);

        // 变量修改
        name = "xyz";
        System.out.println(name);


    }
}
