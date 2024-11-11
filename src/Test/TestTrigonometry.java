package src.Test;
import src.EquationClasses.Trigonometry;
import src.EquationClasses.TrigonoValueError;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrigonometry {


    @Test
    void testSin() throws TrigonoValueError {
        Trigonometry trig = new Trigonometry();

        // Test sin function
        Double expected1 = 0.5;
        Double actual1 = trig.sin(30.0);
        assertEquals(expected1, actual1, 0.001, "sin(30) should be approximately 0.5");

        Double expected2 = 1.0;
        Double actual2 = trig.sin(90.0);
        assertEquals(expected2, actual2, 0.001, "sin(90) should be 1.0");

        Double expected3 = 0.0;
        Double actual3 = trig.sin(0.0);
        assertEquals(expected3, actual3, 0.001, "sin(0) should be 0.0");
    }


    @Test
    void testCos() throws TrigonoValueError{
        Trigonometry trig = new Trigonometry();

        // Test cos function
        Double expected1 = 0.5;
        Double actual1 = trig.cos(60.0);
        assertEquals(expected1, actual1, 0.001, "cos(60) should be approximately 0.5");

        Double expected2 = 1.0;
        Double actual2 = trig.cos(0.0);
        assertEquals(expected2, actual2, 0.001, "cos(0) should be 1.0");

        Double expected3 = 0.0;
        Double actual3 = trig.cos(90.0);
        assertEquals(expected3, actual3, 0.001, "cos(90) should be 0.0");
    }


    @Test
    void testTan() throws TrigonoValueError{
        Trigonometry trig = new Trigonometry();

        // Test tan function
        Double expected1 = 1.0;
        Double actual1 = trig.tan(45.0);
        assertEquals(expected1, actual1, 0.001, "tan(45) should be approximately 1.0");

        Double expected2 = 0.0;
        Double actual2 = trig.tan(0.0);
        assertEquals(expected2, actual2, 0.001, "tan(0) should be 0.0");


    }

    

}
