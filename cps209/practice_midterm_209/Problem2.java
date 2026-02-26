public class Problem2 
{
    /*
     * FULL NAME:  Matthew Vuong
     * STUDENT ID: 501348434
     */
     public static int rotateRight(int number)
     {
        /*
         * This method takes an integer and "rotates" it to the
         * right by one digit. This means that the right-most digit
         * of the integer becomes the left-most. For example, the
         * integer 12345 would beecome 51234. If the right-most 
         * digit is zero, it is removed: 12340 becomes 1234.
         *
         * To run the unit tests for this problem, use the following commands in the terminal:
         * 
         * Compile)     javac -cp junit-1.11.0-M2.jar Problem2.java Problem2Test.java
         * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c Problem2Test 
         * 
         * This method is worth 5 marks.
         */
        String numStr = Integer.toString(number);
        String[] res = new String[numStr.length()-1];
        for (int i = 0; i<numStr.length(); i++) {
            
        }
        return -1;
     }

    public static int rotateUntilEven(int number)
    {
        /* 
         * This method rotates an integer to the right (as described in
         * the method above) until the result is even. You should return 
         * the number of single-digit rotations it took for this to occur.
         * If the number does not contain any even digits, you should
         * detect this and return -1 instead. Note that the number zero
         * on its own is considered even. 
         * 
         * 12345 -> returns 1, because one rotation yields 51234 (even)
         * 81357 -> returns 4, because four rotations yield 13578 (even)
         * 13579 -> returns -1, because it never becomes even (beware infinite loops!)
         * 
         * To run the unit tests for this problem, use the following commands in the terminal:
         * 
         * Compile)     javac -cp junit-1.11.0-M2.jar Problem2.java Problem2Test.java
         * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c Problem2Test 
         * 
         * This method is worth 10 marks.
         */
              
        return -11;
    }
}
