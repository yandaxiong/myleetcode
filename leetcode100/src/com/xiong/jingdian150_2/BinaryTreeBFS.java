package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-09-04-20:52
 */
import java.util.*;

public class BinaryTreeBFS {

    /**
     * 广度优先搜索 (BFS) - 层序遍历
     * 返回所有节点值的列表，按层从上到下、从左到右访问
     *
     * @param root 二叉树的根节点
     * @return 包含所有节点值的列表
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 如果根节点为空，直接返回空列表
        if (root == null) {
            return result;
        }

        // 使用队列存储待访问的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 将根节点加入队列

        while (!queue.isEmpty()) {
            // 从队列中取出一个节点（先进先出）
            TreeNode node = queue.poll();

            // 访问当前节点：将其值加入结果列表
            result.add(node.val);

            // 将当前节点的左子节点加入队列（如果存在）
            if (node.left != null) {
                queue.offer(node.left);
            }

            // 将当前节点的右子节点加入队列（如果存在）
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }

    // ---------------------- 测试代码 ----------------------

    public static void main(String[] args) {
        BinaryTreeBFS solution = new BinaryTreeBFS();

        // 构建测试二叉树:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 执行BFS遍历
        List<Integer> bfsResult = solution.bfs(root);

        // 输出结果
        System.out.println("BFS (层序遍历) 结果: " + bfsResult);
        // 预期输出: [3, 9, 20, 15, 7]
    }
}
