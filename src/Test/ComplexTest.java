package Test;
import Display.*;
import EquationClasses.*;
import Graph.*;
import Interactive.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void testAddition() {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);
        Complex result = c1.add(c2);
        assertEquals(4.0, result.real, 1e-10);
        assertEquals(6.0, result.imag, 1e-10);
    }

    @Test
    void testSubtraction() {
        Complex c1 = new Complex(5, 7);
        Complex c2 = new Complex(2, 3);
        Complex result = c1.subtract(c2);
        assertEquals(3.0, result.real, 1e-10);
        assertEquals(4.0, result.imag, 1e-10);
    }

    @Test
    void testMultiplication() {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, -5);
        Complex result = c1.multiply(c2);
        assertEquals(23.0, result.real, 1e-10);
        assertEquals(2.0, result.imag, 1e-10);
    }

    @Test
    void testDivision() {
        Complex c1 = new Complex(4, 2);
        Complex c2 = new Complex(3, -1);
        Complex result = c1.divide(c2);
        assertEquals(1.0, result.real, 1e-10);
        assertEquals(1.0, result.imag, 1e-10);
    }

    @Test
    void testMagnitude() {
        Complex c = new Complex(3, 4);
        assertEquals(5.0, c.magnitude(), 1e-10);
    }

    @Test
    void testToString() {
        Complex c1 = new Complex(3, 4);
        assertEquals("3.0000000000 + 4.0000000000i", c1.toString());

        Complex c2 = new Complex(2, 0);
        assertEquals("2.0000000000", c2.toString());
    }
}

