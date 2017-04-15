import java.util.ArrayDeque;
/*
1. java�ṩ��List����һ��"���Ա�ӿ�"��ArrayList(������������Ա�)��LinkedList(�����������Ա�)�����Ա�����ֵ���ʵ��
2. Queue�����˶��У�Deque������˫�˶���(�ȿ�����Ϊ����ʹ�á�Ҳ������Ϊջʹ��)
3. ��Ϊ������һ�������ڴ����������е�����Ԫ�أ������������������ʱ������á����Ե��ڲ���������Ϊ�ײ�ʵ�ֵļ������������ʱ������á�
4. �ڲ���������Ϊ�ײ�ʵ�ֵļ�����ִ�в��롢ɾ������ʱ�кܺõ�����
5. ���е�������ʱ����������Ϊ�ײ�ʵ�ֵļ��ϱ���������Ϊ�ײ�ʵ�ֵļ������ܺ�*/
public class ArrayDequeTest {
	public static void main(String[] args) 
    {
        ArrayDeque stack = new ArrayDeque();
        //���ν�����Ԫ��push��"ջ"
        stack.push("���Java����");
        stack.push("������Java EE��ҵӦ��ʵս");
        stack.push("���Android����");

        //�����[���Java����, ������Java EE��ҵӦ��ʵս , ���Android����]
        System.out.println(stack);

        //���ʵ�һ��Ԫ�أ�����������pop��"ջ"����������Android����
        System.out.println(stack.peek());

        //��Ȼ�����[���Java����, ������Java EE��ҵӦ��ʵս , ���Android����]
        System.out.println(stack);

        //pop����һ��Ԫ�أ���������Android����
        System.out.println(stack.pop());

        //�����[���Java����, ������Java EE��ҵӦ��ʵս]
        System.out.println(stack);
    }

}
