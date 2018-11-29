package one.src.part2.behaviorparameterization.lambda;

import one.src.part2.behaviorparameterization.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

/**
 * @author One
 * @description
 * @date 2018/11/29
 */
public class LambdaExpressionLab {
    public static void main(String[] args) throws IOException {
        Predicate<List<String>> filter = (List<String> list) -> list.isEmpty();

        Runnable black = () -> new Apple("black", 21);

        Consumer<Apple> consumer = (Apple a) -> {
            System.out.println(a);
        };

        Consumer<String> stringConsumer = (String s) -> s.length();

        IntBinaryOperator operator = (int a, int b) -> a * b;

        Runnable r1 = () -> System.out.println("hello,word1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,word2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("hello,word3"));

        System.out.println("exp3");

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/MrAlien/Nustore " +
                "Files/One/OpenSource/Java8-actions/resource/data.txt"))) {
            String s = processFile(reader, reader1 -> reader1.readLine() + "-" + reader1.readLine());
            System.out.println(s);
        }

        System.out.println("exp4");
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 7);
        forEach(list, (i) -> System.out.println("integer: " + i));
    }

    public static void process(Runnable target) {
        target.run();
    }

    public static String processFile(BufferedReader reader, BufferdReaderProcessor processor) {
        try {
            return processor.process(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

}
