import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // List<String> s = new ArrayList<>();
        Set<String> s = new TreeSet<>();

        s.add("cccccb");
        s.add("abvbbbbbb");
        s.add("b");
        s.add("c");
        s.add("a");
        s.add("a");

        System.out.println(s);
    }

    static class MyKey implements Comparable {
        private final String name = null;
        private int age = 12;
        private String accountStatus;

        public MyKey setAge(int age) {
            this.age = age;
            return this;
        }

        @Override
        public int hashCode() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            return false;

        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
