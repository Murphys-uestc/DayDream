import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPartition {
static int[] a = new int[1000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()) {
			int n = in.nextInt();
			int count = q(n, n, 0);
			System.out.println(count);
		}
	}
	
	public static int q(int n, int m, int i) {
		if(n < m) {
			return q(n, n, i);
		}
		a[i] = m;
		if(n == 0 || m == 0) {
			//打印下标从0到i
			printPartition(i);
			return 0;
		}
		if(n == 1 || m == 1) {
			if(n == 1) {
				//打印下标从0到i
				printPartition(i);
			}
			else q(n-1, 1, i+1);
			return 1;
		}
		if(n == m) {
			//打印下标从0到i
			printPartition(i);
			return 1 + q(n, n-1, i);
		}
		
		return q(n-m, m, i+1) + q(n, m-1, i);
	}
	
	public static void printPartition(int i) {
		//System.out.print("{");
		/*List< Integer> result=new ArrayList< Integer>();
		for(int j = 0; j <= i; j++) {
			result.add(a[j]);
			if(j == i){
				
				System.out.print(a[j]);
			}
			else{
				System.out.print(a[j] + "+");
			}
		}
		//System.out.println("}");
		boolean flag = false;
		int w=0;
		if(result.size()==1)
			return ;
		for(int k=0;k<result.size()-1;k++){
			if(a[k]==a[k+1])
				w++;
			else
				w=0;
		}
		if(w!=result.size()-1)
			System.out.println(result);
	}*/
	
	}
}