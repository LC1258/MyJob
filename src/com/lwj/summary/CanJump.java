package com.lwj.summary;

/**
 * leetcode 55 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4};
        boolean res = new CanJump().canJump(nums);
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i  = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);// 更新最远能跳的距离
            // 碰到 0 了，跳不走了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= (n - 1);
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        int n = nums.length;
        int end = 0, farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
