import java.util.PriorityQueue;
/*
 *
PriorityQueue���������nullԪ�أ�������Ҫ�Զ���Ԫ�ؽ�������
1) ��Ȼ����:
������Ȼ˳���PriorityQueue�����е�Ԫ�ض��󶼱���ʵ����Comparable�ӿڣ�����Ӧ����ͬһ����Ķ��ʵ����������ܵ���ClassCastException�쳣
2) ��������
����PriorityQueue����ʱ������һ��Comparator���󣬸ö�����Զ����е�����Ԫ�ؽ�������
������Ȼ���򡢶��������ԭ���֮ǰ˵��TreeSet����*/
public class PriorityQueueTest {
	public static void main(String[] args) 
    {
        PriorityQueue pq = new PriorityQueue();
        //�������������pq�м����ĸ�Ԫ��
        pq.offer(6);
        pq.offer(-3);
        pq.offer(9);
        pq.offer(0);

        //���pq���У������ǰ�Ԫ�صļ���˳�����У�
        //���ǰ�Ԫ�صĴ�С˳�����У����[-3, 0, 9, 6]
        System.out.println(pq);
        //���ʶ��е�һ��Ԫ�أ���ʵ���Ƕ�������С��Ԫ�أ�-3
        System.out.println(pq.poll());
    }

}
