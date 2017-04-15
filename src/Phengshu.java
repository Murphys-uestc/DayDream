import java.util.Scanner;

public class Phengshu {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        Integer in=cin.nextInt();
        if(in<=10){
        	System.out.println("NO");
        }
        String cinStr = String.valueOf(in);
        String [] cinArray=cinStr.split("");
        Integer [] a= new Integer[cinArray.length];
        Integer b = 1;//数字总值
        for(int i=0;i<cinArray.length;i++){
        	a[i]=Integer.valueOf(cinArray[i]);
        	b=b*a[i];
        }
        Integer cq=a[0];//第一位
        for(int j=1;j<=a.length-1;j++){
        	/*if(j==a.length-1&&cq!=a[a.length-1]){
        		System.out.println("NO");
        		return ;
        	}*/
        	Integer ch = a[a.length-1];//最后一位
        	cq=cq*a[j];
        	if(cq*cq<=b){
        		for(int k=j+1;k<=a.length-1;k++){
        			ch=ch*a[k];
        		}
        		if(cq==ch){
        			System.out.println("YES");
        			return ;
        		}
        	}
        }
        if(cq*cq!=b)
        	System.out.println("NO");
	        
	    }
	}

