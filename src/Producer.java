public class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {

            String message = "produce:" + System.currentTimeMillis();
            store.put(message);
            System.out.println("sended::" + message);


        }
    }
}
