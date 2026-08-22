package Review;

import java.io.*;
import java.util.StringTokenizer;

/**
 * P2249 【深基13.例1】查找
 * @author StarLeaf-Roxy
 * @since 2026/8/22
 */
public class P2249 {
    // 快读模板
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    // 读取下一个整数
    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }


    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // 切换为快读模板
        int n = nextInt();
        int m = nextInt();

        // 读取n个数
        // st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0;i < n;i ++) {
            num[i] = nextInt();
        }

        // 读取m次询问
        // int[] answer = new int[m];   节省内存开销 不然MLE
        for (int i = 0;i < m; i++) {
            int ans = -1;
            int q = nextInt();
            int l = 0, r = n - 1;
            // 二分查找模板
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (num[mid] > q) {
                    r = mid - 1;
                } else if (num[mid] < q) {
                    l = mid + 1;
                } else {
                    ans = mid + 1;
                    r = mid - 1; // 保证第一个位置
                }
            }
            out.print(ans);
            if (i != m - 1) out.print(' ');
        }

        out.flush();
        br.close();
    }
}
