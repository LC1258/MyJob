package com.lwj.summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间操作
 */

public class Merge {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        int len = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] < pre[1]) {
                pre[1] = Math.max(pre[1], intervals[i][1]);
            } else {
                list.add(pre);
                pre = intervals[i];
            }
        }
        list.add(pre);
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
     *
     * 返回这两个区间列表的交集。
     *
     * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，
     * 要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interval-list-intersections
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (b2 >= a1 && a2 >= b1) {
                list.add(new int[] {Math.max(a1, b1), Math.min(a2,b2)});
            }
            if (b2 < a2) {
                j += 1;
            } else {
                i += 1;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，
     * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     *
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     *
     * 说明:
     * 不允许旋转信封。
     *
     * 示例:
     *
     * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出: 3
     * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        // 先将信封按照宽度升序排序，如果宽度相同，按照高度降序排序
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    private int lengthOfLIS(int[] height) {
        int len = height.length;
        int[] top = new int[len];
        int piles = 0;
        for (int i = 0; i < len; i++) {
            int poker = height[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }
}
