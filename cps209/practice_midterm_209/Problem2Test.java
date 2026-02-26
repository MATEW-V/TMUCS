import org.junit.Test;
import static org.junit.Assert.*;

public class Problem2Test 
{    
    @Test(timeout = 5000)
    public void testRotateRight_BasicCase() {
        assertEquals(51234, Problem2.rotateRight(12345));
    }
    
    @Test(timeout = 5000)
    public void testRotateRight_WithZero() {
        assertEquals(1234, Problem2.rotateRight(12340));
    }
    
    @Test(timeout = 5000)       
    public void testRotateRight_SingleDigit() {
        assertEquals(5, Problem2.rotateRight(5));
    }
    
    @Test(timeout = 5000)
    public void testRotateRight_TwoDigits() {
        assertEquals(12, Problem2.rotateRight(21));
    }
    
    @Test(timeout = 5000)
    public void testRotateRight_AllZeros() {
        assertEquals(0, Problem2.rotateRight(0));
    }
    
    // Tests for rotateUntilEven (10 marks)
    @Test(timeout = 5000)
    public void testRotateUntilEven_OneRotation() {
        assertEquals(1, Problem2.rotateUntilEven(12345));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_FourRotations() {
        assertEquals(4, Problem2.rotateUntilEven(81357));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_NoEvenDigits() {
        assertEquals(-1, Problem2.rotateUntilEven(13579));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_AlreadyEven() {
        assertEquals(0, Problem2.rotateUntilEven(12348));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_SingleEvenDigit() {
        assertEquals(-1, Problem2.rotateUntilEven(135));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_AllEvenDigits() {
        assertEquals(0, Problem2.rotateUntilEven(2468));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_SingleDigitEven() {
        assertEquals(0, Problem2.rotateUntilEven(2));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_SingleDigitOdd() {
        assertEquals(-1, Problem2.rotateUntilEven(3));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_WithZeros() {
        assertEquals(0, Problem2.rotateUntilEven(10));
    }
    
    @Test(timeout = 5000)
    public void testRotateUntilEven_Zero() {
        assertEquals(0, Problem2.rotateUntilEven(0));
    }
}