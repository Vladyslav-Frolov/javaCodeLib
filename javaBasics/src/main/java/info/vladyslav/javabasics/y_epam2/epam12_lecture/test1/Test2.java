package info.vladyslav.javabasics.y_epam2.epam12_lecture.test1;

public class Test2 {
	
	public static void main(String[] args) {
//		MyThread t = new MyThread();
		Thread t = new Thread(new MyThread2());
		
		t.start(); // <--
	}

}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Child"); // <--

			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
