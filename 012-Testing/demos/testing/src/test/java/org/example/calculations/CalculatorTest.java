package org.example.calculations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// In this class, we will fill out methods that test methods
// from the Calculator class
public class CalculatorTest {
    private Calculator calculator;

    @Before // should run before each test:
    public void setup() {
        // Because each test uses a calculator, we can
        // put the initialization logic here
        this.calculator = new Calculator();
    }

    @After // will run after each test:
    public void cleanup() {
        this.calculator = null;
    }


    @Test
    public void testAdd() {
        // Arrange - set up our calculator:
        Calculator calculator = new Calculator();

        // Act - invoke the add function:
        int result = calculator.add(3,4);

        // Assert - Evaluate the results:
        // assertEquals(expected, actual);
        // If the method returns anything other than 7, the test
        // should fail:
        assertEquals(7, result);
    }

    @Test
    public void testSubtract() {
        // Arrange (This was handled in setup function

        // Act
        int result = this.calculator.subtract(10,6);

        // Assert
        assertEquals(4, result);
    }

    @Test
    public void testMultiply() {
        int result = this.calculator.multiply(4,6);
        assertEquals(24, result);
    }

    @Test
    public void testFirstFiveNumbers() {
        int[] result = this.calculator.firstFiveNumbers();
        int[] expected = {1,2,3,4,5};

        // assert that the result is not null:
        assertNotNull(result);

        // assert that the lengths are the same:
        assertEquals(expected.length, result.length);

        // assert that the elements line up, one by one
        for(int i = 0; i < expected.length; i ++) {
            assertEquals(expected[i], result[i]);
        }
    }
}
