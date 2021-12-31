package com.pcg;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;
import com.pcg.utils.TreeOperation;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/3:32 下午
 */
public class Test {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree2(nums);
//        TreeNode.printOrder(root);
        TreeOperation.prettyPrintTree(root);
    }
}
