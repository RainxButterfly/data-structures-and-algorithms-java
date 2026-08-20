package BinarySearch;

/**
 *
 * @author Roxy(StarLeaf)
 * @since 2026/8/20
 */
public class BinarySearch {

    /**
     * 二分查找基础版
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引
     *         找不到返回 -1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1; // 创建两个指针并且初始化值
        while (i <= j) {
            int m = (i + j) / 2;
            if (a[m] < target) {
                i = m + 1;
            } else if (a[m] > target) {
                j = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 输出结果：
    // 4
    // Time: 1ms
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long start = System.currentTimeMillis();
        System.out.println(binarySearchBasic(a, 5));
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
