package org.example;

public class GCExample {

    public static void main(String[] args) {
        String s3 = new String("Bat");
        phase1();
        phase2();

        // At this point in the code, s1 and s2 are no longer referenced, so could be marked for garbage collection
        // But s3 is still referenced and in use, so it will not be marked for garbage collection

        System.out.println(s3);

    }

    public static void phase1() {
        String s1 = new String("cat");
    }

    public static void phase2() {
        String s2 = new String("dog");
    }
}
