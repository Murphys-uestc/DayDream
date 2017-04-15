public class LinkedListNode {
	//�ڲ��๹��
	public static class Node<E>{
		public E item;
		public Node<E> next;
		//Node<E>���캯��
		public Node(E element){
			this.item=element;
			this.next=null;
		}
		
	}
	//ͷ�ڵ��β�ڵ��ʼ��,����Ϊ��
	public static Node headNode=null;
	public static Node tailNode=null;
	//׷�ӽڵ�
	public  <E> void add(Node<E> node) {
		if(headNode==null){
			//ͷ�ڵ㸳ֵ
			headNode=node;
			//β�ڵ�Ҳָ����
			tailNode=headNode;
		}
		tailNode.next=node;
		tailNode=tailNode.next;
	}
	//˳���������
	public void PreListPrint(Node headNode){
		Node node=headNode;
		
		while(node!=null){
			System.out.print(node.item+"->");
			node=node.next;
		}
	}
	//˳���������β�ݹ鷽ʽ��
	public <E> void PostListPrint(Node<E> head){
		if(head!=null){
			System.out.print(head.item+"->");
			PostListPrint(head.next);
		}
	}
	//�����������ֱ�ӵݹ鷽ʽ��
	public <E> void PostPreListPrint(Node<E> head){
		if(head!=null){
			PostPreListPrint(head.next);
			System.out.print(head.item+"->");
		}
	}
	//������ת����
	public <E> Node<E> PreReverseList(Node<E> headNode){
		if(headNode==null){
			return headNode;
		}
		Node curNode=headNode.next;//��ǰ�ڵ�
		Node preNode=headNode;//��һ�ڵ�
		Node tempNode=null;//��ʱ�ڵ�
		while(curNode!=null){
			//������һ���ڵ����ʱ�ڵ�
			tempNode = curNode.next;
			//����ǰ�ڵ�ָ��ǰ���ڵ�
			curNode.next=preNode;
			//��ǰ���ڵ�͵�ǰ�ڵ㶼���ƣ�Ϊ�´�ѭ��׼��
			preNode = curNode;
			curNode = tempNode;
		}
		//ͷ�ڵ㸳ֵΪnull
		headNode.next=null;
		//�����µ�ͷ�ڵ�
		return preNode;
	}
	//��ת�����ݹ鷽ʽ��
	public <E> Node<E> RecurReverseList(Node<E> headNode){
		//�ݹ��������
		if(headNode==null||headNode.next==null){
			return headNode;
		}
		Node reheadNode=RecurReverseList(headNode.next);
		headNode.next.next=headNode;
		//�ж�ԭ�����˳������
		headNode.next=null;
		//���� ��ת���������ͷ�ڵ�
		return reheadNode;
		
	}
	public static void main(String[] args){
		//ͨ��ʵ�����ⲿ�������ʶ�̬�ڲ���
		//Node<Integer> nodeListNode=linkedListNode.new Node<Integer>(null);
		//�����ڲ��ඨ��Ϊstatic��,ֱ�ӷ���
		//Node<Integer> nodeListNode=new Node<Integer>(0);
		LinkedListNode linkedListNode=new LinkedListNode();
		//�����½ڵ㣬����headָ����
		for(int i=0;i<10;i++){
			linkedListNode.add(new Node<Integer>(i));
		}
		Node head=headNode;
		System.out.println("��תǰ");
		linkedListNode.PreListPrint(head);
		head=linkedListNode.RecurReverseList(head);
		System.out.println();
		System.out.println("��ת��");
		linkedListNode.PreListPrint(head);
	}
	
}
