package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWIthSyncUsingLock {

	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}

		executor.shutdown();

		while (!executor.isTerminated()) {

		}

		System.out.println("what is balance? " + account.getBalance());
	}

	public static class AddPennyTask implements Runnable {

		@Override
		public void run() {
			account.deposit(1);
		}
	}

	public static class Account {
		// private static Lock lock = new ReentrantLock();
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			// lock.lock();

			try {
				int newBalance = balance + amount;

				Thread.sleep(20);
				balance = newBalance;
			} catch (InterruptedException ex) {

			} finally {
				// lock.unlock();
			}
		}
	}
}
