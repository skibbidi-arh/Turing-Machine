package src.Test;
import src.EquationClasses.QuadraticTrigonometricSolver;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticTrigonometricSolverTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testSolveQuadraticTrig() {
        QuadraticTrigonometricSolver solver = new QuadraticTrigonometricSolver();
        solver.solveQuadraticTrig(1, 1, 0, 0, -1);

        String output = outContent.toString();
        assertTrue(output.contains("Solving in terms of sin(x)"));
        assertTrue(output.contains("Solving in terms of cos(x)"));
    }




    @Test
    void testFindAnglesInvalidValues() {
        QuadraticTrigonometricSolver.findAngles(2, "sin");
        String output = outContent.toString();
        assertTrue(output.contains("No valid angle for sin(x) = 2"));
    }

    @Test
    void testSolve() {
        String input = "1\n1\n0\n0\n-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        QuadraticTrigonometricSolver solver = new QuadraticTrigonometricSolver();
        solver.solve();
        String output = outContent.toString();
        assertTrue(output.contains("Enter coefficients a, b, c, d, e"));
    }
}

