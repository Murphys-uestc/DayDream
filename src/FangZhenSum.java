import java.util.Scanner;
//nextInt(): 读到空格停止（仅仅数字）  it only reads the int value, nextInt() places the cursor in the same line after reading the input.

//next(): 读到空格停止（字符） read the input only till the space. It can't read two words separated by space. Also, next() places the cursor in the same line after reading the input.

//nextLine():读到换行停止（任意字符串）  reads input including space between the words (that is, it reads till the end of line \n). Once the input is read, nextLine() positions the cursor in the next line
//hasNextInt(): 判断输入是否为数字
public class FangZhenSum {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //预先知道数据的组数
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();//读到该行空格停止
                ans += x;
            }
        } 
        System.out.println(ans);
        //每个case 之后要有空行
        for(int i=0;i<5;i++){
        	i++;
        	if(i>0){
        		System.out.println();
        	}
        	System.out.println("i="+i+"\n");
        }
        
        
        //两个case之间有空行
        for(int i=0;i<5;i++){
        	i++;
        	if(i>0){
        		System.out.println();
        	}
        	System.out.println("i="+i);
        }
	}

}
