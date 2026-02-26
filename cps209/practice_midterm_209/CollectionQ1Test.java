import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CollectionQ1Test 
{
    @Test(timeout = 5000)
    public void testInputNotModified() {
        ArrayList<String> input = new ArrayList<>();
        input.add("test");
        input.add("a");
        input.add("long");
        input.add("word");
        ArrayList<String> originalInput = new ArrayList<>(input);
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 3);
        assertTrue(result.contains("a"));
        assertEquals(originalInput, input);
    }

    @Test(timeout = 5000)
    public void testEmptyList() {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 5);
        assertTrue(result.isEmpty());
    }

    @Test(timeout = 5000)
    public void testNoShortWords() {
        ArrayList<String> input = new ArrayList<>();
        input.add("longer");
        input.add("strings");
        input.add("testing");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 7);
        assertEquals(3, input.size());
        assertTrue(result.size() == 1);
        assertTrue(result.contains("longer"));
    }

    @Test(timeout = 5000)   
    public void testAllShortWords() {
        ArrayList<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 2);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(input));
    }

    @Test(timeout = 5000)
    public void testMixedLengths() {
        ArrayList<String> input = new ArrayList<>();
        input.add("a");
        input.add("long");
        input.add("b");
        input.add("test");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 2);
        assertEquals(2, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("b"));
    }

    @Test(timeout = 5000)
    public void testExactLength() {
        ArrayList<String> input = new ArrayList<>();
        input.add("abc");
        input.add("def");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 3);
        assertTrue(result.isEmpty());
    }

    @Test(timeout = 5000)   
    public void testNegativeK() {
        ArrayList<String> input = new ArrayList<>();
        input.add("test");
        input.add("a");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, -1);
        assertEquals(0, result.size());
        assertTrue(input.contains("test"));
        assertTrue(input.contains("a"));
    }
   
    @Test(timeout = 5000)
    public void testZeroK() {
        ArrayList<String> input = new ArrayList<>();
        input.add("");
        input.add("a");
        input.add("ab");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 1);
        assertTrue(result.contains(""));
        assertEquals(1, result.size());
    }

    @Test(timeout = 5000)
    public void testEmptyStrings() {
        ArrayList<String> input = new ArrayList<>();
        input.add("");
        input.add("test");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 5);
        assertEquals(2, result.size());
        assertTrue(result.contains(""));
    }

    @Test(timeout = 5000)   
    public void testLargeK() {
        ArrayList<String> input = new ArrayList<>();
        input.add("short");
        input.add("very long string");
        input.add("medium");
        ArrayList<String> result = CollectionQ1.collectShortWords(input, 100);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(input));
    }
}
