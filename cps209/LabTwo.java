import java.util.Arrays;

public class LabTwo 
{
    /*
        Fill in the methods below according to the descriptions given
        in the lab document. See the PDF in this archive.

        You should test your code by calling your methods in the main
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

    public static void main (String[] args)
    {
        // Add your own tests here!

        int[] a1 = {42, 99, 17, 33};
        int[] b1 = everyOther(a1);

        System.out.println();
        System.out.println(Arrays.toString(b1));
    }

    public static int[] everyOther(int[] a) 
    {
        int len = a.length/2;
        if (a.length%2!=0) len++;
            int[] res = new int[(len)];
        int x = 0;
        for (int i=0; i<a.length; i++) {
            if (i%2==0) {
                res[x]=a[i];
                x++;
            }
        }
        return res;
    }

    public static int[][] createZigZag(int rows, int cols, int start) 
    {
        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (i % 2 != 0) { 
                    res[i][cols - 1 - j] = start;
                } else {
                    res[i][j] = start;
                }
                start++;
            }
        }
        return res;
    }
    

    public static void reverseAscendingSubarrays(int[] items) 
    {
        int start = 0;
        for (int i=0; i<items.length;i++) {
            if (i == items.length - 1 || items[i] >= items[i + 1]) {
                int left = start;
                int right = i;
                while (left < right) {
                    int temp = items[left];
                    items[left] = items[right];
                    items[right] = temp;

                    left++;
                    right--;
                }
                start = i+1;
            }
        }
    }
    

    public static String pancakeScramble(String text) 
    {
        char[] chararr = text.toCharArray();
        for (int i=0; i<chararr.length;i++) {
            int left = 0;
            int right = i;
            while (left < right) {
                char temp = chararr[left];
                chararr[left]=chararr[right];
                chararr[right]=temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chararr);
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
     *  javac -cp junit-1.11.0-M2.jar LabTwo.java LabTwoTest.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c LabTwoTest
     *
     * When all test report a pass, you're good to go.
     *  
     */
}

