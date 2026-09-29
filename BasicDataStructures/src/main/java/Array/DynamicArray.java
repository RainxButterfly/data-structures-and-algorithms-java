package Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 * @author StarLeaf-Roxy
 * @since 2026/9/20
 */
public class DynamicArray implements Iterable<Integer>{
    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量大小
    private int[] array = {};

    /**
     * 向最后位置[size]添加元素
     * Params：element-待添加元素
     */
    public void addLast(int element) {
        // array[size] = element;
        // size++;
        add(size, element);
    }

    /**
     * 向[0..size]位置添加元素
     * Params: index - 索引位置
     *         element - 待添加元素
     */
    public void add(int index, int element) {
        checkAndGrow();
        if (index >= 0 && index < size) {
            // 首先需要将index之后的都进行往后移动一位 那么就是拷贝到当前位置的下一个位置
            // 哪一个数组的哪一个位置复制到哪一个复制的哪一个起始位置 复制多少个
            System.arraycopy(array, index, array, index + 1, size - index);
            // array[index] = element;
            // size++;
        }
        // }
        // else if (index == size) {
        //     array[index] = element;
        //     size++;
        // }
        // 上面的无论如何都有添加元素以及size++的操作 于是可以进行一个合并
        array[index] = element;
        size++;
    }

    /**
     * 查询元素
     *
     * @param index 索引位置, 在 [0..size) 区间内
     * @return 该索引位置的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return array[index];
    }

    /**
     * 遍历方法1
     *
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0;i < size;i ++) {
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方法2 - 迭代器遍历
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            // 询问是否有下一个
            @Override
            public boolean hasNext() {
                return i < size;
            }

            // 获取下一个文件并且将位置往后移一位
            @Override
            public Integer next() {
                return array[i ++];
            }
        };
    }

    /**
     * 遍历方法3 - stream 遍历
     *
     * @return stream 流
     */
    public IntStream stream() {
        // 他是开区间 所以size不包含
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    /**
     * 从 [0 .. size) 范围删除元素
     *
     * @param index 索引位置
     * @return 被删除元素
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    public void checkAndGrow() {
        // 容量检查
        if (size == 0) {
            // 如果size为0 那么进行一个初始化容量
            array = new int[capacity];
        } else if (size == capacity) {
            // 如果当前的size大小已经等于数组的容量了 那么进行扩容
            // 扩容大小为当前的1.5倍数 也就是 1 + 0.5 就是1.5倍了
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }


}
