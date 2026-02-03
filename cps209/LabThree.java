public class LabThree 
{
    /*
        Fill in the method below according to the description given
        in the lab document. See the PDF in this archive. 

        You should test your code by calling your method in the main
        method provided. One sample call is given, but you should write 
        your own test cases in main() and try them out as you go.

        Once you're satisfied that your methods are producing the correct
        results, you can scroll down to the very bottom of this file
        for instructions on how to run the unit tests. 

        Note that your official lab grade will be based on the unit tests
        and not what you wrote in main(), but it's still a good idea 
        to practice writing your own main() method. You won't always be
        given unit tests.
    */

    public static void main(String args[])
    {
        String s = reverseVowels("Alex Ufkes");
        System.out.println(s);
    }

    public static String reverseVowels(String text) 
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
     *  javac -cp junit-1.11.0-M2.jar LabThree.java LabThreeTest.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c LabThreeTest
     *
     * When all test report a pass, you're good to go.
     *  
     */
}

