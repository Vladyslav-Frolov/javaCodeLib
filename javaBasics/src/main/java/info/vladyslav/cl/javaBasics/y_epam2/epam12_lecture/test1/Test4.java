package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test1;

public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread(); // <--
		
		System.out.println(t.getState());
		
		t.join();
		System.out.println("Main stopped!");
	}
	
}