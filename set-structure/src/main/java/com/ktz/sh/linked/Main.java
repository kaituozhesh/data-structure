package com.ktz.sh.linked;

/**
 * @ClassName : Main
 * @Description :
 * @Author : kaituozhesh
 * @Date: 2020-05-11 20:16
 * @Version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
