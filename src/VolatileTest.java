
public class VolatileTest {
	public static volatile int count=0;
	
	public static void increase(){
		for (int i = 0; i < 10; i++) {
            count++;
        }

		System.out.println("count= "+count);
	}
	
	public static void main(String[] args){
		Thread[] threads = new Thread[100];
		for(int i = 0;i < 100;i++){
			threads[i] = new Thread(new Runnable(){
				public void run(){
					for(int j = 0;j<100;j++){
						increase();
					}
				}
			});
			threads[i].start();
 		}
		/*while(Thread.activeCount()>1)
			Thread.yield();//œﬂ≥Ã»√≤Ω
		System.out.println("count= "+count);*/		
	}
}
