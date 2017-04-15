/* "=="操作符的作用

1、用于基本数据类型的比较

2、判断引用是否指向堆内存的同一块地址。
HashCode不是内存地址，是根据排列算出来的一个值，相当于对象的身份证，但绝不是内存地址
*/

public class StringEqualsTest {
	public static void main(String[] args){
		String s1 = new String("java");
		String s2 = new String("java");
		//例子一：对象不同，内容相同，"=="返回false，equals返回true
		System.out.println(s1==s2);           //false 不同对象地址不同
		System.out.println(s1.equals(s2));    //true
		//例子二：同一对象，"=="和equals结果相同
		String s3 = s1;
		System.out.println(s3==s1);           //true
		System.out.println(s1.equals(s3));    //true
		//如果值不相同，对象就不相同，所以"==" 和equals结果一样
		String s4 = "java";
		String s5 = "java";
		System.out.println(s4==s5);            //true
		System.out.println(s4.equals(s5));    //true
	}
	

}
