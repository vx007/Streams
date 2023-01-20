import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Task 1
        List<String> list = List.of("Test", "Tes", "TestTest", "TestTestTest");
        Comparator<String> comparator = Comparator.comparing(String::length);
        BiConsumer<String, String> biConsumer = (min, max) -> System.out.println("min=" + min + " max=" + max);

        findMinMax(list.stream(), comparator, biConsumer);

        // Task 2
        findEven(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> temp = stream.toList();
        minMaxConsumer.accept(
                temp.stream().min(order).orElse(null),
                temp.stream().max(order).orElse(null));
    }

    public static void findEven(List<Integer> list) {
        System.out.println(list.stream()
                .filter(i -> i % 2 == 0)
                .count());

    }
}
