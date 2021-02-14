package concurrency;
/***********************
 * Basic idea of a deadlock. 
 * 2 threads grab a lock on different objects.  They then try to grab a lock on each others object.  Deadlock ensues. 
 * 
 * To avoid this, code should be written so that they both try to grab lock on same objects in sequence.
 * 
 * @author lwlee
 *
 */
public class Deadlock {
	
	public static void main(String[] args) {
		Object monitor1 = new Object();
		Object monitor2 = new Object();
		
		Thread one = new Thread(new Runnable() { 
			public void run() {
				synchronized(monitor1) {
					System.out.println(Thread.currentThread().getName() + ": synch monitor1");
					synchronized(monitor2) {
						System.out.println(Thread.currentThread().getName() + ": synch monitor2");
					}
					System.out.println(Thread.currentThread().getName() + ": done");
				}
			}});
		
		Thread two = new Thread(new Runnable() { 
			public void run() {
				synchronized(monitor2) {
					System.out.println(Thread.currentThread().getName() + ": synch monitor2");
					synchronized(monitor1) {
						System.out.println(Thread.currentThread().getName() + ": synch monitor1");
					}					
				}
				System.out.println(Thread.currentThread().getName() + ": done");
			}});
		
		one.start();
		two.start();
	}
}

