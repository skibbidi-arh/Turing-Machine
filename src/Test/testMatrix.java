package Test;
import Display.*;
import EquationClasses.*;
import Graph.*;
import Interactive.*;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMatrix {
    private Matrix matrix1;
    private Matrix matrix2;

    @BeforeEach
    void setUp() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        matrix1 = new Matrix(data1);
        matrix2 = new Matrix(data2);
    }

    @Test
    void testGetRows() {
        assertEquals(3, matrix1.getRows());
    }

    @Test
    void testGetCols() {
        assertEquals(3, matrix1.getCols());
    }

    @Test
    void testGetMatrix() {
        double[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertArrayEquals(expected, matrix1.getMatrix());
    }

    @Test
    void testMatrixAddition() {
        double[][] expected = {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        };
        assertArrayEquals(expected, Matrix.add(matrix1.getMatrix(), matrix2.getMatrix()));
    }

    @Test
    void testMatrixSubtraction() {
        double[][] expected = {
                {-8, -6, -4},
                {-2, 0, 2},
                {4, 6, 8}
        };
        assertArrayEquals(expected, Matrix.subtract(matrix1.getMatrix(), matrix2.getMatrix()));
    }

    @Test
    void testSetMatrix() {
        double[][] newData = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        matrix1.setMatrix(newData);
        assertArrayEquals(newData, matrix1.getMatrix());
        assertEquals(3, matrix1.getRows());
        assertEquals(3, matrix1.getCols());
    }
}

