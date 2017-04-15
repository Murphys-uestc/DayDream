import java.util.Scanner;

public class Djpath {
	static int M = 10000;  
	static int en;
    public static void main(String[] args) {  
  
        //邻接矩阵  
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
  
    //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）  
    //返回一个int[] 数组，表示从start到它的最短路径长度  
    public static int[] Dijsktra(int[][] weight, int start){  
  
        int n = weight.length;  
        //存放从start到其他各点的最短路径  
        int[] shortPath = new int[n];  
        //存放从start到其他各点的最短路径的字符串表示  
        String[] path=new String[n];  
        for(int i=0;i<n;i++)  
        {  
            path[i] = "[" + start + "," + i;  
        }  
        //标记当前该顶点的最短路径是否已经求出,1表示已求出  
        int[] visited = new int[n];  
  
        shortPath[start] = 0;  
        visited[start] = 1;  
        for(int count = 1; count <= n - 1; count++)  
        {  
            // 选出一个距离初始顶点start最近的未标记顶点  
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
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin  
            shortPath[k] = dmin;  
            visited[k] = 1;  
            //以k为中间点，修正从start到未访问各点的距离  
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
	
