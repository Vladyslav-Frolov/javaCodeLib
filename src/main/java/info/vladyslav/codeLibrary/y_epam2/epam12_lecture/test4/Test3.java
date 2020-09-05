package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test4;

public class Test3 {

	
	static class Worker extends  Thread {
		
		private String message;
		private int time;

		public Worker(String message, int time) {
			this.message = message;
			this.time = time;
		}
		
		public void run() {
			while (true) {
				System.out.println(message);
				try {
					sleep(time);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[3];
		

//		for (Thread t : threads) {
//			t = new Worker("asdf", 333);
//		}
		
		for (int j = 0; j < threads.length; j++) {
			threads[j] = 
				new Worker("Mes" + j, 333 * (j + 1));
		}
		
		// start
		for (Thread t : threads) {
			t.start();
		}
		
//		Thread.sleep(2 * 60 * 60 * 1000 + 43 * 60 * 1000);
		Thread.sleep(3000);

		// interrupt
		for (Thread t : threads) {
			t.interrupt();
		}
		
		
		
	}

}
