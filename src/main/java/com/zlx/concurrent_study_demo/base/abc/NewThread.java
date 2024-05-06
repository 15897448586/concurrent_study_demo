package com.zlx.concurrent_study_demo.base.abc;



import com.zlx.concurrent_study_demo.tools.SleepTools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *类说明：新启线程的方式
 */
public class NewThread {
	/*扩展自Thread类*/
	private static class UseThread extends Thread{
		@Override
		public void run() {
			super.run();
			SleepTools.second(1);
			// do my work;
			System.out.println("I am extendec Thread");
		}
	}

	
	/*实现Runnable接口*/
	private static class UseRunnable implements Runnable{

		@Override
		public void run() {
			// do my work;
			System.out.println("I am implements Runnable");

		}
	}

	private static class useCallable implements Callable {

		@Override
		public Object call() throws Exception {
			Thread.sleep(2000);
			return "I am your father";
		}
	}
	

	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
//		UseThread useThread = new UseThread();
//		useThread.start();
//		//useThread.start();
//
//		UseRunnable useRunnable = new UseRunnable();
//		new Thread(useRunnable).start();
//		System.out.println("main end");
		FutureTask<String> futureTask = new FutureTask<String>(new useCallable());
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}
}
