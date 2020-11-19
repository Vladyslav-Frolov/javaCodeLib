package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test3;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		
		t.interrupt(); // <-- main thread 

		System.out.println(t.isInterrupted());
	
		try {
			Thread.sleep(555); // <-- main thread
		} catch (InterruptedException ex) {
			System.out.println(t.isInterrupted());
		}
		
	}
}

