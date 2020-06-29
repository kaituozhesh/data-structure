package com.ktz.sh.BST;

/**
 * @ClassName Main
 * @Description
 * @Author kaituozhesh
 * @Date 2020/6/29 15:53
 * @Version V1.0.0
 **/
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
//        System.out.println(bst);
    }
}
