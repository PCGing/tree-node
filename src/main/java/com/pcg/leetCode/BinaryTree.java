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
        //判断是否为对称二叉树 101
        //initIsSymmetric();
        //将有序数组转为高度平衡二叉搜索树 108
        initSortedArrayToBST();


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

    /**
     * 初始化是否为对称二叉树数据
     */
    private static void initIsSymmetric(){
        /**
         * 对称二叉树
         *       1
         *     /   \
         *   2       2
         *  / \     / \
         * 3   4   4   3
         */
        Integer[] nums = {1,2,2,3,4,4,3};

        /**
         * 不对称二叉树
         *       1
         *     /   \
         *   2       2
         *    \       \
         *     3       3
         */
//        Integer[] nums = {1,2,2,null,3,null,3};

        TreeNode root = ConstructTree.constructTree(nums);
        boolean symmetric = isSymmetric(root);
        System.out.println("是否为对称二叉树：" + symmetric);
        TreeNode.printOrder(root);
    }

    /**
     * 判断是不是对称二叉树
     * @param root 二叉树对象
     * @return
     */
    private static boolean isSymmetric(TreeNode root){
        //如果是空树，则肯定是对称二叉树
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    /**
     * 比对左子树和右子树是否相等
     * @param left 左子树
     * @param right 右子树
     * @return
     */
    private static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return check(left.left, right.right)&&check(left.right, right.left);
    }

    /**
     * 初始化"将有序数组转为高度平衡二叉搜索树"的数据
     */
    private static void initSortedArrayToBST(){
        Integer[] nums = {-10,-3,0,5,9};
        TreeNode beforeTree = ConstructTree.constructTree(nums);
        System.out.println("\n===========转换前=============");
        TreeNode.printOrder(beforeTree);
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("\n===========转换后=============");
        TreeNode.printOrder(root);
    }

    /**
     * 将有序数组转为高度平衡二叉搜索树
     * 思路：
     * 1、因为是升序，并且高度平衡二叉树的中节点肯定是中位数（偶数的话就是中间偏左或者偏右都可以，两种情况都会列举）
     * 2、原理就是记数组长度为[left,right],则中位数（偏左的情况）为(left+right)/2;偏右情况为(left+right+1)/2
     * 3、然后左右子树就继续递归判断中位数，继续生成左右子树
     * @param nums
     * @return
     */
    private static TreeNode sortedArrayToBST(Integer[] nums){
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归查询中位数以及左右子树的中位数
     * @param nums 数组
     * @param left 数组最左下标
     * @param right 数组最右下标
     * @return
     */
    public static TreeNode helper(Integer[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点(整数除法：4/2=2；)
        int mid = (left + right) / 2;
        // 总是选择中间位置右边的数字作为根节点（整数除法：(4+1)/2=2；//舍去小数部分）
        //int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
