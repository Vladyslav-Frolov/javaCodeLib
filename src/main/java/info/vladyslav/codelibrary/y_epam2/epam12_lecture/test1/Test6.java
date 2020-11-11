package info.vladyslav.codelibrary.y_epam2.epam12_lecture.test1;

public class Test6 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		
		System.out.println(t.getPriority());

		t.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t.getPriority());
		
		t.join();

	}

}