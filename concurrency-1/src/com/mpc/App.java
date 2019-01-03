package com.mpc;

public class App {

	public static void main(String[] args) {
		Thread thread1 = new Runner1();
		Thread thread2 = new Runner2();

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
		}

		System.out.println("Completed!");
	}

}

class Runner1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runner1: " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}

}

class Runner2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runner2: " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}

}
