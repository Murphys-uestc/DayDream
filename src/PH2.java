
import java.util.ArrayList;
import java.util.Scanner;


public class PH2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            
            int right = 1;
            if(a < 10){
            	System.out.println("NO");
            	continue;
            }
            
            ArrayList<Integer> alist = new  ArrayList<Integer>();
            int zeroCount = 0;
            while( a > 0 ) {
            	alist.add(a % 10);
            	if(a % 10 == 0){
            		zeroCount ++;
            		if(zeroCount > 1){
            			System.out.println("YES"); 
            			break;
            		}
            	}
            	right *= alist.get(alist.size() - 1);
            	a /= 10;
            }
            
            if(zeroCount > 1){ break; }
            
            int left = 1;
            boolean flag = true;
            for(int i = 0;  i < alist.size(); i++) {
            	right = right / alist.get(i);
            	left *= alist.get(i);
            	//System.out.println(right +"," + left);
            	if(right == left) {
            		System.out.println("YES");  
            		flag = false;
            		break;
            	}
			}
            
            if(flag){
            	System.out.println("NO");    
            }
     
        }
    }
}
