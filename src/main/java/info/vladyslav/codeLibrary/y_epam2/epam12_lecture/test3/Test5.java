package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test3;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Child();
		t.start();

		Thread.sleep(1555);
		
		t.interrupt();

	}

	static class Child extends Thread {

		@Override
		public void run() {
			while (true) {
				System.out.println("Child");

				try {
					sleep(333);
				} catch (InterruptedException e) {
//					return;
					break;
				}
			}

			// ...
		}
	}

}
