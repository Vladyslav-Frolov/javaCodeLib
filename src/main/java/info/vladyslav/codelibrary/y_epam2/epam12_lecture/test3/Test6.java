package info.vladyslav.codelibrary.y_epam2.epam12_lecture.test3;

/*
 
 interrupt
 isInterrupted
 
 static interrupted
 
*/
public class Test6 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Child();
		t.start();

		Thread.sleep(1555);
		
		t.interrupt();

	}

	static class Child extends Thread {

		@Override
		public void run() {
			while (!isInterrupted()) {
				System.out.println("Child");

				try {
					sleep(333);
				} catch (InterruptedException e) {
					interrupt();
				}
			}

			// ...
		}
	}

}
