package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by coupang on 2017. 1. 21..
 */
@Data
@AllArgsConstructor
public class Apple {

    private String color;
    private int height;

    public Apple(String color) {
        this.color = color;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        return inventory.stream().filter(apple -> predicate.test(apple)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green"), new Apple("blue"));
        List<Apple> result = filterApples(inventory, (Apple apple) -> "blue".equals(apple.getColor()));

        assert result.size() == 1;
        assert result.get(0).getColor().equals("blue");
    }

}
