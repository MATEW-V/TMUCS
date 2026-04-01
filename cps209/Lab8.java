public class Lab8
{


    /**
     * This method should return numerator/denominator as double.
     * That is, 1/2 should correctly return 0.5 rather than
     * truncating.
     * 
     * If the denominator is zero, throw an ArithmeticException.
     * 
     * If the numerator and denominator are both zero, throw
     * an UnsupportedOperationException.
     * 
     */
    public static double divideNumbers(int numerator, int denominator) 
    {

        return 0.0;
    }

    /**
     * This method converts a temperature from Celsius to Fahrenheit 
     * and validates the input.
     * 
     * If the String celciusTemp cannot be parsed as a number, you
     * should throw a NumberFormatException.
     * 
     * If celciusTemp is below absolute zero (-273.15°C), you should
     * throw an InvalidTemperatureException. Note that this does not 
     * exist, you should create it! Refer to the example in the slides 
     * for how this can be done.
     * 
     * The InvalidTemperatureException should be created as a static
     * nested class inside this Lab8 class.
     */
    public static double convertCelsiusToFahrenheit(String celsiusTemp) 
    {

        return 0.0;
    }

    /**
     * This method should open the plain text file named fname_in and 
     * return, as a String, lines first to last, inclusive.
     * 
     * If first or last are negative, or if last is less than first,
     * throw a Negative­Array­Size­Exception
     * 
     * If first is larger than the number of lines in the file, 
     * throw an Index­Out­Of­Bounds­Exception
     * 
     * if last is larger than the number of lines in the file, then
     * return a string containing lines first to the end of the file.
     * 
     * You may assume that fname_in is a file that exists.
     */
    public static String file_slice(String fname_in, int first, int last) 
    {
        
        return "";
    }


    /**
     * This method should open the plain text file named fname_in and 
     * produce a new file whose name is fname_out. The output file 
     * should contain the lines from the input file in reverse order.
     * Additionally, the characters on each line should also be in
     * reverse order. 
     * 
     * Finally, the contents of the output file should also be returned
     * as a String.
     * 
     * If fname_in does not exist, return "ERROR: NO INPUT"
     * If fname_out fails to open, you should still return the 
     * reversed contents as a String as usual.
     */
    public static String rev_rev_file(String fname_in, String fname_out) 
    {

        return "";
    }

    /* RUNNING THE UNIT TESTS)
     *
     * Evaluate your code by using the following commands in the terminal.
     * Any time you make changes to your code, you will have to run 
     * both commands again. The first one compiles your code and the 
     * tester into two Java class files. The second command runs the
     * unit tests and displays the results.
     *
     * Compile)
     *  javac -cp junit-1.11.0-M2.jar Lab8.java Lab8Test.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c Lab8Test
     *
     * When all test report a pass, you're good to go.
     *  
     */


}