
import java.util.Scanner;


public class Input {
	
	    public static void main(String[] args) {
	        Scanner sin = new Scanner(System.in);
	         Double powerNumber =sin.nextDouble();
	         if(powerNumber<2||powerNumber>Math.pow(10, 18)){
	        	 System.out.println("No2");
	        	 return;
	         }
	   		 long t =Math.round((Math.floor(Math.sqrt(powerNumber))));
	   		 long n;
	   		 for(n=2;n<=t;n++){
	   			if(IsPower(Math.round(powerNumber),n)){
	   				if(isPrime(n)){
	   					int q=(int)log(powerNumber, n);
	   					System.out.println(n+" "+q);
	   					break;
	   				}
	   			}
	   		 }
	   		 System.out.println("n ="+n);
	   		 if(n>t)
	   			System.out.println("No");
	   		 
	   	     /*for (n = 3; n<t; n++) {     //3~100��������
	   	          i=2;
	   	          while (i<n) {
	   	             if (n%i==0)  break;  //��������˵��n����������������ǰѭ��
	   	             i++;
	   	          }

	   	         
	   	      if (i==n) {     //���i==n��˵��n���ܱ�2~n-1������������
	   	             k++;             //ͳ��������ĸ���
	   	             list.add(i);
	   	             System.out.print(i+ "\t ");
	   	             
	   	             if (k %6==0)    //ÿ���5������
	   	              System.out.println();
	   	         }
	   	     }
	        }*/
	    }
	    //�ж�һ��������һ������n�η�
	    public static Boolean IsPower(long number, long powerNumber)
        {
            boolean result = false;
            if (number <= 0 || number % powerNumber != 0) return false;
 
            if (number / powerNumber > 1)
            {
                result = IsPower(number / powerNumber, powerNumber);
            }
            else
            {
                result = number % powerNumber == 0;
            }
            return result;
        }
	    //�ж�һ�����Ƿ�������/����
	    public static boolean isPrime(long m)
	    {
	    	/*for(int i=2;i<=m/2;i++){
	            if(m%i == 0)
	                 return false; 
	        }
	        return true;*/
		    if(m < 2) return false;
	
		    if(m == 2) return true;
	
		    if(m%2==0) return false;
	
		    for(int i = 3; i*i <= m; i += 2)
	
		    if(m%i == 0) return false;
	
		    return true;
	    }
	    public static double log(double value, double base){

	      return Math.log(value) / Math.log(base);

	    }
}
