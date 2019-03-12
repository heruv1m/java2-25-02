public class Main extends Thread {


    public static void main(String[] args) throws InterruptedException {
        SomeExample someExample = new SomeExample();
        Thread thread1 = new Thread(SomeExample::staticMethod);

        Thread thread2 = new Thread(() -> SomeExample.staticMethod());


        thread1.start();
        thread2.start();

        thread1.join();
        // thread2.join();

        System.out.println(Thread.currentThread().getName()+"::job finished");
    }


}
