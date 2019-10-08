package multiThreading;

public class ThreadDemo {

	public static void main(String[] args) {
		Runnable printA = new PrintChar('a', 1000);
		Runnable printB = new PrintChar('b', 1000);
		Runnable print100 = new PrintNum(1000);

		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
	class PrintChar implements Runnable {
		private char charToPrint;
		private int times;

		public PrintChar(char c, int n) {
			charToPrint = c;
			times = n;
		}

		@Override
		public void run() {
			for (int i = 0; i < times; i++) {
				System.out.println(charToPrint);
			}
		}
	}
	
	class PrintNum implements Runnable {
		private int num;
		
		public PrintNum(int num) {
			this.num = num;
		}

		@Override
		public void run() {
			for(int i = 1; i <= num; i++) {
				System.out.println(" " + i);
			}
		}
	}
