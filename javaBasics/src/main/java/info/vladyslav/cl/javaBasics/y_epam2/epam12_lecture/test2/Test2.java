package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test2;

public class Test2 extends Thread {
	
	public Test2() {
		// ... 

		start(); // <--
	}
	
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
	
	public static void main(String[] args) {
		new Test2();
	}

}
