/*
 * 
2017��������Ϸ��һ������⣬������˼��������Ϲ������ܣ���������ѡ��ʱ���ܵĺ�Ϊm��m>0��������ѡ����Щ���ܵĳ˻����

�ֽ��������������⣺

��һ���������к�Ϊm�����������飻

�����������һ�������£�����������������ֵ��

��Ҫ����Ļ�������������к�Ϊm�����������飺

�磺����[1,2,3,4,5,6]��m=7ʱ��������������������[1,2,4],[3,4],[2,5],[1,6];

��Ҫʹ�û��ݷ���������⣬˼·�Ժ���
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpeciNumFromArray {
	public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);//����������
            ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
            boolean[] visited = new boolean[n];
            backTrack(arr, visited, 0, 0, sum, lists);//���Ϊsum�����������
            System.out.println(lists);
            System.out.println(lists.size());//���Ϊsum�����������
            System.out.println(maxFighting(lists));//�������Ϲ�����
        }
    }
    //��ǽ��������к�Ϊ��ֵ��������ϣ�����Ϊ�ǽ������У�������ظ�����{2 4 2 5 4 1 6}-->[[2, 4, 4], [2, 2, 5, 1], [4, 2, 4], [4, 5, 1], [5, 4, 1]],ͳ�����ظ�ֻ��˳��һ��
    public static void backTrack(int[] input, boolean[] visited, int n, 
            int sum, int key, ArrayList<ArrayList<Integer>> lists){
        if(sum>key)
            return;
        if(sum==key){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<=n; j++){
                if(visited[j]){
                    list.add(input[j]);
                }
            }
            lists.add(list);
            return;
        }
        if(n>=input.length)
            return;
        for(int i=n;i<input.length-1;i++){
            if(!visited[i]){
                sum += input[i];
                visited[i] = true;
                backTrack(input, visited, i+1, sum, key, lists);
                visited[i] = false;
                sum -= input[i];
                while(i<input.length-1&&input[i]==input[i+1])
                    i++;
            }
        }
    }
    public static int maxFighting(ArrayList<ArrayList<Integer>> lists){
        int size = lists.size();
        if(lists==null||size==0)
            return -1;
        int maxMultipy = Integer.MIN_VALUE;
        int multipy = 1;
        for(int i=0;i<size;i++){
            ArrayList<Integer> list = lists.get(i);
            for(int j=0;j<list.size();j++){
                multipy *=list.get(j);
            }
            if(multipy>maxMultipy){
                maxMultipy = multipy;
            }
            multipy = 1;
        }
        return maxMultipy;
    }

}
