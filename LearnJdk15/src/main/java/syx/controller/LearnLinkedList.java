package syx.controller;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * * syx.controller
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/4 10:26
 */
public class LearnLinkedList<E> {

    private static LinkedList<Integer> linkedList = new LinkedList<>();


    @Test
    public void mainTest() {
        // 1、初始化完成后linkedList内的元素为[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
        System.out.println(Arrays.toString(linkedList.toArray()));

    }


    @Before
    public void initLinkedList() {
        // LinkedList的添加，默认在尾部进行添加(linkLast)，除此之外，在开头添加的linkFirst；在中部添加的linkBefore
        for (int i = 0; i < 20; i++) {
            // 默认在队列尾部进行添加，也就是按顺序添加
            // 内部调用linkLast
            linkedList.add(i + 1);
        }
    }


}
