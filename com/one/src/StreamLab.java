package one.src;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamLab
 */
public class StreamLab {

    private List<String> memberNames = null;
    private List<Integer> list = new ArrayList<Integer>();

    @Before
    public void setup() {
        memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
    }

    public static void main(String[] args) {
    }

    @Test
    public void testSteam() {
        Stream<Integer> stream = Stream.of(1, 3, 5, 6, 9, 11, 13);
        stream.forEach(p -> System.out.println(p));

    }

    @Test
    public void testSteam2() {
        Stream<Integer> intStream = list.stream();
        intStream.forEach(p -> System.out.println(p));
    }

    @Test
    public void testGenerate() {
        // generate
        Stream<Date> dateStream = Stream.generate(() -> {
            return new Date();
        });
        dateStream.forEach(p -> System.out.println(p));
    }

    @Test
    public void testString() {
        IntStream chars = "12345_abcdasd".chars();
        chars.forEach(p -> System.out.println(p));

        Stream<String> stringStream = Stream.of("A$b$C".split("\\$"));
        stringStream.forEach(p -> System.out.println(p));
    }

    @Test
    public void testConvertArray() {

        Stream<Integer> stream = list.stream();
        Integer[] integers = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(Arrays.toString(integers));
    }

    @Test
    public void testCoreStream() {
        //只打印 A开头的成员
        memberNames.stream().filter((s)->s.startsWith("A")).forEach(System.out::println);
        /**
         * Amitabh
         * Aman
         */
    }

    @Test
    public void testMap() {
        Stream<String> stream = memberNames.stream();
        stream.filter((s)->s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        /**
         * AMITABH
         * AMAN
         */
    }

    @Test
    public void testSorted() {
        memberNames.stream().sorted().map(String::toUpperCase)
                .forEach(System.out::println);
        /**
         * AMAN
         * AMITABH
         * LOKESH
         * RAHUL
         * SALMAN
         * SHAHRUKH
         * SHEKHAR
         * YANA
         */
    }

    @Test
    public void testCollect() {
        List<String> collect = memberNames.stream().sorted().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect);
        /**
         * [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]
         */
    }

    @Test
    public void testMatch() {
        boolean a = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
        System.out.println(a);
        //true
        a = memberNames.stream().allMatch((s) -> s.startsWith("A"));
        System.out.println(a);
        //false
        a = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
        System.out.println(a);
        //false
    }

    @Test
    public void testCount() {
        long a = memberNames.stream().filter((s) -> s.startsWith("A")).count();
        System.out.println(a);
        // 2
    }

    @Test
    public void testReduce() {
        Optional<String> reduce = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
        reduce.ifPresent(System.out::print);
        //Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh
    }

    @Test
    public void testAnyMatch() {
        boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matched);
        //true
    }

    @Test
    public void testFind() {
        String findFirst = memberNames.stream().filter((s) -> s.startsWith("L"))
                .findFirst().get();
        System.out.println(findFirst);
        //Lokesh
    }

    @Test
    public void testParallel() {
        Stream<Integer> integerStream = list.parallelStream();
        Integer[] integers = integerStream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
        //[2, 4, 6, 8]
    }
}