package one.src;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author One
 * @description 闭包练习
 * @date 2018/11/11
 */
public class LambdaLab {

    @Test
    public void testDemo() {
        List<String> pointList = new ArrayList();
        pointList.add("1");
        pointList.add("2");
        pointList.forEach(a -> System.out.println(a));
        /**
         * 1
         * 2
         */
    }

    @Test
    public void testRunnable() {
        new Thread(() -> System.out.println("New Runnable")).start();
        //New Runnable
    }

    @Test
    public void testSort() {
        Employee[] employees = {
                new Employee("David"),
                new Employee("Naveen"),
                new Employee("Alex"),
                new Employee("Richard")};
        System.out.println("Before Sorting Names: " + Arrays.toString(employees));
        Arrays.sort(employees,Employee::nameCompare);
        System.out.println(Arrays.toString(employees));
        /**
         * Before Sorting Names: [Employee{name='David'}, Employee{name='Naveen'}, Employee{name='Alex'}, Employee{name='Richard'}]
         * [Employee{name='Alex'}, Employee{name='David'}, Employee{name='Naveen'}, Employee{name='Richard'}]
         */
    }

    private static class Employee {
        private String name;

        Employee(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public static <T> int nameCompare(Employee a1, Employee a2) {
            return a1.name.compareTo(a2.name);
        }
    }
}
