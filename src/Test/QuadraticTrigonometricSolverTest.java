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

public class QuadraticTrigonometricSolverTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSolveQuadraticTrig_NoRealSolution() {

        QuadraticTrigonometricSolver.solveQuadraticTrigEquation(1, 0, 2, "sin");
        String output = outputStream.toString().trim();
        assertTrue(output.contains("No real solutions"));
    }

    @Test
    void testSolveQuadraticTrig_ValidSolutions() {
        QuadraticTrigonometricSolver.solveQuadraticTrigEquation(1, 0, -1, "sin");
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Possible values of sin(x): 1.0, -1.0"));
        assertTrue(output.contains("General solutions for sin(x) = 1.0:"));
        assertTrue(output.contains("General solutions for sin(x) = -1.0:"));
    }

    @Test
    void testFindAngles_InvalidValue() {
        QuadraticTrigonometricSolver.findAngles(2, "sin");
        String output = outputStream.toString().trim();
        assertTrue(output.contains("No valid angle for sin(x) = 2"));
    }

    @Test
    void testFindAngles_ValidValueSin() {
        QuadraticTrigonometricSolver.findAngles(0.5, "sin");
        String output = outputStream.toString().trim();
        assertTrue(output.contains("General solutions for sin(x) = 0.5:"));
    }

    @Test
    void testFindAngles_ValidValueCos() {
        QuadraticTrigonometricSolver.findAngles(0.5, "cos");
        String output = outputStream.toString().trim();
        assertTrue(output.contains("General solutions for cos(x) = 0.5:"));
    }
}
