package com.pcg.utils;

import com.pcg.leetCode.Bean.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 根据数组创建二叉树
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/9:59 上午
 */

public class ConstructTree {

    /**
     * 根据数组创建二叉树
     * @param nums Integer数组（eg：Integer[] nums = {4,2,7,1,3,6,9};）
     * @return 二叉树对象
     */
    public static TreeNode constructTree(Integer[] nums){
        if (nums.length == 0) {
            return new TreeNode(0);
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;

        while(restLength > 0) {
            // 只有最后一行可以不满，其余行必须是满的
//            // 若输入的数组的数量是错误的，直接跳出程序
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new TreeNode(0);
//            }
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) {
                    return root;
                }
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) {
                    return root;
                }
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }

    /**
     * 根据数组创建二叉树 （另一种思路）
     * @param parts Integer数组（eg：Integer[] nums = {4,2,7,1,3,6,9};）
     * @return 二叉树对象
     */
    public static TreeNode constructTree2(Integer[] parts){
        if(parts.length == 0){
            return null;
        }
        Integer item = parts[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            if (item != null) {
                node.left = new TreeNode(item);
                nodeQueue.add(node.left);
            }
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            if (item != null) {
                node.right = new TreeNode(item);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
