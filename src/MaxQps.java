import java.util.Scanner;
public class MaxQps {
	


		public static void main(String[] args)  {
	        Scanner in = new Scanner(System.in);
	        int maxQps= Integer.valueOf(in.nextLine());
			final String[] rtList = in.nextLine().split(",");
			final int requestNum = Integer.valueOf(in.nextLine());
			final int threadNum = Integer.valueOf(in.nextLine());
			System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
		}
		/**
		 * ���ʹ�����ŵ�������������ؾ����㷨����������ģ�Ͷ���ܹ��������������󣬵�λ���롣
		 * @return
		 */
		static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
	        //TODO
	        int sum = 0;
	        for (String rtl : rtList) {

	            int singleMaxQps = threadNum * 1000 / Integer.valueOf(rtl);

	            if (singleMaxQps > maxQps) {

	                sum += maxQps;

	            }else {

	                sum += singleMaxQps;

	            }

	        }
	        return Long.valueOf(String.valueOf(requestNum / sum * 1000)) ;

		}
	}


