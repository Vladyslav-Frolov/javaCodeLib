package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test1;

public class Test3 {

	public static void main(String[] args) {
//		MyThread t = new MyThread();
		Thread t = new MyThread();
		
//		t.setName("asdfasdf");

//		t.start(); // <--
		t.run();
		
		System.out.println("Main is stopped!");
	}
	
	
	

	static class MyThread extends Thread {

		@Override
		public void run() {
			while (true) {
				System.out.println(
						this.getName()); // <--

				try {
					sleep(333);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
