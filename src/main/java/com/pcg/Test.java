package com.pcg;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/3:32 下午
 */
public class Test {
    public static void main(String[] args) {
//        Integer[] nums = {-10,-3,0,5,9};
        Integer[] nums = {5, 4, 7, 3, null, 2, null, -1, null, 9};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeNode.printOrder(root);
    }
}
