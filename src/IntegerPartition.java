import java.util.Scanner;

public class IntegerPartition {
	public static int partition(int sum, int largestNumber){
	    if (largestNumber==0)
	        return 0;
	    if (sum==0)
	        return 1;
	    if (sum<0)
	        return 0;

	    return partition(sum,largestNumber-1)
	    + partition(sum-largestNumber,largestNumber);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int sum=in.nextInt();
		int largestNumber = sum-1;
		System.out.println(partition(sum,largestNumber));
		
	}

	
}
