package info.vladyslav.codelibrary.y_epam2.epam12_lecture.test2;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		// main thread

		Thread t = new Thread() {

			public void run() {
				while (true) {
					System.out.println("Child");
					try {
						sleep(333);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};
		
	//	System.out.println(t.isDaemon());
		t.setDaemon(true);
		
		t.start(); 
		
		System.out.println("Main is going to sleep");
		
		Thread.sleep(1500); // <--
		
		System.out.println("Main is stopped!");
	}

}
