import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/**
 * BinaryTree二叉排序树类

 */
public class BinaryTree {
	//定义一个Node类
	public class Node {
	    /**
	     * 节点的数据，这里我们用一个int表示
	     */
	    public int data;
	    /**
	     * 节点的左孩子
	     */
	    public Node left;
	    /**
	     * 节点的右孩子
	     */
	    public Node right;
	    /**
	     * 构造函数，data初始化节点的值
	     * @param data
	     */
	    public Node(int data){
	        this.data=data;
	    }
	    /**
	     * 默认构造函数，data=0
	     */
	    public Node(){
	        this(0);
	    }
	}
	
	/**
	     * 树的根节点
	     */
	    public Node root;
	    /**
	     * 记录树的节点个数
	     */
	    public int size;

	    /**
	     * 默认构造函数，树的根节点为null
	     */
	    public BinaryTree() {
	        root = null;
	        size = 0;
	    }

	    /**
	     * 插入一个新的节点node
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
	                // 如果插入节点的值小于当前节点的值，说明应该插入到当前节点左子树，而此时如果左子树为空，就直接设置当前节点的左子树为插入节点。
	                if (current.left == null) {
	                    current.left = node;
	                    size++;
	                    return;
	                }
	                current = current.left;
	            } else {
	                // 如果插入节点的值大于当前节点的值，说明应该插入到当前节点右子树，而此时如果右子树为空，就直接设置当前节点的右子树为插入节点。
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
	     * 插入一个值为data的节点
	     * 
	     * @param data
	     */
	    public void insert(int data) {
	        insert(new Node(data));
	    }

	    /**
	     * 根据int数组里面的值建立一个二叉排序树
	     * 
	     * @param datas
	     */
	    public void bulidTree(int[] datas) {
	        for (int i = 0, len = datas.length; i < len; i++) {
	            insert(datas[i]);
	        }
	    }

	    /**
	     * 返回二叉排序树的层次遍历的结果，使用通用的广度优先遍历方法
	     * 
	     * @return 以int数组的形式返回结果
	     */
	    public int[] layerOrder() {
	        int[] res = new int[size];
	        if (root == null) {
	            return res;
	        }
	        // 用一个队列存储节点的顺序，一次放入根节点，根的左孩子节点，根的右孩子节点
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
	     * 先序遍历二叉排序树，非递归的方法，深度优先思想
	     * 
	     * @return 以int数组的形式返回结果
	     */
	    public int[] preOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //使用stack存储遍历到的节点
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        while (node != null) {
	            //一直往下遍历，知道到左孩子节点为空
	            while (node != null) {
	                stack.push(node);
	                res[i++] = node.data;
	                node = node.left;
	            }
	            //左孩子节点为空之后，往后找，如果找到的上一个节点的右孩子节点为空，那么继续往上找，直到找到一个右孩子节点不为空的
	            while (!stack.isEmpty() && stack.peek().right == null) {
	                node = stack.pop();
	            }
	            if(!stack.isEmpty()){
	                node=stack.pop();
	                //找到了一个右孩子节点不为空的节点，就去遍历他的右孩子节点
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
	     * 中序遍历二叉排序树  非递归的方法，深度优先思想
	     * @return
	     */
	    public int[] inOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //使用stack存储遍历到的节点
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        while (node != null) {
	            //一直往下遍历，知道到左孩子节点为空
	            while (node != null) {
	                stack.push(node);
	                node = node.left;
	            }
	            //左孩子节点为空之后，往后找，找到上一个节点.如果找到的上一个节点的右孩子节点为空，那么继续往上找，直到找到一个右孩子节点不为空的
	            while (!stack.isEmpty() && stack.peek().right == null) {
	                node = stack.pop();
	                res[i++] = node.data;
	            }
	            if (!stack.isEmpty()) {
	                node = stack.pop();
	                res[i++] = node.data;
	                //找到了一个右孩子节点不为空的节点，就去遍历他的右孩子节点
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
	     * 后序遍历二叉排序树  非递归的方法，深度优先思想
	     * @return
	     */
	    public int[] postOrder() {
	        int[] res = new int[size];
	        int i = 0;
	        //使用stack存储遍历到的节点
	        Stack<Node> stack = new Stack<Node>();
	        Node node = root;
	        //存储每个节点是否访问被回访过，也就是是否是从左子树还是右子树回访的。
	        Stack<Boolean> stackFlag=new Stack<Boolean>();

	        while (node != null) {
	            //一直往下遍历，知道到左孩子节点为空
	            while (node != null) {
	                stack.push(node);
	                stackFlag.add(false);
	                node = node.left;
	            }
	            //左孩子节点为空之后，往后找，找到上一个节点.如果找到的上一个节点的右孩子节点为空，那么继续往上找，直到找到一个右孩子节点不为空的
	            while (!stack.isEmpty() && (stack.peek().right == null||stackFlag.peek()==true)) {
	                node = stack.pop();
	                stackFlag.pop();
	                res[i++] = node.data;
	            }
	            if (!stack.isEmpty()) {
	                node=stack.peek();
	                stackFlag.pop();
	                stackFlag.add(true);
	                //找到了一个右孩子节点不为空的节点，就去遍历他的右孩子节点
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
	     * 先序遍历，递归方法实现
	     * @param node 当前访问的节点
	     * @param list 存储节点值的容器
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
	     * 先序遍历，递归 调用上面实现函数
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
	     * 中序遍历，递归方法实现
	     * @param node 当前访问的节点
	     * @param list 存储节点值的容器
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
	     * 中序遍历，递归 调用上面实现函数
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
	     * 后序遍历，递归方法实现
	     * @param node 当前访问的节点
	     * @param list 存储节点值的容器
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
	     * 后序遍历，递归 调用上面实现函数
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
	    	        System.out.print("中序遍历(非递)：");
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
	    	        System.out.print("先序遍历(非递)：");
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
	    	        System.out.print("后序遍历(非递)：");
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
	    	        System.out.print("层次遍历(非递)：");
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
	    	        System.out.print("先序遍历(递归)：");
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
	    	        System.out.print("中序遍历(递归)：");
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
	    	        System.out.print("后序遍历(递归)：");
	    	        for(int i=0,len=res.length;i<len;i++){
	    	            System.out.print(res[i]+" ");
	    	        }
	    	        System.out.println();
	    }
	

}
