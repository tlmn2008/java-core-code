package kenny.concurrent.thread;

class MyRunMethod implements Runnable{
	private int tickets = 20;
	private synchronized void sale(){  
		if(tickets > 0){
			System.out.println(Thread.currentThread().getName() + " sell:" + (tickets--));
			try{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void run(){
		while(tickets > 0){
			sale();
		}
		System.out.println(Thread.currentThread().getName() + ": run to the end!");
	}
}

class MyThread extends Thread{
	private int tickets = 20;
	private synchronized void sale(){  
		if(tickets > 0){
			System.out.println(Thread.currentThread().getName() + " sell:" + (tickets--));
			try{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void run(){
		while(tickets > 0){
			sale();
		}
		System.out.println(Thread.currentThread().getName() + ": run to the end!");
	}
	
}

public class ThreadTest {
	public static void main(String[] args) {
		//*******************************************************
		MyRunMethod myRunMethod = new MyRunMethod();
		//three thread use the same run method
		Thread thread1 = new Thread(myRunMethod); 
		Thread thread2 = new Thread(myRunMethod);
		Thread thread3 = new Thread(myRunMethod);
		thread1.start();
		thread2.start();
		thread3.start();
		
		//*******************************************************
		/*
		MyThread thread4 = new MyThread();
		MyThread thread5 = new MyThread();
		MyThread thread6 = new MyThread();
		thread4.start();
		thread5.start();
		thread6.start();
		*/
	}
}
