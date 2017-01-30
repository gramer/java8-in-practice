package lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("fast")
class AppleTestByJUnit5 {

    @Test
    @DisplayName("FilterApplesByColor")
    void filterApplesByColor() {
        List<Apple> inventory = Arrays.asList(new Apple("green"), new Apple("blue"));
        List<Apple> result = Apple.filterApplesByColor(inventory, "blue");
        assertEquals("blue", result.get(0).getColor());
    }

    @Test
    @DisplayName("SortByMethodReference")
    void sortByMethodReference() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 20), new Apple("blue", 10));
        inventory.sort(comparing(Apple::getHeight));
        assertEquals("blue", inventory.get(0).getColor());
    }

    @Test
    @DisplayName("SortReverseByMethodReference")
    void sortReverseByMethodReference() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 20), new Apple("blue", 10));
        inventory.sort(comparing(Apple::getHeight).reversed());
        assertEquals("green", inventory.get(0).getColor());
    }

}