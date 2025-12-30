package org.example;

public class ScopeExample {
    private int instanceScope;

    public static void main(String[] args) {
        // because x is defined in a different method scope, can't use it here
//        System.out.println(x);

        while(true) {
            int y = 2;
        }
        // can't access y outside of the block in which it was defined
//        System.out.println(y);


    }

    public static void method1() {
        int x = 1;
    }
}
