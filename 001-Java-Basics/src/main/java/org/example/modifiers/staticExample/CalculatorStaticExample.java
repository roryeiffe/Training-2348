package org.example.modifiers.staticExample;

public class CalculatorStaticExample {
    // not static because each calculator should have its own id:
    private int id;

    // We use the static keyword here, scoping this variable to the class because
    // EVERY calculator should have the same value of PI
    public static final double pi = 3.14159;


    // Note that the getter/setter methods aren't static because they are keeping track of the state of an individual object
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // This method is static because this behavior should always be the same across the whole class
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // We create an instance of a calculator to serve as our non-static context:
        CalculatorStaticExample calculator = new CalculatorStaticExample();

        // from a non-static context, we can access non-static methods:
        calculator.setId(101);
        System.out.println(calculator.getId());

        // from a non-static context, we can access static fields/methods
        System.out.println(calculator.pi);
        System.out.println(calculator.add(3,4));

        // from a static context, we can access static fields methods:
        System.out.println(CalculatorStaticExample.add(3,4));
        System.out.println(CalculatorStaticExample.pi);

        // from a static context, CANNOT access non-static fields/methods
//        System.out.println(CalculatorStaticExample.setId(102));

    }
}
