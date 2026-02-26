public class Problem1 
{
    /*
     * FULL NAME:  Matthew Vuong
     * STUDENT ID: 501348434
     */

     public static int firstUniqueChar(String s) 
     {
        /*
         * This method accepts a string as input, and returns the index of the first
         * unique character in the string. That is, the index of the first character
         * that appears only ONCE in the string. If there are no unique characters,
         * you should return -1.
         * 
         * For example, if the input string is "abacabad", the method should return 3,
         * because the first character that appears only once is 'c' at index 3.
         * 
         * However, if the input string is "abacabaabacaba", the method should return -1,   
         * because all characters occur more than once.
         * 
         * Hint 1: Don't overthink it. A simple nested loop will do the trick.
         * Hint 2: If you ARE in the mood to overthink it, you can try solving it in O(n) time.
         * 
         * To run the unit tests for this problem, use the following commands in the terminal:
         * 
         * Compile)     javac -cp junit-1.11.0-M2.jar Problem1.java Problem1Test.java
         * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c Problem1Test 
         * 
         * This method is worth 10 marks.
         */
        int count = 0;
        for (char c: s.toCharArray()) {
            count = 0;
            for (int i = 0; i<s.length(); i++) {
                if (s.charAt(i)==c) {
                    count++;
                }
            }
            if (count==1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
} 