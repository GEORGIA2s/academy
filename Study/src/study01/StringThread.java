package study01;

public class StringThread {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Thread modifyTh = new Thread(StringThread::modifyString);

		modifyTh.start();

		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sb.append("Main-" + i + " ");
		}

		try {
			modifyTh.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Result = " + sb.toString());

	}

	static void modifyString() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sb.append("Therad -" + i + " ");
		}
		System.out.println("COMPLATE");
	}
}