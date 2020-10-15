package com.lwj.summary;

/**
 * 并查集
 */
public class UnionFind {

    // 记录连通分量
    private int count;

    // 节点 x 的节点是parent[x];
    private int[] parent;

    // 记录树的重量,就是森林里面的两个树 的节点个数
    private int[] size;

    /* 构造函数， n 为图的节点总数*/
    public UnionFind(int n) {
        // 一开始图节点互相不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // p q 节点的父节点相同的话直接返回
        if (rootP == rootQ) {
            return;
        }
        // 解决树不平衡问题
        if (size[rootP] > size[rootQ]) {
            // 否者将两颗树合并为一棵树
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            // 否者将两颗树合并为一棵树
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // 两个分量合为一个分量，总的连通分量减1
        count--;
    }

    /**
     * 返回 x 节点的根节点
     * @param x
     * @return
     */
    private int find(int x) {
        // 根节点的parent[x] = x;
        // 路劲压缩
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 返回当前的连通分量个数
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 判断两个节点是否连通
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}
