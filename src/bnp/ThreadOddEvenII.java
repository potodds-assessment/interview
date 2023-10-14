package bnp;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadOddEvenII {

    AtomicLong i = new AtomicLong();
    boolean notDone = true;

    Thread one = new Thread( new Runnable() { 
        public synchronized void run() {
            while(true) {
                synchronized(i) {
                    if (i.get() == 10) {
                        i.notify();
                        break;
                    }

                    System.out.println("thread1: " + i.incrementAndGet());
                    i.notify();

                    try {
                        i.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("thread1: exiting");
        } 
    } );

    Thread two = new Thread( new Runnable() { 
        public synchronized void run() {
            while(true) {
                synchronized(i) {
                    if (i.get() == 10) {
                        i.notify();
                        break;
                    }

                    System.out.println("thread2: " + i.incrementAndGet());
                    i.notify();

                    try {
                        i.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("thread2: exiting");
        } 
    } );

    public void run() throws InterruptedException {
        one.start();
        two.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOddEvenII app = new ThreadOddEvenII();
        app.run();
    }
}
