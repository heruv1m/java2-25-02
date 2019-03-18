public interface Storm {
    void event() throws RainedOut;
    void rainHard() throws StormException;
}