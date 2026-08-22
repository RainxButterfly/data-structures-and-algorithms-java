package Review;
import java.util.*;
import java.io.*;

/**
 * P2241 统计方形（数据加强版）
 * @author Roxy(StarLeaf)
 * @since 2026/8/22
 */

public class P2241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) {
            return;
        }

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 正方形 长 = 宽
        long square = 0;

        /*
          计算正方形的数量，思路：
          首先k代表的是边长的长度，然后边长长度不超过n和m中最短的
          然后计算公式是(n-k+1) 这个计算横向 首先形状是线条标识 例如n为2 那么有3条线，那么变成假设为2的时候，可以取到的就是第0和第1条的
          位置，如果第2就超过了，而k就卡在这了 而+1是因为线条位置是从0开始算的 左上角的那块要包含进去
         */
        for (int k = 1;k <= Math.min(n, m);k++) {
            square += (long) (n - k + 1) * (m - k + 1);
        }

        /*
          计算长方形的思路： 首先计算出所有矩形的数量，然后矩形的数量减去正方形的数量就是长方形的数量，
          矩形数量为什么等于 长方形数量+正方形数量？ 原因： 因为长方形和正方形成立的条件不一样，所以他们是并的关系，那么
          他们相加在一起就是矩形的数量了。
          矩形数量的计算就是任意横线2条+竖线2条围成的就是矩形了 所以用组合数学C(n+1,2) +1是因为我们是按线条来算的 不是行数
          然后2就是代表取2条 那么就可以计算所有的了 竖线也是如此
         */
        long total = (long) n * (n + 1) / 2 * (long) m * (m + 1) / 2;
        // out.println(square);
        // out.println(total);
        out.println(square + " " + (total-square));
        out.flush();
        br.close();
    }
}
