package com.ktz.sh.array;

/**
 * @ClassName : Main
 * @Description :
 * @Author : kaituozhesh
 * @Date: 2020-05-10 20:59
 * @Version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.addLast(9);
        array.addLast(9);
        array.addLast(9);
        System.out.println(array);

        array.removeAllElement(9);
        array.removeLast();
        array.removeLast();
        array.removeLast();
        System.out.println(array);
    }
}
