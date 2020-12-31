package wang.angi.sample.multithread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {

	public static void main(String[] args) {

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		// ������Դ���
		int j = 5;
		while (j < 10) {
			TestTask testTask = new TestTask(0, j);
			ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(testTask, 5, 10,
					TimeUnit.SECONDS);
			testTask.setScheduledFuture(scheduledFuture);
			j++;
		}

	}

	static class TestTask implements Runnable {

		/**
		 * ��ǰ��ִ�д���
		 */
		private int i = 0;

		private int biz;

		/**
		 * ������Դ���
		 */
		private int maxTimes;

		private ScheduledFuture<?> scheduledFuture;

		public TestTask(int i, int maxTimes) {
			this.biz = i;
			this.maxTimes = maxTimes;
		}

		public void run() {

			System.out.println(maxTimes + ":" + i + ":" + biz);
			i++;
			if (i == maxTimes) {
				scheduledFuture.cancel(false);
			}

		}

		public ScheduledFuture<?> getScheduledFuture() {
			return scheduledFuture;
		}

		public void setScheduledFuture(ScheduledFuture<?> scheduledFuture) {
			this.scheduledFuture = scheduledFuture;
		}

	}
}
