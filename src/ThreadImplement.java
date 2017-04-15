

		public class ThreadImplement extends Thread {
		    public volatile static int count=0;

		    private static void addCount() {
		        for (int i = 0; i < 100; i++) {
		            count++;
		        }
		        System.out.println("count=" + count);
		    }

		    @Override
		    public void run() {
		        addCount();
		    }
		}

		   

