package one.src;

import org.junit.Test;

import java.util.List;
import java.util.stream.*;

/**
 * @author One
 * @description
 * @date 2018/11/11
 */
public class BoxedSteamLab {
    @Test
    public void collect() {
        List<String> strings = Stream.of("how", "to", "do", "in", "java").collect(Collectors.toList());
        System.out.println(strings);
        //[how, to, do, in, java]
    }

    @Test
    public void testIntStream() {
        List<Integer> ints = IntStream.of(1,2,3,4,5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);
        //[1, 2, 3, 4, 5]
    }

    @Test
    public void testLongStream() {
        List<Long> longs = LongStream.of(1L,2L,3L,4L,5L).boxed().collect(Collectors.toList());
        System.out.println(longs);
        //[1, 2, 3, 4, 5]
    }

    @Test
    public void testDoubleStream() {
        List<Double> collect = DoubleStream.of(1D, 2D, 3.4D, 4.3D).boxed().collect(Collectors.toList());
        System.out.println(collect);
        //[1.0, 2.0, 3.4, 4.3]
    }
}
