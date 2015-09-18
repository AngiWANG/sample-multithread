package com.allinpay.sample.multithread.basic;

import org.junit.Test;

public class JoinTest {

	@Test
	public void TestJoin1() {
		System.out.println("主线程开始执行");
		Thread computer = new Thread(new Runnable() {
			public void run() {
				System.out.println("子线程开始计算");
				try {
					Thread.sleep(4 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("子线程结束计算");
			}
		});
		computer.start();
		try {
			long start = System.nanoTime();
			computer.join();
			long end = System.nanoTime();
			System.out.println("主线程等待子线程：" + ((end - start) / 1000000) + "毫秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程结束执行");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TestJoin2() {
		System.out.println("主线程开始执行");
		Thread computer = new Thread(new Runnable() {
			public void run() {
				System.out.println("子线程开始计算");
				try {
					Thread.sleep(4 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("子线程结束计算");
			}
		});
		computer.start();
		try {
			long start = System.nanoTime();
			computer.join(2 * 1000);
			long end = System.nanoTime();
			System.out.println("主线程等待子线程：" + ((end - start) / 1000000) + "毫秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程结束执行");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
