package com.pcg.leetCode;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;
import com.pcg.utils.TreeOperation;

/**
 * leetCode 二叉树相关题目
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/8:58 上午
 */
public class BinaryTree {

    public static void main(String[] args) {
        //翻转二叉树 226
        //initInvertTree();
        //打印二叉树最大深度  104
        //initMaxDepth();
        //将数组变为二叉树中序遍历 94
        //inorderTraversal();
        //比对二叉树是否相等 100
        //initIsSameTree();



    }

    /**
     * 初始化翻转二叉树参数
     */
    private static void initInvertTree(){
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("******翻转前******");
        TreeOperation.show(root);
        invertTree(root);
        System.out.println("******翻转后******");
        TreeOperation.show(root);
        //三种遍历方式打印二叉树
        TreeNode.printOrder(root);
    }

    /**
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * @param root 二叉树数组：[4,2,7,1,3,6,9]
     * @return 翻转后的二叉树数组：[4,7,2,9,6,3,1]
     */
    private static void invertTree(TreeNode root){

        if (root == null) {
            return;
        }

        /*****前序遍历  start******/
        //交换左右节点
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        invertTree(root.left);
//        invertTree(root.right);
        /*****前序遍历 end******/
        /*****中序遍历 start******/
        invertTree(root.left);
        //交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //由于已经交换过，所以此时的左节点其实是右节点
        invertTree(root.left);
        /*****中序遍历 end******/
        /*****后序遍历 start******/
//        invertTree(root.left);
//        invertTree(root.right);
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
        /*****后序遍历 end******/
    }

    /**
     * 初始化最大深度二叉树信息，并进行打印
     */
    private static void initMaxDepth(){
        Integer[] nums = {4,2,7,null,null,6,9};
        TreeNode root = ConstructTree.constructTree(nums);
        int depth = maxDepth(root);
        System.out.println("该二叉树最大深度为：" + depth);
        TreeNode.printOrder(root);
    }

    /**
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 求二叉树最大深度
     * @param root 二叉树对象
     */
    private static int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 把二叉树进行中序遍历
     */
    private static void inorderTraversal(){
        Integer[] nums = {1,null,2,3};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeNode.printOrder(root);
    }

    /**
     * 初始化判断树的数据
     */
    private static void initIsSameTree(){
        /**    p              q
         *     1              1
         *   /   \          /   \
         *  2     3        2     3
         */
        /******深度为2的完全二叉树相等情况******/
//        Integer[] pArray = {1,2,3};
//        Integer[] qArray = {1,2,3};

        /**    p              q
         *     1              1
         *   /   \          /   \
         *  2     3        3     2
         */
        /******深度为2的完全二叉树不相等情况******/
//        Integer[] pArray = {1,2,3};
//        Integer[] qArray = {1,3,2};

        /**    p              q
         *     1              1
         *   /                  \
         *  2                    2
         */
        /******深度为2的不完全二叉树不相等情况******/
        Integer[] pArray = {1,2};
        Integer[] qArray = {1,null,2};

        TreeNode p = ConstructTree.constructTree(pArray);
        TreeNode q = ConstructTree.constructTree(qArray);
        boolean sameTree = isSameTree(p, q);
        System.out.println("p树是否等于q树：" + sameTree);
        System.out.println("===========p树start=============");
        TreeNode.printOrder(p);
        System.out.println("\n===========p树end=============");
        System.out.println("===========q树start=============");
        TreeNode.printOrder(q);
        System.out.println("\n===========q树end=============");

    }

    /**
     * 判断树p和树q结构是否完全一样
     * @param p 树p
     * @param q 树q
     * @return
     */
    private static boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        //如果节点相等，判断子树节点是否相等
        if(p.val == q.val){
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        } else {
            return false;
        }


    }
}
