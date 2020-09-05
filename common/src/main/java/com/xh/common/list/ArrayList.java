package com.xh.common.list;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xt
 * @date 2020/9/3
 */
public class ArrayList extends java.util.ArrayList {


    //如果实例化时未指定容量，则在初次添加元素时会进行扩容使用此容量作为数组长度
    private static final int DEFAULT_CAPACITY = 10;
    /*static修饰，所有的未指定容量的实例(也未添加元素)共享此数组，
        两个空的数组有什么区别呢？ 就是第一次添加元素时知道该 elementData
        从空的构造函数还是有参构造函数被初始化的。以便确认如何扩容。空的构造器则初始化为10，
        有参构造器则按照扩容因子扩容
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData; // arrayList真正存放元素的地方，长度大于等于size

    private int size;//arrayList中的元素个数

    public static void main(String[] args) {
    }

}
