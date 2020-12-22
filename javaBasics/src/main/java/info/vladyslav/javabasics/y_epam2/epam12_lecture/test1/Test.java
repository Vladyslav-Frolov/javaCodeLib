package info.vladyslav.javabasics.y_epam2.epam12_lecture.test1;

public class Test {
	
	public static void main(String[] args) {
//		MyThread t = new MyThread();
		Thread t = new MyThread();
		
		t.start(); // <--
	}

}

class MyThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("Child"); // <--

			try {
				sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
