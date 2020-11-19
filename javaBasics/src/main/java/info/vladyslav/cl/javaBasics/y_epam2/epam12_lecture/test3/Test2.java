package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test3;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		
		System.out.println(t.isInterrupted());
		System.out.println(t.isInterrupted());
		
		t.interrupt();

		System.out.println(t.isInterrupted());
		System.out.println(t.isInterrupted());
		
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
	}

}

