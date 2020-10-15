package com.lwj.summary;

import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryOperate {

    /**
     * 把二叉树的所有节点都加一
     * @param root
     */
    void plusOne(TreeNode root) {
        if(root == null) {
            return;
        }
        root.val += 1;
        plusOne(root.left);
        plusOne(root.right);
    }

    /**
     * 判断两棵树是否相等
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    private boolean flag = true;
    /**
     * 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    /**
     * 求树的高度
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if(root == null || !flag) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(right - left) > 1) {
            flag = false;
        }
        return 1 + Math.max(left, right);
    }

    /**
     * 判断是否是一颗二叉搜索树
     * @param root
     * @return
     */
    public boolean isBinaryTree(TreeNode root) {
        return helpJudgeBinaryTree(root, null,  null);
    }

    /**
     * 协助判断是否是一颗二叉搜索树
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean helpJudgeBinaryTree(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return helpJudgeBinaryTree(root.left, min, max)
                && helpJudgeBinaryTree(root.right, min, max);
    }

    /**
     * 查找某个值是否在树中
     * @param root
     * @param target
     * @return
     */
    public boolean searchInBinaryTree(TreeNode root, int target) {
        if(root == null) return false;
        if(root.val == target) return true;
        if(root.val < target) {
            return searchInBinaryTree(root.right, target);
        } else if(root.val > target) {
            return searchInBinaryTree(root.left, target);
        }
        return false;
    }

    /**
     * 向平衡二叉树中插入一个节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertBinaryTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val) {
            root.right = insertBinaryTree(root.right, val);
        }
        if(root.val > val) {
            root.left = insertBinaryTree(root.left, val);
        }
        return root;
    }

    /**
     * 删除二叉搜索树的一个节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteTreeNode(TreeNode root, int key) {
        if (root == null) return null;
        if(root.val == key) {
            // 这两个if 处理删除节点只有一子节点的情况
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            // 被删除节点存在左右子节点，需要找到最小的节点来替换子节点
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteTreeNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteTreeNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteTreeNode(root.left, key);
        }
        return root;
    }

    /**
     * 获取二叉搜索树的最小节点
     * @param root
     * @return
     */
    private TreeNode getMinNode(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 根据前序遍历和中序遍历构建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helpBuildTree(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
    }
    private TreeNode helpBuildTree(int leftPre, int rightPre, int[] pre, int leftIn, int rightIn, int[] in) {
        if(leftPre > rightPre || leftIn > rightIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[leftPre]);
        int rootIn = leftIn;
        while(rootIn < rightIn && in[rootIn] != pre[leftPre]) {
            rootIn++;
        }
        int left = rootIn - leftIn;
        root.left = helpBuildTree(leftPre+1, rightPre + left, pre, leftIn, rootIn - 1, in);
        root.right = helpBuildTree(leftPre+left+1, rightPre, pre, rootIn+1, rightIn, in);
        return root;
    }

    /**
     * 计算普通二叉树的节点个数
     * @param root
     * @return
     */
    public int countTreeNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countTreeNodes(root.left) + countTreeNodes(root.right);
    }

    /**
     * 计算满二叉树的节点个数，2^h - 1个
     * @param root
     * @return
     */
    public int countFullTreeNodes(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.left;
            h++;
        }
        // 满二叉树的节点个数为2^h - 1
        return (int) Math.pow(2, h) - 1;
    }

    /**
     * 计算完全二叉树的节点个数
     * 时间复杂度为 O(logN * logN);
     * @param root
     * @return
     */
    public int countCompleteTreeNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int l_height = 0;
        int r_height = 0;
        while(l != null) {
            l = l.left;
            l_height++;
        }
        while(r != null) {
            r = r.right;
            r_height++;
        }

        // 如果左右子树高度相同，则是一颗满二叉树
        if(l_height == r_height) {
            return (int) Math.pow(2, r_height) - 1;
        }
        // 如果左右子树的高度不同，则直接按照普通二叉树的方式计算总节点
        return 1 + countCompleteTreeNodes(root.left) + countCompleteTreeNodes(root.right);
    }

    /**
     * 树的遍历
     */
    /**
     * 递归实现二叉树的先序遍历
     * @param root
     * @param list
     */
    public void preOrder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
    /**
     * 递归实现二叉树的中序遍历
     * @param root
     * @param list
     */
    public void inOrder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            inOrder(root.left, list);
            list.add(root);
            inOrder(root.right, list);
        }
    }
    /**
     * 递归实现二叉树的后序遍历
     * @param root
     * @param list
     */
    public void postOrder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root);
        }
    }


    private List<Integer> preList = new ArrayList<>();
    /**
     * 使用栈结构实现二叉树的非递归先序遍历，每次先把最左边的节点入栈，
     * 然后出栈更新 root 节点
     * @param root
     */
    public void preOrderWithIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                preList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    private List<Integer> inList = new ArrayList<>();
    /**
     * 使用栈结构实现二叉树的非递归中序遍历，每次先把最左边的节点入栈，
     * 然后出栈更新 root 节点 为右子节点
     * @param root
     */
    public void inOrderWithIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                inList.add(root.val);
                root = root.right;
            }
        }
    }

    private List<Integer> postList = new ArrayList<>();
    /**
     * 使用栈结构实现二叉树的非递归后序遍历，每次先把最左边的节点入栈，
     * 然后出栈更新 root 节点 为右子节点
     * @param root
     */
    public void postOrderWithIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            boolean flag = true;
            TreeNode preNode = null; // 设置一个前驱节点
            while (!stack.isEmpty() && flag) {
                root = stack.peek();
                if (root.right == preNode) { // 如果之前访问的是空节点或是栈顶节点的右子节点
                    root = stack.pop();
                    postList.add(root.val);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = root;
                    }
                } else {
                    root = root.right;
                    flag = false;
                }
            }
        }
    }

    /**
     * 接下来的几个方法都是剑指offer 上的关于二叉树的一些题
     * @author LWj
     * @apiNote 没事多刷刷题
     */

    /**
     * 返回一颗二叉树的镜像
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }
    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 判断一棵树是否是一个对称的二叉树
     * @param root
     * @return
     */
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helpJudgeSymmetrical(root.left, root.right);
    }
    private boolean helpJudgeSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return helpJudgeSymmetrical(root1.left, root2.right) && helpJudgeSymmetrical(root1.right, root2.left);
    }

    /**
     * @author LWJ
     * @description 接下来几个操作是 二叉树的各种打印
     */

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
     * @param root
     * @return
     */
    public List<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if(node == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return res;
    }

    /**
     * 按照层序打印。每层从左到右
     * @param root
     * @return
     */
    public List<List<Integer>> printWithFloor(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                res.add(list);
            }
        }
        return res;
    }

    public List<List<Integer>> printLikeZModel(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if (list.size() != 0) {
                res.add(list);
            }
        }
        return res;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 假设输入的数组的任意两个数字都互不相同
     * @param sequence
     * @return
     */
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if(last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int currIndex = first;
        while (currIndex < last && sequence[currIndex] <= rootVal) {
            currIndex++;
        }
        for (int i = currIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, currIndex - 1) && verify(sequence, currIndex, last - 1);
    }

    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root
     * @param target
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findPath(TreeNode root, int target) {
        backTracing(root, target, new ArrayList<>());
        return res;
    }

    private void backTracing(TreeNode node, int target, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            backTracing(node.left, target, path);
            backTracing(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点
     * 求二叉树的第 k 个节点, 利用中序遍历有序的思路
     * @param root
     * @return
     */
    private TreeNode res_node;
    private int count;
    public TreeNode kthNode(TreeNode root, int k) {
        inOrder(root, k);
        return res_node;
    }
    private void inOrder(TreeNode root, int k) {
        if(root == null || count >= k) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            res_node = root;
        }
        inOrder(root.right, k);
    }

    /**
     * 找到二叉搜索树的任意两个节点的差值最小的两个节点的差值
     * @param root
     * @return
     */
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;
    public int minDiffBST(TreeNode root) {
        minOrder(root);
        return minDiff;
    }

    private void minOrder(TreeNode root) {
        if (root == null) return;
        minOrder(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;
        minOrder(root.right);
    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例 1:
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
     *
     * 返回移除了所有不包含 1 的子树的原二叉树。
     *
     * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }
    }

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = root.left;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return getSum(root);
    }

    private int getSum(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeaf(root.left) ? root.left.val : getSum(root.left);
        }
        if (root.right != null && !isLeaf(root.right)) {
            ans += getSum(root.right);
        }
        return ans;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     *
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        helpFind(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res1.get(i);
        }
        return ans;
    }
    int count1 = 0;
    int max = -1;
    int preVal = -1;
    List<Integer> res1 = new ArrayList<>();
    private void helpFind(TreeNode root) {
        if (root == null) return;
        helpFind(root.left);
        if (root.val == preVal) {
            count1++;
        } else {
            count1 = 1;
            preVal = root.val;
        }
        if (count1 > max) {
            max = count;
            res1.clear();
            res1.add(preVal);
        } else if (count1 == max) {
            res1.add(preVal);
        }
        helpFind(root.right);
    }
}
