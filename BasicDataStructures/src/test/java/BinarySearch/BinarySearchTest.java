package BinarySearch;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
