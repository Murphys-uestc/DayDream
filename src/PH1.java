import java.util.ArrayList;
import java.util.Scanner;

public class PH1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();		
		sc.close();
		ArrayList<Integer> alist = new ArrayList<Integer>(); 
		
		//辗转相除求整数的每位数字
		while(a > 0) {
			alist.add(a % 10);
			a /= 10;
		}
       
		int lnum = alist.get(0);
		int rnum = alist.get(alist.size() - 1);
		
		int lp = 0, rp = alist.size() - 1;
		while(lp < rp) {
			if(lnum < rnum){
				lnum *= alist.get(++lp);
			} else {
				rnum *= alist.get(--rp);
			}
			
			if(lp == rp - 1){
				if( lnum == rnum) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}	

}
