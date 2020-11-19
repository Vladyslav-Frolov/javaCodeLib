package info.vladyslav.cl.javaBasics.y_epam2.epam12_lecture.test2;

public class Test3 {
	
	public static void main(String[] args) {

		new Thread() {
			public void run() {
				while (true) {
					System.out.println(getName());
					try { sleep(333); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}.start();


		new Thread() {
			public void run() {
				while (true) {
					System.out.println(getName());
					try { sleep(555); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}.start();
	}

}
