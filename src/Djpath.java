import java.util.Scanner;

public class Djpath {
	static int M = 10000;  
	static int en;
    public static void main(String[] args) {  
  
        //�ڽӾ���  
        int[][] weight = {
				{0, 2, 10, 5, 3, M },
				{M, 0, 12, M, M, 10},
				{M, M,  0, M, 7,  M},
				{2, M,  M, 0, 2,  M},
				{4, M,  M, 1, 0,  M},
				{3, M,  1, M, 2,  0}
		};
       
		Scanner in = new Scanner(System.in);
		en = in.nextInt() - 1;
		int dw = in.nextInt() - 1;
		
		for(int i = 0; i <6; i++) {
			weight[i][dw] = M;
		}
		for(int j = 0; j <6; j++) {
			weight[dw][j] = M;
		}
  
        int[] shortPath = Dijsktra(weight, 4);  
        System.out.println(shortPath[en]);
    }  
  
    //����һ������ͼ��Ȩ�ؾ��󣬺�һ�������start����0��ţ�������������У�  
    //����һ��int[] ���飬��ʾ��start���������·������  
    public static int[] Dijsktra(int[][] weight, int start){  
  
        int n = weight.length;  
        //��Ŵ�start��������������·��  
        int[] shortPath = new int[n];  
        //��Ŵ�start��������������·�����ַ�����ʾ  
        String[] path=new String[n];  
        for(int i=0;i<n;i++)  
        {  
            path[i] = "[" + start + "," + i;  
        }  
        //��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,1��ʾ�����  
        int[] visited = new int[n];  
  
        shortPath[start] = 0;  
        visited[start] = 1;  
        for(int count = 1; count <= n - 1; count++)  
        {  
            // ѡ��һ�������ʼ����start�����δ��Ƕ���  
            int k = -1;  
            int dmin = Integer.MAX_VALUE;  
            for(int i = 0;i < n;i++)  
            {  
                if(visited[i] == 0 && weight[start][i] < dmin)  
                {  
                    dmin = weight[start][i];  
                    k = i;  
                }  
            }  
            //����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·������dmin  
            shortPath[k] = dmin;  
            visited[k] = 1;  
            //��kΪ�м�㣬������start��δ���ʸ���ľ���  
            for(int i = 0;i < n;i++)  
            {  
            	//path[i] = "["
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i])  
                {  
                    weight[start][i] = weight[start][k] + weight[k][i];  
                    path[i] = path[k] + ","+ i;  
                } 
                
            }  
            path[count] += "]";
        }  
        System.out.println(path[en]);          
        return shortPath;  
    }  
}
	
