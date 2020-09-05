package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test1;

public class Test5 {

	public static void main(String[] args) {
		Thread t = new MyThread();

		t.start();
		
//		t.run(); // <-- main thread
		
		System.out.println("Main is stopped!");
	}
	
	
	

	static class MyThread extends Thread {

		@Override
		public void run() {
			while (true) {
				System.out.println(
					Thread.currentThread().getName()); // <--

				try { sleep(333); }
				catch (InterruptedException e) { e.printStackTrace(); }

			}
		}

	}

}
