package one.src.part2.behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author One
 * @description 行为参数化
 * @date 2018/11/29
 */
public class Lab1 {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red", 15));
        apples.add(new Apple("white", 25));
        apples.add(new Apple("bule", 35));

        prettyPrintApple(apples, new XmlPrint());
        prettyPrintApple(apples, new JosnPrint());

        // 内部类方式
        prettyPrintApple(apples, new PrintObject() {
            @Override
            public String toPrint(Apple apple) {
                return "A " + apple.getColor() + " apple" + " of " + apple.getWeight();
            }
        });

        prettyPrintApple(apples, (Apple apple) -> "A " + apple.getColor() + " apple" + " of " + apple.getWeight());
        System.out.println("===========================");

        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        List<Integer> filter = filter(nums, (integer -> integer % 2 == 0));
        System.out.println(filter);
    }

    public static void prettyPrintApple(List<Apple> inventory, PrintObject printObject) {
        for (Apple apple : inventory) {
            String output = printObject.toPrint(apple);
            System.out.println(output);
        }
    }

    interface Predicate<T> {
        boolean test(T t);
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

interface PrintObject {
    String toPrint(Apple apple);
}

class XmlPrint implements PrintObject {
    @Override
    public String toPrint(Apple apple) {
        return "<" + apple.getColor() + "," + apple.getWeight() + ">";
    }
}

class JosnPrint implements PrintObject {
    @Override
    public String toPrint(Apple apple) {
        return "{" + apple.getColor() + "," + apple.getWeight() + "}";
    }
}

