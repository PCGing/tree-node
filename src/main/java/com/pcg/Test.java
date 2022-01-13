package com.pcg;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/3:32 下午
 */
public class Test {
    public static void main(String[] args) {
        Integer[] parts = {1,2,3,4,5,null,6,null,null,7,null,8,9};
        TreeNode root = ConstructTree.constructTree2(parts);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);

    }

    /**
     *              1
     *            /   \
     *          2      3
     *        /   \     \
     *       4     5     6
     *           /      / \
     *          7      8   9
     * @param root
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
