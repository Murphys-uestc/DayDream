import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/**
 * BinaryTree������������

 */
public class BinaryTree {
	//����һ��Node��
	public class Node {
	    /**
	     * �ڵ�����ݣ�����������һ��int��ʾ
	     */
	    public int data;
	    /**
	     * �ڵ������
	     */
	    public Node left;
	    /**
	     * �ڵ���Һ���
	     */
	    public Node right;
	    /**
	     * ���캯����data��ʼ���ڵ��ֵ
	     * @param data
	     */
	    public Node(int data){
	        this.data=data;
	    }
	    /**
	     * Ĭ�Ϲ��캯����data=0
	     */
	    public Node(){
	        this(0);
	    }
	}
	
	/**
	     * ���ĸ��ڵ�
	     */
	    public Node root;
	    /**
	     * ��¼���Ľڵ����
	     */
	    public int size;

	    /**
	     * Ĭ�Ϲ��캯�������ĸ��ڵ�Ϊnull
	     */
	    public BinaryTree() {
	        root = null;
	        size = 0;
	    }

	    /**
	     * ����һ���µĽڵ�node
	     * 
	     * @param node
	     */
	    public void insert(Node node) {
	        if (root == null) {
	            root = node;
	            size++;
	            return;
	        }
	        Node current = root;
	        while (true) {
	            if (node.data <= current.data) {
	                // �������ڵ��ֵС�ڵ�ǰ�ڵ��ֵ��˵��Ӧ�ò��뵽��ǰ�ڵ�������������ʱ���������Ϊ�գ���ֱ�����õ�ǰ�ڵ��������Ϊ����ڵ㡣
	                if (current.left == null) {
	                    current.left = node;
	                    size++;
	                    return;
	                }
	                current = current.left;
	            } else {
	                // �������ڵ��ֵ���ڵ�ǰ�ڵ��ֵ��˵��Ӧ�ò��뵽��ǰ�ڵ�������������ʱ���������Ϊ�գ���ֱ�����õ�ǰ�ڵ��������Ϊ����ڵ㡣
	                if (current.right == null) {
	                    current.right = node;
	                    size++;
	                    return;
	                }
	                current = current.right;
	            }
	        }
	    }

	    /**
	     * ����һ��ֵΪdata�Ľڵ�
	     * 
	     * @param data
	     */
	    public void insert(int data) {
	        insert(new Node(data));
	    }

	    /**
	     * ����int���������ֵ����һ������������
	     * 
	     * @param datas
	     */
	    public void bulidTree(int[] datas) {
	        for (int i = 0, len = datas.length; i < len; i++) {
	            insert(datas[i]);
	        }
	    }

	    /**
	     * ���ض����������Ĳ�α����Ľ����ʹ��ͨ�õĹ�����ȱ�������
	     * 
	     * @return ��int�������ʽ���ؽ��
	     */
	    public int[] layerOrder() {
	        int[] res = new int[size];
	        if (root == null) {
	            return res;
	        }
	        // ��һ�����д洢�ڵ��˳��һ�η�����ڵ㣬�������ӽڵ㣬�����Һ��ӽڵ�
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.offer(root);

	        int i = 0;
	        while (!queue.isEmpty()) {
	            Node current = queue.poll();
	            res[i++] = current.data;
	            if (current.left != null) {
	                queue.offer(current.left);
	            }
	            if (current.right != null) {
	                queue.offer(current.right);
	            }
	        }
	        return res;
	    }

