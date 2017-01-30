package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class MethodReferenceExample {

    public static Integer parseInt(String number) {
        Function<String, Integer> stringToInteger = Integer::parseInt;
        return stringToInteger.apply(number);
    }

    public static List<Apple> createByMethodReference(Integer... eachHeight) {
        List<Integer> heights = Arrays.asList(eachHeight);
        return mapForApple(heights, Apple::new);
    }

    private static List<Apple> mapForApple(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }

        return result;
    }
}
