package study01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RealTimeStringFormat {

	private static volatile String currentTimeString = "";

	public static void main(String[] args) {
		Thread updateTh = new Thread(RealTimeStringFormat::updateTimeString);

		updateTh.start();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Current : " + currentTimeString);
		}

		updateTh.interrupt();
	}

	public static void updateTimeString() {

		while (!Thread.interrupted()) {
			LocalDateTime loc = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("HH시:mm분:ss초");
			String now = loc.format(format);
			
			
			currentTimeString = now;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