	    /**
	     * ��������������������ǵݹ�ķ������������˼��
	     * 
	     * @return ��int�������ʽ���ؽ��
	     */
	    public int[] preOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //ʹ��stack�洢�������Ľڵ�
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        while (node != null) {
	            //һֱ���±�����֪�������ӽڵ�Ϊ��
	            while (node != null) {
	                stack.push(node);
	                res[i++] = node.data;
	                node = node.left;
	            }
	            //���ӽڵ�Ϊ��֮�������ң�����ҵ�����һ���ڵ���Һ��ӽڵ�Ϊ�գ���ô���������ң�ֱ���ҵ�һ���Һ��ӽڵ㲻Ϊ�յ�
	            while (!stack.isEmpty() && stack.peek().right == null) {
	                node = stack.pop();
	            }
	            if(!stack.isEmpty()){
	                node=stack.pop();
	                //�ҵ���һ���Һ��ӽڵ㲻Ϊ�յĽڵ㣬��ȥ���������Һ��ӽڵ�
	                if (node != null) {
	                    node = node.right;
	                }
	            }else{
	                node=null;
	            }
	        }
	        return res;
	    }

	    /**
	     * �����������������  �ǵݹ�ķ������������˼��
	     * @return
	     */
	    public int[] inOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //ʹ��stack�洢�������Ľڵ�
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        while (node != null) {
	            //һֱ���±�����֪�������ӽڵ�Ϊ��
	            while (node != null) {
	                stack.push(node);
	                node = node.left;
	            }
	            //���ӽڵ�Ϊ��֮�������ң��ҵ���һ���ڵ�.����ҵ�����һ���ڵ���Һ��ӽڵ�Ϊ�գ���ô���������ң�ֱ���ҵ�һ���Һ��ӽڵ㲻Ϊ�յ�
	            while (!stack.isEmpty() && stack.peek().right == null) {
	                node = stack.pop();
	                res[i++] = node.data;
	            }
	            if (!stack.isEmpty()) {
	                node = stack.pop();
	                res[i++] = node.data;
	                //�ҵ���һ���Һ��ӽڵ㲻Ϊ�յĽڵ㣬��ȥ���������Һ��ӽڵ�
	                if (node != null) {
	                    node = node.right;
	                }
	            }else{
	                node=null;
	            }

	        }
	        return res;
	    }


	    /**
	     * �����������������  �ǵݹ�ķ������������˼��
	     * @return
	     */
	    public int[] postOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //ʹ��stack�洢�������Ľڵ�
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        //�洢ÿ���ڵ��Ƿ���ʱ��طù���Ҳ�����Ƿ��Ǵ������������������طõġ�
	        Stack<Boolean> stackFlag=new Stack<Boolean>();

	        while (node != null) {
	            //һֱ���±�����֪�������ӽڵ�Ϊ��
	            while (node != null) {
	                stack.push(node);
	                stackFlag.add(false);
	                node = node.left;
	            }
	            //���ӽڵ�Ϊ��֮�������ң��ҵ���һ���ڵ�.����ҵ�����һ���ڵ���Һ��ӽڵ�Ϊ�գ���ô���������ң�ֱ���ҵ�һ���Һ��ӽڵ㲻Ϊ�յ�
	            while (!stack.isEmpty() && (stack.peek().right == null||stackFlag.peek()==true)) {
	                node = stack.pop();
	                stackFlag.pop();
	                res[i++] = node.data;
	            }
	            if (!stack.isEmpty()) {
	                node=stack.peek();
	                stackFlag.pop();
	                stackFlag.add(true);
	                //�ҵ���һ���Һ��ӽڵ㲻Ϊ�յĽڵ㣬��ȥ���������Һ��ӽڵ�
	                if (node != null) {
	                    node = node.right;
	                }
	            }else{
	                node=null;
	            }

	        }
	        return res;
	    }
	    /**
	     * ����������ݹ鷽��ʵ��
	     * @param node ��ǰ���ʵĽڵ�
	     * @param list �洢�ڵ�ֵ������
	     */
	    private void preOrderRe(Node node,List<Integer> list){

	        if(list==null){
	            list=new ArrayList<Integer>();
	        }
	        if(node==null){
	            return;
	        }
	        list.add(node.data);
	        if(node.left!=null){
	            preOrderRe(node.left,list);
	        }
	        if(node.right!=null){
	            preOrderRe(node.right,list);
	        }
	    }
	    /**
	     * ����������ݹ� ��������ʵ�ֺ���
	     * @return
	     */
	    public int[] preOrderRe(){
	        List<Integer> list = new ArrayList<Integer>();
	        preOrderRe(root, list);
	        int[] res=new int[size];
	        for(int i=0,size=list.size();i<size;i++){
	            res[i]=list.get(i);
	        }
	        return res;
	    }

	    /**
	     * ����������ݹ鷽��ʵ��
	     * @param node ��ǰ���ʵĽڵ�
	     * @param list �洢�ڵ�ֵ������
	     */
	    private void inOrderRe(Node node,List<Integer> list){

	        if(list==null){
	            list=new ArrayList<Integer>();
	        }
	        if(node==null){
	            return;
	        }
	        if(node.left!=null){
	            inOrderRe(node.left,list);
	        }
	        list.add(node.data);
	        if(node.right!=null){
	            inOrderRe(node.right,list);
	        }
	    }
	    /**
	     * ����������ݹ� ��������ʵ�ֺ���
	     * @return
	     */
	    public int[] inOrderRe(){
	        List<Integer> list = new ArrayList<Integer>();
	        inOrderRe(root, list);
	        int[] res=new int[size];
	        for(int i=0,size=list.size();i<size;i++){
	            res[i]=list.get(i);
	        }
	        return res;
	    }
	    /**
	     * ����������ݹ鷽��ʵ��
	     * @param node ��ǰ���ʵĽڵ�
	     * @param list �洢�ڵ�ֵ������
	     */
	    private void postOrderRe(Node node,List<Integer> list){

	        if(list==null){
	            list=new ArrayList<Integer>();
	        }
	        if(node==null){
	            return;
	        }
	        if(node.left!=null){
	            postOrderRe(node.left,list);
	        }
	        if(node.right!=null){
	            postOrderRe(node.right,list);
	        }
	        list.add(node.data);
	    }
	    /**
	     * ����������ݹ� ��������ʵ�ֺ���
	     * @return
	     */
	    public int[] postOrderRe(){
	        List<Integer> list = new ArrayList<Integer>();
	        postOrderRe(root, list);
	        int[] res=new int[size];
	        for(int i=0,size=list.size();i<size;i++){
	            res[i]=list.get(i);
	        }
	        return res;
	    }
	    public static void main(String[] args){
	    	        ///int[] datas={2,8,7,4,9,3,1,6,7,5};
	    			int[] datas={1,2,3,4,5,6,7,8};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        /*int[] res = bt.inOrder();
	    	        System.out.print("�������(�ǵ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }*/
	    	        System.out.println();
	    	        bt.testInOrderRe(datas);
	    	        System.out.println();
	    	        bt.testPostOrder(datas);
	    	        
	    	    }
	    	    public void testPreOrder(int[] datas) {
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.preOrder();
	    	        System.out.print("�������(�ǵ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	    	    public void testPostOrder(int[] datas) {
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.postOrder();
	    	        System.out.print("�������(�ǵ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	    	    public void testLayerOrder(int[] datas) {
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.layerOrder();
	    	        System.out.print("��α���(�ǵ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	    	    public void testPreOrderRe(int[] datas){
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.preOrderRe();
	    	        System.out.print("�������(�ݹ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	    	    public void testInOrderRe(int[] datas){
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.inOrderRe();
	    	        System.out.print("�������(�ݹ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	    	    public void testPostOrderRe(int[] datas){
	    	        //int[] datas={2,8,7,4,9,3,1,6,7,5};
	    	        BinaryTree bt=new BinaryTree();
	    	        bt.bulidTree(datas);
	    	        int[] res = bt.postOrderRe();
	    	        System.out.print("�������(�ݹ�)��");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    }
	

}
