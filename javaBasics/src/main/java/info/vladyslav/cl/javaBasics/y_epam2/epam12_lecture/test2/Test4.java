package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test2;

public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		// main thread

		new Thread() {

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

		}.start(); // <-- main thread start a child thread
		
//		for (int j = 0; j < 1000; j++) {
			System.out.println("Main is going to sleep");
//		}
		
		Thread.sleep(1500); // <--
		
		System.out.println("Main is stopped!");
	}

}
