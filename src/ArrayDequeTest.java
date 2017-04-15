import java.util.ArrayDeque;
/*
1. java提供的List就是一个"线性表接口"，ArrayList(基于数组的线性表)、LinkedList(基于链的线性表)是线性表的两种典型实现
2. Queue代表了队列，Deque代表了双端队列(既可以作为队列使用、也可以作为栈使用)
3. 因为数组以一块连续内存来保存所有的数组元素，所以数组在随机访问时性能最好。所以的内部以数组作为底层实现的集合在随机访问时性能最好。
4. 内部以链表作为底层实现的集合在执行插入、删除操作时有很好的性能
5. 进行迭代操作时，以链表作为底层实现的集合比以数组作为底层实现的集合性能好*/
public class ArrayDequeTest {
	public static void main(String[] args) 
    {
        ArrayDeque stack = new ArrayDeque();
        //依次将三个元素push入"栈"
        stack.push("疯狂Java讲义");
        stack.push("轻量级Java EE企业应用实战");
        stack.push("疯狂Android讲义");

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
        System.out.println(stack.peek());

        //依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //pop出第一个元素，输出：疯狂Android讲义
        System.out.println(stack.pop());

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
        System.out.println(stack);
    }

}
