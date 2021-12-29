package com.pcg.leetCode;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;
import com.pcg.utils.TreeOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //initSortedArrayToBST();
        //是否是高度平衡的二叉树 110
        //initIsBalanced();
        //二叉树最小深度 111
        //initMinDepth();
        //开幕式烟火 LCP44
        //initNumColor();
        //二叉树前序遍历 144
        //initPreorderTraversal();
        //二叉树后序遍历 145
        //initPostorderTraversal();



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
    private static TreeNode helper(Integer[] nums, int left, int right) {
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

    /**
     * 初始化是否高度平衡二叉树数据
     */
    private static void initIsBalanced(){
//        Integer[] nums = {1,2,2,3,3,null,null,4,4}; //false
        Integer[] nums = {3,9,20,null,null,15,7};   //true
        TreeNode root = ConstructTree.constructTree(nums);
        TreeNode.printOrder(root);
        System.out.println("\n是否为高度平衡二叉树：" + isBalanced(root));
    }

    /**
     * 判断是否为高度平衡二叉树
     * @param root 二叉树对象
     * @return
     */
    private static boolean isBalanced(TreeNode root){
        //方案一
        //height1(root);
        //return isBalanced;

        //方案二（方案一精简结构后的结果）
        return height2(root) >= 0;
    }
    //方案一
    private static boolean isBalanced = true;

    /**
     * 方案一
     * @param root
     * @return
     */
    public static int height1(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(!isBalanced){
            //仅是结束递归，无特殊意义
            return 0;
        }
        //计算最大高度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //如果高度超过1，则非平衡二叉树
        if (Math.abs(right - left) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 方案二：方案一精简结构得出
     * @param root
     * @return
     */
    private static int height2(TreeNode root){
        if(root == null) {
            return 0;
        }
        //计算最大高度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //如果高度超过1，则非平衡二叉树
        if (Math.abs(right - left) > 1 || left < 0 || right <0 ) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 初始化计算最小深度数据
     */
    private static void initMinDepth(){
//        Integer[] nums = {3,9,20,null,null,15,7}; //最小深度为2
        Integer[] nums = {2,null,3,null,4,null,5,null,6}; //最小深度为5
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("二叉树最小深度为：" + minDepth(root));
        TreeNode.printOrder(root);
    }

    /**
     * 与求最大路径相反，不过要注意过滤空节点
     * @param root
     * @return
     */
    private static int minDepth(TreeNode root){
        return depMin(root);
    }

    /**
     * 先序遍历递归查询二叉树
     * @param root
     * @return
     */
    private static int depMin(TreeNode root){
        if(root == null) {
            return 0;
        }

        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + depMin(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + depMin(root.left);
        }

        //计算最小高度
        int left = depMin(root.left);
        int right = depMin(root.right);
        return Math.min(left, right) + 1;
    }

    /**
     * 初始化开幕式烟火数据
     * 力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
     * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
     */
    private static void initNumColor(){
//        Integer[] nums = {3,3,3}; //颜色为1
        Integer[] nums = {1,3,2,1,null,2}; //颜色为3 为：1、2、3
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("烟火颜色为：" + numColor(root));
        TreeNode.printOrder(root);

    }

    //HashSet集合的特点是重复，所以把所有节点存入HashSet，然后求长度就是颜色种类
    //先序、中序、后序遍历均可
    private static Set<Integer> set = new HashSet<>();
    private static int numColor(TreeNode root) {
        dfs(root);
        return set.size();

    }
    private static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        //先序遍历
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 初始化前序遍历数据
     */
    private static void initPreorderTraversal(){
        Integer[] nums = {1,null,2,3};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("前序遍历结果为：" + preorderTraversal(root));
    }
    /**
     * 前序遍历
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> nums = new ArrayList<>();
        preOrder(root,nums);
        return nums;

    }
    private static void preOrder(TreeNode root, List<Integer> nums){
        if(root == null) {
            return;
        }
        nums.add(root.val);
        preOrder(root.left, nums);
        preOrder(root.right, nums);
    }

    /**
     * 初始化后序遍历
     */
    private static void initPostorderTraversal(){
        Integer[] nums = {1,null,2,3};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("后序遍历结果为：" + postorderTraversal(root));
    }
    /**
     * 后序遍历
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        postOrder(root,nums);
        return nums;

    }
    private static void postOrder(TreeNode root, List<Integer> nums){
        if(root == null) {
            return;
        }
        postOrder(root.left, nums);
        postOrder(root.right, nums);
        nums.add(root.val);
    }
}
