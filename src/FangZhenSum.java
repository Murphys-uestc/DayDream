import java.util.Scanner;
//nextInt(): �����ո�ֹͣ���������֣�  it only reads the int value, nextInt() places the cursor in the same line after reading the input.

//next(): �����ո�ֹͣ���ַ��� read the input only till the space. It can't read two words separated by space. Also, next() places the cursor in the same line after reading the input.

//nextLine():��������ֹͣ�������ַ�����  reads input including space between the words (that is, it reads till the end of line \n). Once the input is read, nextLine() positions the cursor in the next line
//hasNextInt(): �ж������Ƿ�Ϊ����
public class FangZhenSum {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ԥ��֪�����ݵ�����
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();//�������пո�ֹͣ
                ans += x;
            }
        } 
        System.out.println(ans);
        //ÿ��case ֮��Ҫ�п���
        for(int i=0;i<5;i++){
        	i++;
        	if(i>0){
        		System.out.println();
        	}
        	System.out.println("i="+i+"\n");
        }
        
        
        //����case֮���п���
        for(int i=0;i<5;i++){
        	i++;
        	if(i>0){
        		System.out.println();
        	}
        	System.out.println("i="+i);
        }
	}

}
