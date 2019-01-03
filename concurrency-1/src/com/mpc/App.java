package com.mpc;

public class App {

	public static void main(String[] args) {
		Worker w1 = new Worker();
		Thread t1 = new Thread(w1);
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		w1.setTerminated(true);
		System.out.println("Finished");
	}

}

class Worker implements Runnable {

	private volatile boolean isTerminated = false;

	public boolean isTerminated() {
		return isTerminated;
	}

	@Override
	public void run() {
		while (!isTerminated) {
			System.out.println("Worker says hello!");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

}
