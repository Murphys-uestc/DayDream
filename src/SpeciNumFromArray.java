/*
 * 
2017年网易游戏的一道编程题，大致意思是满足组合攻击技能，必须是所选择时技能的和为m（m>0），且所选的这些技能的乘积最大：

分解后主解决两个问题：

其一：求数组中和为m的所有子数组；

其二：在满足一的条件下，求所有子数组的最大值；

主要考察的还是如何求数组中和为m的所有子数组：

如：数组[1,2,3,4,5,6]，m=7时，满足条件的子数组有[1,2,4],[3,4],[2,5],[1,6];

主要使用回溯法解决该问题，思路以后补上
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
            Arrays.sort(arr);//必须先排序
            ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
            boolean[] visited = new boolean[n];
            backTrack(arr, visited, 0, 0, sum, lists);//求和为sum的所有组合数
            System.out.println(lists);
            System.out.println(lists.size());//求和为sum的所有组合数
            System.out.println(maxFighting(lists));//求最大组合攻击力
        }
    }
    //求非降序序列中和为定值的所有组合，必须为非降序序列，否则会重复，如{2 4 2 5 4 1 6}-->[[2, 4, 4], [2, 2, 5, 1], [4, 2, 4], [4, 5, 1], [5, 4, 1]],统计有重复只是顺序不一样
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
