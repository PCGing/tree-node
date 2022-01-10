package com.pcg.leetCode;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;
import com.pcg.utils.TreeOperation;

import java.util.*;

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
        //路径总和 112
        //initHasPathSum();
        //二叉搜索树的最近祖先 235
        //initLowestCommonAncestor();
        //获取二叉树所有路径 257
        //initBinaryTreePaths();
        //计算所有左叶子节点之和 404
        //initSumOfLeftLeaves();
        //计算二叉搜索树不同节点之间最小差值 530
        //initGetMinimumDifference();
        //二叉树的直径（可以不过根节点） 543
        //initDiameterOfBinaryTree();
        //二叉搜索树的众数 501
        //initFindMode();
        //二叉树的坡度 563
        initFindTilt();



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

    /**
     * 初始化数据
     */
    private static void initHasPathSum(){
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println("是否有路径上所有节点值相加等于targetSum：" + hasPathSum(root, targetSum));
        TreeNode.printOrder(root);

    }
    /**
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum。
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum。
     * 如果存在，返回 true ；否则，返回 false
     * @param root
     * @param targetSum
     * @return
     */
    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        //由于left和right都为Object，所以只有为null时才会相等，即此时为叶子结点
        if(root.left == root.right && root.val == targetSum){
            return true;
        }
        //每到下个层级，就把上个层级的值减掉
        return hasPathSum(root.left, (targetSum - root.val)) || hasPathSum(root.right,(targetSum - root.val));
    }

    /**
     * 初始化数据
     * 求p节点和q节点的最近公共祖先
     */
    private static void initLowestCommonAncestor(){
        Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = ConstructTree.constructTree(nums);

        Integer[] pNums = {2};
        TreeNode p = ConstructTree.constructTree(pNums);

        Integer[] qNums = {8};
        TreeNode q = ConstructTree.constructTree(qNums);

        TreeNode parentNode = lowestCommonAncestor(root, p, q);
        System.out.println(p.val + "和" + q.val + "的最近公共祖先为：" + parentNode.val);
        TreeNode.printOrder(root);
    }
    /**
     * 找到二叉搜索树中两个指定节点的最近公共祖先。
     * 公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @param root 二叉搜索树（无重复值）
     * @param p 节点p
     * @param q 节点q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        //保证p在左子树，q在右子树
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }
        //如果分别在左右子树，那么当前节点就是他们的公众祖先
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }
        //都在左子树
        if(root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
            //都在右子树
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    /**
     * 初始化数据
     */
    private static void initBinaryTreePaths(){
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree(nums);
        List<String> paths = binaryTreePaths(root);
        System.out.println("从跟节点到叶子节点到路径列表为：" + paths);
        TreeNode.printOrder(root);
    }

    /**
     * 按 任意顺序 ，返回所有从根节点到叶子节点的路径
     * @param root 二叉树对象
     * @return 所有路径集合
     */
    private static List<String> binaryTreePaths(TreeNode root){
        traverse(root);
        return res;
    }
    //存放路径
    private static LinkedList<String> path = new LinkedList<>();
    //存放最终输出
    private static LinkedList<String> res = new LinkedList<>();
    private static void traverse(TreeNode root){
        if(root == null){
            return;
        }
        //如果左右子树都为null，则证明是叶子结点
        //所以进行拼接节点+转换为路径的形式
        if(root.left == null && root.right == null){
            path.addLast(root.val + "");
            res.addLast(String.join("->", path));
            path.removeLast();
            return;
        }

        //前序遍历存放值
        path.addLast(root.val + "");
        traverse(root.left);
        traverse(root.right);
        //后序遍历清空List
        path.removeLast();
    }

    /**
     * 初始化数据
     */
    private static void initSumOfLeftLeaves(){
        Integer[] parts = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree2(parts);
        System.out.println("左叶子节点之和为：" + sumOfLeftLeaves(root));
        TreeNode.printOrder(root);
    }
    /**
     * 计算给定二叉树的所有左叶子之和
     * @param root
     * @return
     */
    private static int sumOfLeftLeaves(TreeNode root) {
        //根节点不能是叶子节点
        leftLeaves(root,1);
        return sum;
    }
    //左叶子节点之和
    private static int sum = 0;
    //二叉树对象和是否为左子树
    private static void leftLeaves(TreeNode root, int leftFlg){
        if(root == null) {
            return;
        }
        //判断是否为左叶子节点
        if(root.left == null && root.right == null && leftFlg == 0){
            sum += root.val;
        }
        leftLeaves(root.left, 0);
        leftLeaves(root.right, 1);
    }

    /**
     * 初始化数据
     */
    private static void initGetMinimumDifference(){
        Integer[] parts = {1,0,48,null,null,12,49};
        TreeNode root = ConstructTree.constructTree2(parts);
        int min = getMinimumDifference(root);
        System.out.println("该二叉搜索树中，节点之间最小差值为：" + min);
        TreeNode.printOrder(root);
    }

    /**
     * 计算二叉搜索树节点之间最小差值
     * @param root
     * @return
     */
    private static int getMinimumDifference(TreeNode root) {
        traversal(root);
        return res1;
    }
    //当前最小差值，默认为最大int值
    private static int res1 = Integer.MAX_VALUE;
    //上一个节点
    private static TreeNode prev = null;
    private static void traversal(TreeNode root){
        if(root == null) {
            return;
        }
        traversal(root.left);
        //中序遍历
        if(prev != null){
            res1 = Math.min(res1, root.val - prev.val);
        }
        prev = root;
        traversal(root.right);
    }

    /**
     * 初始化数据
     */
    private static void initDiameterOfBinaryTree(){
        //本二叉树左右子树深度之和小与右子树某节点左右子树之和
        Integer[] parts = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        //正常二叉树
        //Integer[] parts = {1,2,3,4,5};

        TreeNode root = ConstructTree.constructTree2(parts);
        System.out.println("该二叉树最大直径为：" + diameterOfBinaryTree(root));
        TreeNode.printOrder(root);


    }

    //最大深度，初始化为0
    private static int maxDiameter = 0;

    /**
     * 计算二叉树任意两个结点路径长度中的最大值（可以不过跟节点）
     * @param root
     * @return
     */
    private static int diameterOfBinaryTree(TreeNode root){
        maxDepth1(root);
        return maxDiameter;
    }

    /**
     *在后序遍历中获取各节点左右子树深度之和的最大值
     * @param root
     * @return
     */
    private static int maxDepth1(TreeNode root){
        if(root == null){return 0;}

        int leftMax = maxDepth1(root.left);
        int rightMax = maxDepth1(root.right);

        //取左右子树最大深度和各子树深度之和最大值（因为可能不过根节点，各子树必须是某节点的左右子树）
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);

        //正常后序遍历求最大深度
        return 1 + Math.max(leftMax, rightMax);

    }

    /**
     * 初始化数据
     */
    private static void initFindMode(){
        Integer[] parts = {6,1,7,1,2,7,9};
        TreeNode root = ConstructTree.constructTree2(parts);
        List<Integer> mode = findMode(root);
        System.out.println("该二叉搜索树最大众数为：" + mode);
        TreeNode.printOrder(root);

    }

    //众数集合
    private static List<Integer> mode = new ArrayList<>();
    //上一个节点
    private static TreeNode prev1 = null;
    // 当前元素的重复次数
    private static int curCount = 0;
    // 全局的最长相同序列长度
    private static int maxCount = 0;

    /**
     * 输出众数列表（出现频率最高的元素）
     * @param root 二叉搜索树
     * @return 众数列表
     */
    private static List<Integer> findMode(TreeNode root){
        traversal1(root);
        return mode;
    }

    private static void traversal1(TreeNode root){
        if(root == null){
            return;
        }

        traversal1(root.left);

        //中序遍历位置
        //如果上个节点为null，则初始化数据
        if(prev1 == null){
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        }else{
            //如果当前节点与上个节点值相等
            if(root.val == prev1.val){
                //则该节点值出现次数加一
                curCount++;
                //如果该节点值出现次数等于最大出现次数，则该节点值就是众数之一
                if(curCount == maxCount){
                    mode.add(root.val);
                //如果当前节值出现次数大于最大出现次数，则该节点值就是众数（且唯一）
                }else if(curCount > maxCount){
                    mode.clear();
                    maxCount = curCount;
                    mode.add(root.val);
                }
            //如果当前节点与上个节点值不相等，则是新的节点值，所以重新计数
            }else{
                curCount = 1;
                if(curCount == maxCount){
                    mode.add(root.val);
                }
            }
        }
        //计算完毕，把当前节点赋值给上个节点
        prev1 = root;
        traversal1(root.right);

    }

    /**
     * 初始化数据
     */
    private static void initFindTilt(){

        Integer[] parts = {4,2,9,3,5,null,7};
        TreeNode root = ConstructTree.constructTree2(parts);
        int tilt = findTilt(root);
        System.out.println("整个树的坡度就是其所有节点的坡度之和，值为：" + tilt);
        TreeNode.printOrder(root, 1);
        System.out.println("\n计算各个坡度之后的二叉树");

        /**
         * 节点 3 的坡度：|0-0| = 0（没有子节点）
         * 节点 5 的坡度：|0-0| = 0（没有子节点）
         * 节点 7 的坡度：|0-0| = 0（没有子节点）
         * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
         * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
         * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
         * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
         */
        Integer[] tilts = {6,2,7,0,0,null,0};
        TreeNode tiltsNode = ConstructTree.constructTree2(tilts);
        TreeNode.printOrder(tiltsNode,1);
    }

    //坡度之和
    private static int res2 = 0;

    /**
     * 求该二叉树的坡度（即各子树坡度之和，后序遍历简单应用）
     * @param root
     * @return
     */
    private static int findTilt(TreeNode root){
        sum(root);
        return res2;
    }

    /**
     * 求以该节点为根节点树的结点之和
     * @param root
     * @return
     */
    private static int sum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        //后序遍历位置
        //求每个左右子树差的绝对值，并相加
        res2 += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

}
