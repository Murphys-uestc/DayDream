import java.util.Scanner;
public class DiuShaiZi {
	public static void main(String[] args) {
	Scanner cin=new Scanner(System.in);
	while (cin.hasNextLine()) {
		int sz[]={1,2,3,4,5,6};
		String cinStr=cin.nextLine();
		char[] cinNums=cinStr.toCharArray();
		for (int i = 0; i < cinNums.length; i++) {
			switch (cinNums[i]) {
			case 'L':
				int aL1=sz[0];
				int aL2=sz[1];
				int aL3=sz[4];
				int aL4=sz[5];
				sz[0]=aL3;
				sz[1]=aL4;
				sz[4]=aL2;
				sz[5]=aL1;
				break;
			case 'R':
				int aR0=sz[0];
				int aR1=sz[1];
				int aR4=sz[4];
				int aR5=sz[5];
				sz[0]=aR5;
				sz[1]=aR4;
				sz[4]=aR0;
				sz[5]=aR1;
				break;
			case 'F':
				int aF2=sz[2];
				int aF3=sz[3];
				int aF4=sz[4];
				int aF5=sz[5];
				sz[2]=aF4;
				sz[3]=aF5;
				sz[4]=aF3;
				sz[5]=aF2;
				break;
			case 'B':
				int aB2=sz[2];
				int aB3=sz[3];
				int aB4=sz[4];
				int aB5=sz[5];
				sz[2]=aB5;
				sz[3]=aB4;
				sz[4]=aB2;
				sz[5]=aB3;
				break;
			case 'A':
				int aA0=sz[0];
				int aA1=sz[1];
				int aA2=sz[2];
				int aA3=sz[3];
				sz[0]=aA3;
				sz[1]=aA2;
				sz[2]=aA0;
				sz[3]=aA1;
				break;
			case 'C':
				int aC0=sz[0];
				int aC1=sz[1];
				int aC2=sz[2];
				int aC3=sz[3];
				sz[0]=aC2;
				sz[1]=aC3;
				sz[2]=aC1;
				sz[3]=aC0;
				break;
			default:
				break;
			}
		}
		StringBuilder sz2=new StringBuilder();
		for (int i = 0; i < sz.length; i++) {
			sz2.append(sz[i]);
		}
		System.out.println(sz2.toString());
	}

}
}
