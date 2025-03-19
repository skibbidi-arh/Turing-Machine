package Test;
import Display.*;
import EquationClasses.*;
import Graph.*;
import Interactive.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RRefTest {
    private RRef rrefSolver;

    @BeforeEach
    void setUp() {
        rrefSolver = new RRef();
    }

    @Test
    void testRrefSimpleMatrix() {
        double[][] inputData = {
                {1, 2, -1},
                {2, 4, -2},
                {3, 6, -3}
        };
        double[][] expectedData = {
                {1, 2, -1},
                {0, 0, 0},
                {0, 0, 0}
        };

        Matrix inputMatrix = new Matrix(inputData);
        Matrix resultMatrix = rrefSolver.rref(inputMatrix);

        assertArrayEquals(expectedData, resultMatrix.getMatrix());
    }




    @Test
    void testRrefAlreadyInRref() {
        double[][] inputData = {
                {1, 0, 0, 2},
                {0, 1, 0, 3},
                {0, 0, 1, -1}
        };

        Matrix inputMatrix = new Matrix(inputData);
        Matrix resultMatrix = rrefSolver.rref(inputMatrix);

        assertArrayEquals(inputData, resultMatrix.getMatrix());
    }
}
