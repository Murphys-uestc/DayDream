import java.util.Scanner;
import java.util.StringTokenizer;
/*Arrays.toString(arr)

for(int n: arr) 
   System.out.println(n+", ");

for (int i = 0; i < arr.length; i++) {
   System.out.print(arr[i] + ", ");
}

System.out.println(Arrays.asList(arr));

Arrays.asList(arr).stream().forEach(s -> System.out.println(s));//java8
*/
public class FourEqualArray {
	public static void main(String [] args){
		Scanner cin = new Scanner(System.in);
		String cinStr=cin.nextLine();
		/*//第一种分隔字符串的方法
		String [] cinArray = cinStr.split(",");*/
		//第二种分隔字符串的方法
		StringTokenizer token=new StringTokenizer(cinStr,",");
		int [] a = new int[token.countTokens()];
		int k=0;
		int sum=0;//计算数组的总和
		while (token.hasMoreTokens()) {
	         a[k]=Integer.valueOf(token.nextToken());
	         sum+=a[k++];
	    }
		System.out.println(sum);
		int lnum = a[0];
		int rnum = a[a.length- 1];
		int fourEqual=0;
		int lp = 0, rp = a.length - 1;
		int fourAvg=sum/4;
		boolean flag=false;
		System.out.println(lnum);
		System.out.println(rnum);
		System.out.println(fourAvg);
		while(lp < rp&&lnum<=fourAvg&&rnum<=fourAvg) {
			if(lnum < rnum&&!flag){
				lnum += a[++lp];
			} else if (lnum > rnum&&!flag) {
				rnum += a[--rp];
			}else if(lnum == rnum&&!flag){
				//int m=a.length-3-(lp+1+a.length-rp);
				int m=rp-lp-4;
				if(m>=2&&m*lnum<=2*lnum){
					System.out.println(lnum);
					flag=true;
					fourEqual=lnum;
					lp=lp+2;
					rp=rp-2;
					lnum = a[lp];
					rnum = a[rp];
					System.out.println(lnum);
					System.out.println(rnum);
					System.out.println("lp="+(lp+1));//空出来
					System.out.println("rp="+(rp-1));//空出来
					
				}
				else {
					lnum += a[++lp];
					System.out.println("第一部分和第四部分相等后继续");
				}
				
			}
			if(flag&&lnum<=fourEqual&&rnum<=fourEqual){
				if( lnum < rnum) {
					lnum += a[++lp];
					System.out.println(lnum);
					
				}
				else if(lnum > rnum){
					rnum += a[--rp];
					System.out.println(rnum);
				}else {
					System.out.println("第二部分和第三部分相等后继续");
					System.out.println("lp="+lp);
					System.out.println("rp="+rp);
					if(lp == rp - 2&&lnum==fourEqual){
						   System.out.println("fourEqual="+fourEqual);
							System.out.println("true");
							return ;
					}
					else {
						lnum += a[++lp];
					}
				}
				
			}
		}
		
		System.out.println("false");
	}
		
	//2,5,1,1,1,1,4,1,7,3,7

}
