package Review;

import java.io.*;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/8/24
 */
public class P1102 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    // 读取下一个整数
    static int nextInt() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        long[] num = new long[n];
        for (int i = 0; i < n; i ++) {
            num[i] = nextInt();
        }

        out.flush();
        br.close();
    }
}
