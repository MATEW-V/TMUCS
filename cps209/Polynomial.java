
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
        int last = -1;
        for (int i=coefficients.length-1; i>=0; i--) {
            if (coefficients[i]!=0) {
                last=i;
                break;
            }
        }
        if (last == -1) {
            coeff = new int[]{0};
        } else {
            coeff = new int[last+1]; // Modify this -> size w/ourt trail 0s
            for (int i=0; i<=last; i++) {
                coeff[i]=coefficients[i];
            }
        }
    }
    
    public int getDegree() 
    {
        return coeff.length-1;
    }
    
    public int getCoefficient(int k) 
    {
        if (k<0) {
            return 0;
        } else if (k<=coeff.length-1) {
            return coeff[k];
        } else {
            return 0;
        }
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