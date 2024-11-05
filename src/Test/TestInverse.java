package Test;
import EquationClasses.Inverse;
import EquationClasses.TrigonoValueError;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestInverse {
    @Test
    void testArcSin() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 30.0;
        Double actual1 = I.arcsin(0.5);
        assertEquals(expected1, actual1, "arcsin(0.5) should be 30.0 degrees");

        Double expected2 = 0.0;
        Double actual2 = I.arcsin(0.0);
        assertEquals(expected2, actual2, "arcsin(0.0) should be 0.0 degrees");

        Double expected3 = 90.0;
        Double actual3 = I.arcsin(1.0);
        assertEquals(expected3, actual3, "arcsin(1.0) should be 90.0 degrees");
    }



    @Test
    void testArcCos() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 60.0;
        Double actual1 = I.arccos(0.5);
        assertEquals(expected1, actual1, "arccos(0.5) should be 60.0 degrees");

        Double expected2 = 90.0;
        Double actual2 = I.arccos(0.0);
        assertEquals(expected2, actual2, "arccos(0.0) should be 90.0 degrees");

        Double expected3 = 0.0;
        Double actual3 = I.arccos(1.0);
        assertEquals(expected3, actual3, "arccos(1.0) should be 0.0 degrees");
    }



    @Test
    void testArcTan() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 45.0;
        Double actual1 = I.arctan(1.0);
        assertEquals(expected1, actual1, "arctan(1.0) should be 45.0 degrees");

        Double expected2 = 0.0;
        Double actual2 = I.arctan(0.0);
        assertEquals(expected2, actual2, "arctan(0.0) should be 0.0 degrees");

        Double expected3 = 26.565;  // Expected result for arctan(0.5) in degrees
        Double actual3 = I.arctan(0.5);
        assertEquals(expected3, actual3, 0.001, "arctan(0.5) should be approximately 26.565 degrees");
    }






}
