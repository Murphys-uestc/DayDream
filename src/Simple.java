import java.util.Scanner;

public class Simple {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Ԥ�Ȳ�֪���������ݵ�����
        while (in.hasNextInt()) {//ע��while������case �ж������Ƿ�Ϊ����
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
