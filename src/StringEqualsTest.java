/* "=="������������

1�����ڻ����������͵ıȽ�

2���ж������Ƿ�ָ����ڴ��ͬһ���ַ��
HashCode�����ڴ��ַ���Ǹ��������������һ��ֵ���൱�ڶ�������֤�����������ڴ��ַ
*/

public class StringEqualsTest {
	public static void main(String[] args){
		String s1 = new String("java");
		String s2 = new String("java");
		//����һ������ͬ��������ͬ��"=="����false��equals����true
		System.out.println(s1==s2);           //false ��ͬ�����ַ��ͬ
		System.out.println(s1.equals(s2));    //true
		//���Ӷ���ͬһ����"=="��equals�����ͬ
		String s3 = s1;
		System.out.println(s3==s1);           //true
		System.out.println(s1.equals(s3));    //true
		//���ֵ����ͬ������Ͳ���ͬ������"==" ��equals���һ��
		String s4 = "java";
		String s5 = "java";
		System.out.println(s4==s5);            //true
		System.out.println(s4.equals(s5));    //true
	}
	

}
