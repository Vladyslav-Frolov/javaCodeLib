package info.vladyslav.codeLibrary.y_epam2.epam12_lecture.test4;

public class Test5 {
	
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				while (true);
			}
		};
		
		t.start();
		t.start();
	}

}
