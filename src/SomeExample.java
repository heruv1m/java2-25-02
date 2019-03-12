
public class SomeExample {
    int i = 0;
    Object o1 = new Object();
    Object o2 = new Object();

    public static synchronized void staticMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "::staticMethod");
    }

    public synchronized void m1() {

        synchronized (o1) {
            System.out.println("m1 sync1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println("m1 sync2");

            }
        }
    }

    public void m2() {
        synchronized (o1) {
            System.out.println("m2 sync1");
            synchronized (o2) {
                System.out.println("m2 sync2");

            }
        }
    }

    public int getResult() {
        return i;
    }
}