import org.junit.Test;
import static org.junit.Assert.*;

public class TextBookTest 
{
    @Test(timeout = 5000)
    public void testGetCourseCode() {
        TextBook textbook = new TextBook("Test Book", 10.00, "CS101");
        assertEquals("CS101", textbook.getCourseCode());
    }
    @Test(timeout = 5000)
    public void testSetCourseCode() {
        TextBook textbook = new TextBook("Test Book", 10.00, "CS101");
        textbook.setCourseCode("CS102");
        assertEquals("CS102", textbook.getCourseCode());
    }


    @Test(timeout = 5000)
    public void testCalculatePrice() {
        TextBook textbook = new TextBook("Test Book", 100.00, "CS101");
        assertEquals(135.6, textbook.calculatePrice(), 0.001);
    }
    @Test(timeout = 5000)
    public void testCalculatePriceZero() {
        TextBook textbook = new TextBook("Test Book", 0.00, "CS101");
        assertEquals(0.00, textbook.calculatePrice(), 0.001);
    }


    @Test(timeout = 5000)
    public void testEqualsIdenticalTextBooks() {
        TextBook textbook1 = new TextBook("Test Book", 10.00, "CS101");
        TextBook textbook2 = new TextBook("Test Book", 10.00, "CS101");
        assertTrue(textbook1.equals(textbook2));
    }
    @Test(timeout = 5000)
    public void testEqualsDifferentCourseCode() {
        TextBook textbook1 = new TextBook("Test Book", 10.00, "CS101");
        TextBook textbook2 = new TextBook("Test Book", 10.00, "CS102");
        assertFalse(textbook1.equals(textbook2));
    }
    @Test(timeout = 5000)
    public void testEqualsSameObject() {
        TextBook textbook = new TextBook("Test Book", 10.00, "CS101");
        assertTrue(textbook.equals(textbook));
    }

    
    @Test(timeout = 5000)
    public void testToStringBasicTextBook() {
        TextBook textbook = new TextBook("Test Book", 10.00, "CS101");
        assertEquals("CS101:TextBook[Test Book@$10.00]", textbook.toString());
    }
    @Test(timeout = 5000)
    public void testToStringZeroPrice() {
        TextBook textbook = new TextBook("Test Book", 0.00, "CS102");
        assertEquals("CS102:TextBook[Test Book@$0.00]", textbook.toString());
    }
    @Test(timeout = 5000)
    public void testToStringLongCourseCode() {
        TextBook textbook = new TextBook("Test Book", 10.333333333, "COMP3000");
        assertEquals("COMP3000:TextBook[Test Book@$10.33]", textbook.toString());
    }
}
