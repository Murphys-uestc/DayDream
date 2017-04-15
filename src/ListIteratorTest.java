/*����Collection���е�iterator()������List�������ṩ��һ��listIterator()�������÷�������һ��ListIterator����ListIterator�ӿڼ̳���Iterator�ӿڣ��ṩ��ר�Ų���List�ķ�����ListIterator�ӿ���Iterator�ӿڵļ̳������������·���:
	1) boolean hasPrevious(): ���ظõ����������ļ����Ƿ�����һ��Ԫ��
	2) Object previous(): ���ظõ���������һ��Ԫ��(��ǰ����)
	3) void add(): ��ָ��λ�ò���һ��Ԫ��*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	public static void main(String[] args) 
    {
        String[] books = {
            "���Java����",
            "������Java EE��ҵӦ��ʵս"
        };
        List bookList = new ArrayList();
        for (int i = 0; i < books.length ; i++ )
        {
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext())
        {
            System.out.println(lit.next());
            lit.add("-------�ָ���-------");
        }
        System.out.println("=======���濪ʼ�������=======");
        while(lit.hasPrevious())
        {
            System.out.println(lit.previous());
        }
    }

}
