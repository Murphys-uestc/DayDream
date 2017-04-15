import java.util.TreeSet;
//1) equals、compareTo决定的是怎么比的问题，即用什么field进行大小比较
//2) 自然排序、定制排序、Comparator决定的是谁大的问题，即按什么顺序(升序、降序)进行排序
public class TreeSetTest {
	public static void main(String [] args){
		TreeSet<Integer> nums= new TreeSet<Integer>();
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		System.out.println(nums);
		//输出集合元素，看到集合元素已经处于排序状态
        System.out.println(nums);

        //输出集合里的第一个元素
        System.out.println(nums.first());

        //输出集合里的最后一个元素
        System.out.println(nums.last());

        //返回小于4的子集，不包含4
        System.out.println(nums.headSet(4));

        //返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println(nums.tailSet(5));

        //返回大于等于-3，小于4的子集。
        System.out.println(nums.subSet(-3 , 4));

	}

}
