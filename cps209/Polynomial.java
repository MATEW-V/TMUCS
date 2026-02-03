import java.util.Arrays;

public class Polynomial 
{

    /*
        Fill in the methods below according to the descriptions given
        in the lab document. See the PDF in this archive.

        To test your code, you can scroll down to the very bottom of this 
        file for instructions on how to run the unit tests. 

        Note that your official lab grade will be based on the proportion
        of unit tests that you pass.        
    */

    private final int[] coeff;
    
    public Polynomial(int[] coefficients) 
    {
        
        coeff = new int[1]; // Modify this
    }
    
    public int getDegree() 
    {
        
        return -1; // Modify this
    }
    
    public int getCoefficient(int k) 
    {
       
        return 0; // Modify this
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
     *  javac -cp junit-1.11.0-M2.jar Polynomial.java PolynomialTestOne.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c PolynomialTestOne
     *
     * When all test report a pass, you're good to go.
     *  
     */
}