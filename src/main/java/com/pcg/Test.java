package com.pcg;

import com.pcg.leetCode.Bean.TreeNode;
import com.pcg.utils.ConstructTree;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: panchenguang
 * @Date: 2021/12/27/3:32 下午
 */
public class Test {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.removeLast();
        String join = String.join("->", list);
        System.out.println(list);
        System.out.println(join);
    }
}
