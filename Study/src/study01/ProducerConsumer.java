package study01;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
	private static final List<Integer> BUFFER = new LinkedList<>();
	private static final int BUFFER_LIMIT = 5;

	public static void main(String[] args) {
		Thread proThread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				produce(i);
			}
		});

		Thread consumeThread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				consume(i);
			}
		});

		proThread.start();
		consumeThread.start();

		try {
			proThread.join();
			consumeThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void produce(int data) {
		synchronized (BUFFER) {
			while (BUFFER.size() == BUFFER_LIMIT) {
				try {
					BUFFER.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			BUFFER.add(data);
			System.out.println("");
		}
	}

	private static void consume(int data) {

	}

}
