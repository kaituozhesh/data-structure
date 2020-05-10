package com.ktz.sh.array;

/**
 * @ClassName : Array
 * @Description : 动态数组实现
 * @Author : kaituozhesh
 * @Date: 2020-05-10 20:26
 * @Version: 1.0.0
 */
public class Array<E> {

    /**
     * 数组数据
     */
    private E[] data;

    /**
     * 有效数据
     */
    private int size;

    /**
     * 默认初始化数组容量10
     */
    public Array() {
        this(10);
    }

    /**
     * 自定义初始化数组容量
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 获取有效数据个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素到开头
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 添加元素到最后
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
            throw new IllegalArgumentException("Add faild. Require index >= 0 && index < size");
        }
        if (size == data.length) {
            reSize(2 * data.length);
        }
        // size - 1指向最后一个有效元素的下标
        for (int i = size - 1; i >= index; i--) {
            // index及之后的元素后移
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 删除首个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * 删除指定下标元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove faild. Require index >= 0 && index < size");
        }
        E result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            reSize(data.length / 2);
        }
        return result;
    }

    /**
     * 删除首个元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除数组中所有的元素e
     *
     * @param e
     */
    public void removeAllElement(E e) {
        int index = find(e);
        while (index != -1) {
            remove(index);
            index = find(e);
        }
    }

    /**
     * 修改下标index的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is Illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断元素e是否存在
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }


    /**
     * 查询元素下标
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 重置数组容量
     *
     * @param newCapacity
     */
    private void reSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d", size, getCapacity()));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        return builder.append("]").toString();
    }
}
