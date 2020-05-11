package com.ktz.sh.linked;

/**
 * @ClassName : LinkedList
 * @Description :单链表实现
 * @Author : kaituozhesh
 * @Date: 2020-05-11 19:27
 * @Version: 1.0.0
 */
public class LinkedList<E> {

    /**
     * 自定义链表节点
     */
    private class Node {
        // 节点元素
        public E e;
        // 下一节点
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    /**
     * 头节点  不存储元素
     */
    private Node dummyHead;
    /**
     * 有效元素个数
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取有效元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链头加入元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链尾加入元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 指定位置插入元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail Require index > 0 && index <= size");
        }
        // 从头指针开始遍历index次后指针指向要插入位置的前置节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 添加元素并把之后的链表挂在插入元素之后
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 删除头节点元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾节点元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定位置元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove fail Require index > 0 && index <= size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        size--;
        return retNode.e;
    }

    /**
     * 删除元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
            size--;
        }
    }

    /**
     * 删除所有元素e
     *
     * @param e
     */
    public void removeElementAll(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                prev.next = prev.next.next;
                size--;
                if (prev == null) {
                    break;
                }
                continue;
            }
            prev = prev.next;
        }
    }

    /**
     * 修改指定位置元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set fail. Require index > 0 && index < size");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断元素是否存在
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur.e + "->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
