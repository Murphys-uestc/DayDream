import java.util.Scanner;

public class SuShu {
	public static void main(String[] args) {
	Scanner sin = new Scanner(System.in);
	 
	 long n =sin.nextLong(); 

	 //小于3时直接退出
	 if(n < 3){
		 System.out.println("NA");
		 return;
	 }
	 
	 // 寻找 n 最小的因子
	 // 一个数最小的因子(排除 1 和 自身) 肯定是素数
	 long p = -1;
	 for(long i = 2; i * i< n; i++) {
		 if(n % i == 0 ) {
			 p = i;
			 break;
		 }
	 }
	 
	 // 输入数值为素数, 直接退出
	 if(p < 0) {
		 System.out.println("NA");
		 return;
	 }
	 
	 // n 对 q 辗转相除，求幂次
	 long q = 0;
	 while(n % p == 0 && n > 0){
		 n = n / p;
		 q ++;
	 }
	 
	 // n != p ^ x(x > 1) 
	 // n 中包含了 p 之外的因子，不是超级素数，退出
	 if(n != 1) {
		 System.out.println("NA");
		 return;
	 }
	 
	 System.out.println(p + " " + q);
	}
}
