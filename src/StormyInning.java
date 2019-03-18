public class StormyInning extends Inning implements Storm {
    /*
    1. В конструкторе дочернего класса можно задавать дополнительную спецификацию исключений,
    так как конструкторы не наследуються от радительского класса и являються как бы статическими методами класса,
    но необходимо указывать в спецификации те исключения, которые могут быть сгенерены конструктором родительского
    класса, которые вызываються явно или не явно в конструкторе дочернего класса. Я ПРАВИЛЬНО РАССУЖДАЮ?
     */

    /**
     * Вы обязаны обработать или сделать выброс родительского checked исключения
     */
    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    /*
    2. Как я понимаю, все наследуемые (переопределенные) методы должны полность реализовывать спецификацию исключений
    наследуемого (переопределенного) метода. Как видно в методе rainHard(). Я ПРАВИЛЬНО РАССУЖДАЮ?
     */

    /**
     * Не совсем. Наследник может вообще не выбрасывать исключение. Также наследник может выбросить наследника исключения. см Storm#rainHard() и StormyInning#rainHard()
     */
    public void rainHard() throws RainedOut {
    }

    /*
    3. Вообще не понимаю, что происходит с методом event(). Он поределен и в класса Inning и в интерфейсе Storm.
    Почему у этого метода вообще отсудствует спецификация, если в родительских классе и интерфейсе определена спецификация
    причем разная. В тоже время исключения в спецификации являються наследниками класса Exception.
    3.1 Первое что меня смотило, это то что спецификация вообще отсудствует.
    3.2 Исходя из логики (не знаю правильно ли я мыслю), что впринципе можно указывать в наследуемом методе
    спецификацию исключения, который стоитболее высоко по иерархии, так почему бы не вписать в спецификацью
    Exception. Но компилятор выдает ошибку:
    Error:(45, 17) java: event() in StormyInning cannot implement event() in Storm overridden method does not throw java.lang.Exception
    3.3 Второе, что я подумал, почему бы не подставить все спецификации метода event, которые имеються в классе
    Inning и интерфейсе Storm (вот так event() throws BaseballException, RainedOut). Но компилятор выдает ошибку:
    Error:(49, 17) java: event() in StormyInning cannot implement event() in Storm overridden method does not throw BaseballException

    Самое главное, что я не понимаю, почему спецификация вообще отсудствует и почему нельзя добавить спецификацию
    которая назначена в у родителей метода?
     */

    /**
     * в примере выше StormyInning#rainHard() можно добавить исключение такое же, или ниже по иерархии. В данном случае этого сделать нельзя, поскольку event наследуется и от Inning и от Storm.
     * У них разные сигнатуры исключений. Без них метод имплементирует обоих.
     */
    public void event() {
    }

    /*
    4. И в мотоде atBat() тоже что-то не понятное происходит. В классе родителе метод пишеться с 2 спецификациями
    а переопределенном только одна спецификация PopFoul, которая наследуеться от одной из двух спецификаций
    родительского метода.
    4.1 Почему здесь указана одна спецификация?
    4.2 Почему я могу убрать эту спецификацию и компилятор не будет ругаться?
    4.3 Почему я могу добавить те спецификации, которые вообще никак не относяться к спецификациям родительского метода
     */

    /**
     *
     * ответ дал выше. 4.3 Сомнительно. Вы можете добавить сюда сколько угодно наследников RuntimeException, но не Exception
     */
    public void atBat() throws PopFoul,Strike, RuntimeException {
    }

    @Override
    public void walk() {
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}