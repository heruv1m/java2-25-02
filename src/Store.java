public class Store {
    private String storedMessage;

    public synchronized void put(String message) {
        if (storedMessage != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.storedMessage = message;
        notify();
    }

    public synchronized String getMessage() {
        if (storedMessage == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        String temp = storedMessage;

        storedMessage = null;
        return temp;
    }


}
