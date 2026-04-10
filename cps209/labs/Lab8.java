package labs;
import java.io.*;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;

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
        if (denominator == 0) {
            if (numerator == 0) {
                throw new UnsupportedOperationException();
            }
            throw new ArithmeticException();
        }
        double nn = (double) numerator;
        double dd = (double) denominator;

        return nn/dd;
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
    public static class InvalidTemperatureException extends RuntimeException {
        public InvalidTemperatureException() {
            super("Temperature is below absolute zero (-273.15C)");
        }
    }
    public static double convertCelsiusToFahrenheit(String celsiusTemp) throws InvalidTemperatureException
    {
        if (celsiusTemp == null) {
            throw new NumberFormatException("Input cannot be null");
        }
        double celsius = Double.parseDouble(celsiusTemp);

        if (celsius < -273.15)
        {
            throw new InvalidTemperatureException();
        }

        return (9.0 / 5.0) * celsius + 32;
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
   public static String file_slice(String fname_in, int first, int last) {
    // Check negative values FIRST
    if (first < 0 || last < 0) throw new NegativeArraySizeException();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fname_in));
            String line;
            int count = 0;
            String res = "";
            
            while ((line = in.readLine()) != null) {  // Read in loop condition
                if (count >= first && count <= last) {
                    if (res.length() > 0) res += "\n";  // Add newline before appending
                    res += line;
                }
                count++;
                // Optional optimization: stop if we've passed 'last'
                if (count > last) break;
            }
            in.close();
            // Check if first line exists after reading 
            if (last<first) throw new NegativeArraySizeException();
            if (first >= count) throw new IndexOutOfBoundsException();
           
            return res;
        
        } catch (IOException e) {
            System.out.println("Wasd");
            return "";
        }
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
        if (fname_in == null) return "ERROR: NO INPUT";
        String line;
        String res = "";
        ArrayList<String> cont = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fname_in));
            while ((line = in.readLine()) != null) {
                String sbline = new StringBuilder(line).reverse().toString();
                cont.add(sbline);
            }
            in.close();
            Collections.reverse(cont);
            for (int i = 0; i < cont.size(); i++) {
                if (i > 0) res += "\n";
                res += cont.get(i);
            }
            try {
                if (fname_out!=null) {
                Writer out = new FileWriter(fname_out);
                for (int i = 0; i < cont.size(); i++) {
                    String s = cont.get(i);
                    out.write(s);
                    if (i < cont.size() - 1) {
                        out.write("\n");
                    }
                }
                out.close();
            }
            } catch (IOException e) {}
        } catch (IOException e) {
            return "ERROR: NO INPUT";
        }
        return res;
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