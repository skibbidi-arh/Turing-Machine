package Test;
import Display.*;
import EquationClasses.*;
import Graph.*;
import Interactive.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
class LogarithmCalculatorTest {

    @Test
    void testLn() {
        assertEquals(Math.log(1), LogarithmCalculator.ln(1), 1e-6);
        assertEquals(Math.log(2), LogarithmCalculator.ln(2), 1e-6);
        assertEquals(Math.log(10), LogarithmCalculator.ln(10), 1e-6);
    }

    @Test
    void testLog10() {
        assertEquals(Math.log10(1), LogarithmCalculator.log10(1), 1e-6);
        assertEquals(Math.log10(10), LogarithmCalculator.log10(10), 1e-6);
        assertEquals(Math.log10(100), LogarithmCalculator.log10(100), 1e-6);
    }

    @Test
    void testLogBase() {
        assertEquals(Math.log(8) / Math.log(2), LogarithmCalculator.logBase(8, 2), 1e-6);
        assertEquals(Math.log(27) / Math.log(3), LogarithmCalculator.logBase(27, 3), 1e-6);
        assertEquals(Math.log(100) / Math.log(5), LogarithmCalculator.logBase(100, 5), 1e-6);
    }

    @Test
    void testLnInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> LogarithmCalculator.ln(0));
        assertThrows(IllegalArgumentException.class, () -> LogarithmCalculator.ln(-5));
    }

    @Test
    void testLogBaseInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> LogarithmCalculator.logBase(-10, 2));
        assertThrows(IllegalArgumentException.class, () -> LogarithmCalculator.logBase(10, -2));
        assertThrows(IllegalArgumentException.class, () -> LogarithmCalculator.logBase(10, 1));
    }
}

