package Array;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/9/20
 */
class DynamicArrayTest {
    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2, 5);
        dynamicArray.foreach((element) -> {
            System.out.println(element);
        });
    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2, 5);
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2, 5);
        dynamicArray.stream().forEach((element) -> {
            System.out.println(element);
        });
    }

    @Test
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2, 5);
        int removed = dynamicArray.remove(2);
        assertEquals(5, removed);
        assertIterableEquals(List.of(1, 2, 3, 4), dynamicArray);
    }

    @Test
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0;i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        assertIterableEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                dynamicArray
        );
    }

    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0;i < rows;i ++) {
            for (int j = 0;j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0;j < columns; j++) {
            for (int i = 0;i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    @Test
    public void test6() {
        int rows = 1000000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();
        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();
        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}