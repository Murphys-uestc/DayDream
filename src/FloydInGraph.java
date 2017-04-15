import java.util.ArrayList;   
import java.util.List;
import java.util.Scanner;   
  
public class FloydInGraph {
	public static int INF=1000;  
    //dist[i][j]=INF<==>i 和 j之间没有边   
	int[][] dist;   
    //顶点i 到 j的最短路径长度，初值是i到j的边的权重     
	int[][] path;
	List< Integer> result=new ArrayList< Integer>();
    public static void main(String[] args) {
    	
    	Scanner cin = new Scanner(System.in);
        int begin=cin.nextInt()-1;//起点
        int end=cin.nextInt()-1;//终点
		int dw = cin.nextInt() - 1;//大雾点
        FloydInGraph graph=new FloydInGraph(6);   
        int[][] matrix={   
                /*{INF,2,10,INF,3,INF},   
                {INF,INF,12,INF,INF,10},   
                {INF,INF,INF,INF,7,INF}, 
                {INF,INF,INF,INF,INF,INF},
                {4,INF,INF,INF,INF,INF},   
                {3,INF,1,INF,2,0},*/
                
                {0, 2, 10, 5, 3, INF },
				{INF, 0, 12, INF, INF, 10},
				{INF, INF,  0, INF, 7,  INF},
				{2, INF,  INF, 0, 2,  INF},
				{4, INF,  INF, 1, 0,  INF},
				{3, INF,  1, INF, 2,  0}
                
        };  
        for(int i = 0; i <6; i++) {
        	matrix[i][dw] = INF;
		}
		for(int j = 0; j <6; j++) {
			matrix[dw][j] = INF;
		}
		
        graph.findCheapestPath(begin,end,matrix);   
        List< Integer> list=graph.result;   
        //System.out.println(begin+" to "+end+",the cheapest path is:");   
        System.out.println(graph.dist[begin][end]);
        System.out.println(list.toString());   
           
    }   
  
    public  void findCheapestPath(int begin,int end,int[][] matrix){   
        floyd(matrix);   
        result.add(begin+1);   
        findPath(begin,end);   
        result.add(end+1);   
    }   
       
    public void findPath(int i,int j){   
        int k=path[i][j];   
        if(k==-1)return;   
        findPath(i,k);   //递归
        result.add(k+1);   
        findPath(k,j);   
    }
    
    public  void floyd(int[][] matrix){   
        int size=matrix.length;   
        //initialize dist and path   
        for(int i=0;i< size;i++){   
            for(int j=0;j< size;j++){   
                path[i][j]=-1;   
                dist[i][j]=matrix[i][j];   
            }   
        }   
        for(int k=0;k< size;k++){   
            for(int i=0;i< size;i++){   
                for(int j=0;j< size;j++){   
                    if(dist[i][k]!=INF&&dist[k][j]!=INF&&dist[i][k]+dist[k][j]< dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];   
                        path[i][j]=k;   
                    }   
                }   
            }   
        }   
           
    }   
    public FloydInGraph(int size){   
        this.path=new int[size][size];   
        this.dist=new int[size][size];   
    }  
       
}
