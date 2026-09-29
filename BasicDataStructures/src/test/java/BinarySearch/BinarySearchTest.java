package BinarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.Returns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * @author Roxy(StarLeaf)
 * @since 2026/8/20
 */

public class BinarySearchTest {
    private static final Logger log = LoggerFactory.getLogger(BinarySearchTest.class);

    @Test
    public void testBinarySearch() {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;

        int m = (i + j) / 2;

        // 发现这一次计算没有问题
        // 第一次中间值：1073741823 大概就是整数值的一半
        log.info("第一次中间值：{}", m);

        // 然后假设我们要找的值在m的右侧 那么i向右移动 进一步计算中间值
        i = m + 1;
        m = (i + j) / 2;
        // 这里移动后 计算就出现了问题： 第二次中间值：-536870913
        log.info("第二次中间值：{}", m);

        // 解决： 用无符号右移运算符解决
        m = (i + j) >>> 1; // 可以相当于移动的是二进制位数 移动后将Java变成负数又给移动成正整数了
        // 第三次中间值：1610612735
        log.info("第三次中间值：{}", m);
    }

    @Test
    @DisplayName("binary search Java 版")
    public void test1() {
        int[] a = {2, 5, 8};
        int target = 4;

        int i = Arrays.binarySearch(a, target);
        System.out.println(i);
        // 这里我们给他肯定找不到的值 打印出来结果是-2
        // -2 = 插入点-1
        // -2 + 1 = 插入点 这样的设计是为了 将来要插入到这个有序的数组中 插入的位置是什么
        // 这里就计算出来插入到索引1的位置

        if (i < 0) {
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }

    /**
     * 二分查找 LeftMost
     *
     * Params: a - 待查找的升序数组
     *         target - 待查找的目标值
     * Returns:
     *       找到则返回索引
     *       找不到则返回 -1
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] > target) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                // 将j往左靠
                j = m - 1;
            }
        }
        return candidate;
    }

    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                i = m + 1;	   // 继续向右
            }
        }
        return candidate;
    }

    public static int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static int binarySearchRightmost2(int[] a,int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }
}
