package com.pcg.leetCode.Bean;

import com.pcg.utils.TreeOperation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/9:44 上午
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 将二叉树以先序遍历打印
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 将二叉树以中序遍历打印
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 将二叉树以先序遍历打印
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     *
     * @param root
     * @param type 1：只输出树形结构
     *             2：只输出先序遍历
     *             3：只输出中序遍历
     *             4：只输出后序遍历
     *             5：只输出三种遍历
     *             6：全部输出
     */
    public static void printOrder(TreeNode root, int type){
        switch (type){
            case 1:
                System.out.println("******树形结构******");
                TreeOperation.show(root);
                break;
            case 2:
                System.out.println("******先序遍历******");
                TreeNode.preOrder(root);
                break;
            case 3:
                TreeNode.preOrder(root);
                System.out.println("\n******中序遍历******");
                break;
            case 4:
                System.out.println("\n******后序遍历******");
                TreeNode.postOrder(root);
                break;
            case 5:
                System.out.println("******先序遍历******");
                TreeNode.preOrder(root);
                System.out.println("\n******中序遍历******");
                TreeNode.inOrder(root);
                System.out.println("\n******后序遍历******");
                TreeNode.postOrder(root);
                break;
            case 6:
                System.out.println("******树形结构******");
                TreeOperation.show(root);
                System.out.println("******先序遍历******");
                TreeNode.preOrder(root);
                System.out.println("\n******中序遍历******");
                TreeNode.inOrder(root);
                System.out.println("\n******后序遍历******");
                TreeNode.postOrder(root);
                break;
            default:
                break;
        }

    }

    /**
     * 打印树形结构;
     * 三种遍历方式打印二叉树
     * @param root 二叉树对象
     */
    public static void printOrder(TreeNode root){
        printOrder(root,6);
    }
}
