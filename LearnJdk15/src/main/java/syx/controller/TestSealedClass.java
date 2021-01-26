package syx.controller;

import syx.entity.ClassSealedA;

import java.util.Objects;

/**
 * * 密闭类、封闭类
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/11 15:08
 */
public class TestSealedClass {

    public static void main(String[] args) {
        // 1、密闭类
        ClassSealedA sealedA = new ClassSealedA();
        System.out.println(sealedA);
        // 2、隐藏类

        // 3、instanceof自动匹配
        Object oldStr = "sssss";
        if (oldStr instanceof String s) {
            System.out.println("String..." + s);
        } else {
            System.out.println("other...");
        }

        if (oldStr instanceof String) {
            String s = (String) oldStr;
            System.out.println("String..." + s);
        } else {
            System.out.println("other...");
        }

        // 4、Records Class--轻量级class,jdk14为第一次出现,为不可变
        record ClassA(String id, String name) {
        }
        ClassA classA = new ClassA("id", "name");
        System.out.println(classA.toString());

        ClassB classB = new ClassB("2ID", "2NAME");
        System.out.println(classB.toString());
    }

    static class ClassB {
        private String id;

        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassB classB = (ClassB) o;
            return id.equals(classB.id) && name.equals(classB.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public ClassB(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ClassB{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
