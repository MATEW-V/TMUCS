import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest 
{
    @Test(timeout = 5000)
    public void testGetTitle() {
        Book book = new Book("Test Book", 10.00);
        assertEquals("Test Book", book.getTitle());
    }
    @Test(timeout = 5000)
    public void testGetBasePrice() {
        Book book = new Book("Test Book", 10.00);
        assertEquals(10.00, book.getBasePrice(), 0.001);
    }
    @Test(timeout = 5000)
    public void testSetTitle() {
        Book book = new Book("Test Book", 10.00);
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }
    @Test(timeout = 5000)
    public void testSetBasePrice() {
        Book book = new Book("Test Book", 10.00);
        book.setBasePrice(20.00);
        assertEquals(20.00, book.getBasePrice(), 0.001);
    }


    @Test(timeout = 5000)
    public void testCalculatePrice() {
        Book book = new Book("Test Book", 100.00);
        assertEquals(113.00, book.calculatePrice(), 0.001);
    }
    @Test(timeout = 5000)
    public void testCalculatePriceZero() {
        Book book = new Book("Test Book", 0.00);
        assertEquals(0.00, book.calculatePrice(), 0.001);
    }


    @Test(timeout = 5000)
    public void testEqualsIdenticalBooks() {
        Book book1 = new Book("Test Book", 10.00);
        Book book2 = new Book("Test Book", 10.00);
        assertTrue(book1.equals(book2));
    }
    @Test(timeout = 5000)
    public void testEqualsSameObject() {
        Book book = new Book("Test Book", 10.00);
        assertTrue(book.equals(book));
    }
    @Test(timeout = 5000)
    public void testEqualsDifferentTitle() {
        Book book1 = new Book("Test Book 1", 10.00);
        Book book2 = new Book("Test Book 2", 10.00);
        assertFalse(book1.equals(book2));
    }
    @Test(timeout = 5000)
    public void testEqualsDifferentPrice() {
        Book book1 = new Book("Test Book", 10.00);
        Book book2 = new Book("Test Book", 20.00);
        assertFalse(book1.equals(book2));
    }


    @Test(timeout = 5000)
    public void testCompareToLowerPrice() {
        Book book1 = new Book("Test Book", 10.00);
        Book book2 = new Book("Test Book", 20.00);
        assertTrue(book1.compareTo(book2) < 0);
    }
    @Test(timeout = 5000)
    public void testCompareToHigherPrice() {
        Book book1 = new Book("Test Book", 20.00);
        Book book2 = new Book("Test Book", 10.00);
        assertTrue(book1.compareTo(book2) > 0);
    }
    @Test(timeout = 5000)
    public void testCompareToSamePriceDifferentTitles() {
        Book book1 = new Book("A Book", 10.00);
        Book book2 = new Book("B Book", 10.00);
        assertTrue(book1.compareTo(book2) < 0);
    }
    @Test(timeout = 5000)
    public void testCompareToReverseTitleOrder() {
        Book book1 = new Book("Z Book", 10.00);
        Book book2 = new Book("A Book", 10.00);
        assertTrue(book1.compareTo(book2) > 0);
    }
    @Test(timeout = 5000)
    public void testCompareToSamePriceSameTitle1() {
        Book book1 = new Book("Test Book", 10.00);
        Book book2 = new Book("Test Book", 10.00);
        assertEquals(0, book1.compareTo(book2));
    }
    @Test(timeout = 5000)
    public void testCompareToSamePriceSameTitle2() {
        Book book1 = new Book("Test Book", 0.00);
        Book book2 = new Book("Test Book", 0.00);
        assertEquals(0, book1.compareTo(book2));
    }

    
    @Test(timeout = 5000)
    public void testToStringBasicBook() {
        Book book = new Book("Test Book", 10.00);
        assertEquals("Book[Test Book@$10.00]", book.toString());
    }
    @Test(timeout = 5000)
    public void testToStringZeroPrice() {
        Book book = new Book("Test Book", 0.00);
        assertEquals("Book[Test Book@$0.00]", book.toString());
    }
    @Test(timeout = 5000)
    public void testToStringLongTitle() {
        Book book = new Book("This is a very long book title that should still work", 10.00);
        assertEquals("Book[This is a very long book title that should still work@$10.00]", book.toString());
    }
    @Test(timeout = 5000)
    public void testToStringLargePrice() {
        Book book = new Book("Test Book", 1234567.89);
        assertEquals("Book[Test Book@$1234567.89]", book.toString());
    }
}
