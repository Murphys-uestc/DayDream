import java.util.Scanner;

public class reverseAdd {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String cinStr=cin.nextLine();
        String [] cinArray=cinStr.split(",");
        int a1 = Integer.valueOf(cinArray[0]);
        int b1 = Integer.valueOf(cinArray[1]);
        //不满足边界条件
        if(a1<1||b1<1||a1>70000||b1>70000){
        	System.out.println(-1);
        	return ;
        }
        int a2=Integer.parseInt(new StringBuffer(String.valueOf(a1)).reverse().toString());
        int b2=Integer.parseInt(new StringBuffer(String.valueOf(b1)).reverse().toString());
        System.out.println(a2+b2);
	}
}
