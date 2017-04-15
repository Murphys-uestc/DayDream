public class LinkedListNode {
	//内部类构造
	public static class Node<E>{
		public E item;
		public Node<E> next;
		//Node<E>构造函数
		public Node(E element){
			this.item=element;
			this.next=null;
		}
		
	}
	//头节点和尾节点初始化,链表为空
	public static Node headNode=null;
	public static Node tailNode=null;
	//追加节点
	public  <E> void add(Node<E> node) {
		if(headNode==null){
			//头节点赋值
			headNode=node;
			//尾节点也指向它
			tailNode=headNode;
		}
		tailNode.next=node;
		tailNode=tailNode.next;
	}
	//顺序遍历链表
	public void PreListPrint(Node headNode){
		Node node=headNode;
		
		while(node!=null){
			System.out.print(node.item+"->");
			node=node.next;
		}
	}
	//顺序遍历链表（尾递归方式）
	public <E> void PostListPrint(Node<E> head){
		if(head!=null){
			System.out.print(head.item+"->");
			PostListPrint(head.next);
		}
	}
	//倒序遍历链表（直接递归方式）
	public <E> void PostPreListPrint(Node<E> head){
		if(head!=null){
			PostPreListPrint(head.next);
			System.out.print(head.item+"->");
		}
	}
	//遍历翻转链表
	public <E> Node<E> PreReverseList(Node<E> headNode){
		if(headNode==null){
			return headNode;
		}
		Node curNode=headNode.next;//当前节点
		Node preNode=headNode;//上一节点
		Node tempNode=null;//临时节点
		while(curNode!=null){
			//复制下一个节点给临时节点
			tempNode = curNode.next;
			//将当前节点指向前驱节点
			curNode.next=preNode;
			//将前驱节点和当前节点都下移，为下次循环准备
			preNode = curNode;
			curNode = tempNode;
		}
		//头节点赋值为null
		headNode.next=null;
		//返回新的头节点
		return preNode;
	}
	//反转链表（递归方式）
	public <E> Node<E> RecurReverseList(Node<E> headNode){
		//递归结束条件
		if(headNode==null||headNode.next==null){
			return headNode;
		}
		Node reheadNode=RecurReverseList(headNode.next);
		headNode.next.next=headNode;
		//切断原链表的顺序连接
		headNode.next=null;
		//返回 反转后新链表的头节点
		return reheadNode;
		
	}
	public static void main(String[] args){
		//通过实例化外部类来访问动态内部类
		//Node<Integer> nodeListNode=linkedListNode.new Node<Integer>(null);
		//或者内部类定义为static后,直接访问
		//Node<Integer> nodeListNode=new Node<Integer>(0);
		LinkedListNode linkedListNode=new LinkedListNode();
		//创建新节点，并让head指向它
		for(int i=0;i<10;i++){
			linkedListNode.add(new Node<Integer>(i));
		}
		Node head=headNode;
		System.out.println("翻转前");
		linkedListNode.PreListPrint(head);
		head=linkedListNode.RecurReverseList(head);
		System.out.println();
		System.out.println("翻转后");
		linkedListNode.PreListPrint(head);
	}
	
}
