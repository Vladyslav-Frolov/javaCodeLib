package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test4;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		
		new Thread() {
			public void run() {
				try {
					sleep(1555);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

//				t.interrupt();
			}
		}.start();
		
		
		
	
		System.out.println("before");
		try {
			t.join();
		}  catch (InterruptedException ex) {
			System.out.println("interrupted!");
		}
		System.out.println("after");
	}

}
