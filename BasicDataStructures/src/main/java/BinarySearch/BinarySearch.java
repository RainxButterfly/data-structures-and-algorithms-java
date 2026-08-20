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
            int m = (i + j) >>> 2;
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

    /**
     * 问题1：为什么是 i<=j 意味着区间内有未比较的元素，而不是 i < j?
     *    答： i和j他们指向的元素也会参与比较
     *
     * 问题2：(i+j) / 2 有没有问题？
     *    答：有，超过整数值阈值会变成负数，具体在测试案例中
     *
     * 问题3： 为什么代码中都写成小于号，有什么好处？
     *    答： 因为这样写和数组的顺序一样 例如 i < j 一眼看过去就知道i小于j然后 数组中i在j的左侧
     */

    /**
     * 二分查找改动版
     *
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引
     *         找不到返回 -1
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;  // 改动第一处
        while (i < j) { // 改动第二处
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else if (a[m] > target) {
                j = m; // 改动第三处
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
