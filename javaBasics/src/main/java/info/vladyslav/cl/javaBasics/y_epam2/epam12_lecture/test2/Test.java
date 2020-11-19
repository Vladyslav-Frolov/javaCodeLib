package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test2;

public class Test extends Thread {
	
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
		new Test().start();
	}

}
