package dev_java.ch01;

public class Hello {

    int methodA(int i, int j) {
        int hap;
        hap = i + j;
        return hap;
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.methodA(2, 3);
        System.out.println("Hello Java");
        // 개발환경설정
        System.out.println("git 설정 추가");
    }
}

    