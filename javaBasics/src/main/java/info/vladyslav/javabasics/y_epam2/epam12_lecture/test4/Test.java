package info.vladyslav.javabasics.y_epam2.epam12_lecture.test4;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		//new Child().start();

		Thread t = new Child();

		t.start();
		
		t.join();
		
		System.out.println("Ok");
	}

}

class Child extends Thread {

	public void run() {
		for (int j = 0; j < 5; j++) {
			System.out.println("Child");
			
			try {
				sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
