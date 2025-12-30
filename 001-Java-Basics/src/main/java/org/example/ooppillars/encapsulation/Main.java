package org.example.ooppillars.encapsulation;

public class Main {
    public static void main(String[] args) {
        State state = new State();

        state.setName("Virginia");
        System.out.println(state.getName());
    }
}
