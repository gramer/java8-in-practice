package lambda;

import java.util.List;
import java.util.function.Consumer;


public class ConsumerExample {

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer::accept);
    }
}