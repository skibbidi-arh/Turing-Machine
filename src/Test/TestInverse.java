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

    @Test

    void testArcSec() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 60.0;  // Expected result for arcsec(2) in degrees
        Double actual1 = I.arcsec(2.0);
        assertEquals(expected1, actual1, "arcsec(2) should be 60.0 degrees");

        Double expected2 = 90.0;  // Expected result for arcsec(1) in degrees
        Double actual2 = I.arcsec(1.0);
//        assertEquals(expected2, actual2, "arcsec(1) should be 90.0 degrees");

        Double expected3 = 120.0;  // Expected result for arcsec(-2) in degrees
        Double actual3 = I.arcsec(-2.0);
        assertEquals(expected3, actual3, "arcsec(-2) should be 120.0 degrees");
    }


    @Test
    void testArcCosec() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 30.0;  // Expected result for arccosec(2) in degrees
        Double actual1 = I.arccosec(2.0);
        assertEquals(expected1, actual1, "arccosec(2) should be 30.0 degrees");

        Double expected2 = 90.0;  // Expected result for arccosec(1) in degrees
        Double actual2 = I.arccosec(1.0);
        assertEquals(expected2, actual2, "arccosec(1) should be 90.0 degrees");

        Double expected3 = -30.0;  // Expected result for arccosec(-2) in degrees
        Double actual3 = I.arccosec(-2.0);
        assertEquals(expected3, actual3, "arccosec(-2) should be 150.0 degrees");
    }


    @Test
    void testArcCot() throws TrigonoValueError {
        Inverse I = new Inverse();


        Double expected1 = 45.0;  // Expected result for arccot(1) in degrees
        Double actual1 = I.arccot(1.0);
        assertEquals(expected1, actual1, "arccot(1) should be 45.0 degrees");

        Double expected2 = 90.0;  // Expected result for arccot(0) in degrees
        Double actual2 = I.arccot(0.0);
        assertEquals(expected2, actual2, "arccot(0) should be 90.0 degrees");

        Double expected3 = 63.435;  // Expected result for arccot(0.5) in degrees
        Double actual3 = I.arccot(0.5);
        assertEquals(expected3, actual3, 0.001, "arccot(0.5) should be approximately 63.435 degrees");
    }

}
