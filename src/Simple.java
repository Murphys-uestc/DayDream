import java.util.Scanner;

public class Simple {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //预先不知道输入数据的组数
        while (in.hasNextInt()) {//注意while处理多个case 判断输入是否为数字
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
