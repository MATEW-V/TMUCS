import org.junit.Test;
import static org.junit.Assert.*;

public class Problem1Test 
{
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_SingleChar() {
        assertEquals(0, Problem1.firstUniqueChar("a"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_SimpleCase() {
        assertEquals(3, Problem1.firstUniqueChar("abacabad"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_AllRepeating() {
        assertEquals(-1, Problem1.firstUniqueChar("abacabaabacaba"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_EmptyString() {
        assertEquals(-1, Problem1.firstUniqueChar(""));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_LastCharUnique() {
        assertEquals(4, Problem1.firstUniqueChar("aabbz"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_FirstCharUnique() {
        assertEquals(0, Problem1.firstUniqueChar("xaabbcc"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_SpecialChars() {
        assertEquals(2, Problem1.firstUniqueChar("##$#"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_Numbers() {
        assertEquals(2, Problem1.firstUniqueChar("11234411"));
    }
    
    @Test(timeout = 5000)       
    public void testFirstNonRepeatingChar_MixedCase() {
        assertEquals(0, Problem1.firstUniqueChar("aAbBAc"));
    }
    
    @Test(timeout = 5000)
    public void testFirstNonRepeatingChar_SpacesIncluded() {
        assertEquals(2, Problem1.firstUniqueChar("a bc a"));
    }
}