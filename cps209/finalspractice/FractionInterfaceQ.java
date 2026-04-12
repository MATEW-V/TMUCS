package finalspractice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/* Complete the Fraction class below to meet the following requirements
    - Fraction objects should have an int numerator and denominator. Make them private variables

    - Constructor should receive two integers and assign the values to numerator and denominator respectively.
    >>> If trying to make a Fraction with a denominator of 0, throw an ArithmeticException instead of returning the object.

    - Create a method called reduce() that attempts to simplify the fraction by dividing the numerator and denominator
      by their greatest common factor (the largest number that cleanly divides both of them). For example, the fraction
      25/30 can be reduced to 5/6 by dividing the numerator and denominator by the common factor 5. 
      If the fraction cannot be reduced, do not change the numerator and denominator.

    - Define the toString() method that returns a string representing the fraction
    >>> If the fraction is an Improper Fraction (the numerator is larger than the denominator), display the fraction
        as a Mixed Number instead. For example, the fraction 7/4 should output "1 3/4"
    >>> If the fraction is not an Improper Fraction, just output the fraction. 3/51 should return the string "3/51"

    - Implement the Comparable Interface and define the compareTo method. The fraction representing the larger value
      should be considered larger than the other fraction.   7/4  >  3/51     
      Two fractions can be considered equal in value despite having different numerators and denominators    1/2 == 2/4

    - Implement the Comparator class called NumSlicesComparator and define the compare method. Rather than comparing fractions
      based on their represented value, you are comparing fractions based on the number of slices they contain. For example, if
      we had a pizza divided into 12 pieces, and there are 7 slices remaining, this would be the fraction 7/12. A pizza divided into
      6 slices with 5 slices remaining would be the fraction 5/6. Although the fraction 5/6 is greater than 7/12, there are more
      slices remaining in the 7/12 pizza, so 7/12 would be considered greater by this Comparator.
      Hint: which part(s) of the Fraction class represents the number of remaining number of slices?

*/

class Fraction implements Comparable<Fraction>{
    private int num;
    private int denom;
    public Fraction(int num, int denom) {
        this.num=num;
        this.denom=denom;

        if (denom == 0) throw new ArithmeticException("Cannot divide by 0");
    }
    public int getNum(){ return num;}
    public int getDenom(){ return denom;}

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void reduce(){
        int gcd = gcd(this.num, this.denom);
        this.num=this.num/gcd;
        this.denom=this.denom/gcd;
    }
    @Override
    public String toString() {
        if (num>denom) {
            int whole = num/denom;
            int newnumer = num%denom;
            return ""+whole+" "+newnumer+"/"+denom;
        } else {
            return ""+num+"/"+denom;
        }
    }
    @Override
    public int compareTo(Fraction o) {
        Double c1 = (this.num + 0.0)/(this.denom + 0.0);
        Double c2 = (o.num + 0.0)/(o.denom + 0.0);
        if (c1>c2) { return 1; }
        if (c2>c1) { return -1;}
        return 0;
    }
}

class NumSlicesComparator implements Comparator<Fraction>{
    @Override
    public int compare(Fraction o1, Fraction o2) {
        return o1.getNum()-o2.getNum();
    }
}

public class FractionInterfaceQ {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    static String validate(Object o1, Object o2){
        if (o1.equals(o2)){
            return "\t" + ANSI_BLUE + "PASS" + ANSI_RESET;
        }
        else{
            return "\t" + ANSI_RED + "FAIL" + ANSI_RESET;
        }
    }

    public static void main(String[] args) {
        // Testing Code - You can comment out sections to just test certain parts, but don't modify

        // Creating Instances
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(2, 4);
        Fraction c = new Fraction(25,30);
        Fraction d = new Fraction(5, 6);
        Fraction e = new Fraction(7, 4);
        Fraction f = new Fraction(23,7);
        Fraction g = new Fraction(3, 51);
        Fraction h = new Fraction(7, 12);
        Fraction i = new Fraction(5, 6);
        Fraction j = new Fraction(33,21);

        // Printing Fractions using toString()
        System.out.println("\n===== Testing toString =====");
        System.out.println("1. Expected: 1/2  \tActual: " + a + validate("1/2",a.toString()));
        System.out.println("2. Expected: 25/30\tActual: " + c + validate("25/30",c.toString()));
        System.out.println("3. Expected: 1 3/4\tActual: " + e + validate("1 3/4",e.toString()));
        System.out.println("4. Expected: 3 2/7\tActual: " + f + validate("3 2/7",f.toString()));

        // Reducing Fractions
        System.out.println("\n===== Testing reduce =======");
        
        b.reduce(); // Should Reduce
        System.out.println("1. Reducing Fraction 2/4\tExpected: 1/2\tActual: " + b + validate("1/2",b.toString()));
        c.reduce(); // Should Reduce
        System.out.println("2. Reducing Fraction 25/30\tExpected: 5/6\tActual: " + c + validate("5/6",c.toString()));
        e.reduce(); // Not reducable
        System.out.println("3. Reducing Fraction 7/4\tExpected: 1 3/4\tActual: " + e + validate("1 3/4",e.toString()));
        j.reduce(); // Should Reduce, numerator is larger
        System.out.println("4. Reducing Fraction 33/21\tExpected: 11/7\tActual: " + j + validate("1 4/7",j.toString()));
        
        // Resetting variables back to original values
        b = new Fraction(2, 4);
        c = new Fraction(25,30);
        e = new Fraction(7, 4);
        j = new Fraction(33,21);

        // Testing Comparable - sorting Fractions in order of descending value
        ArrayList<Fraction> fracs = new ArrayList<Fraction>();
        fracs.add(b);   fracs.add(c);   fracs.add(d);   fracs.add(e);
        fracs.add(g);   fracs.add(h);   fracs.add(i);   fracs.add(j);
                                            
        System.out.println("\n===== Testing Comparable ===");
        System.out.println("Before:\t" + fracs.toString());
        Collections.sort(fracs);
        System.out.println("After:\t" + fracs.toString() + validate("[3/51, 2/4, 7/12, 25/30, 5/6, 5/6, 1 12/21, 1 3/4]", fracs.toString()));

        // Testing Comparator - sorting Fractions in order of descending number of slices
        System.out.println("\n===== Testing Comparator ===");
        System.out.println("Before:\t" + fracs.toString());
        Collections.sort(fracs, new NumSlicesComparator());
        System.out.println("After:\t" + fracs.toString() + validate("[2/4, 3/51, 5/6, 5/6, 7/12, 1 3/4, 25/30, 1 12/21]", fracs.toString()));

        // Testing Fraction with 0 Denominator
        System.out.println("\n===== Testing 0 Denom ======");
        try {
            System.out.println("Trying to create fraction 3/0");
            Fraction bad = new Fraction(3, 0);
            System.out.println("Fraction created, but it should have failed!\t" + ANSI_RED + "FAIL" + ANSI_RESET);
            System.out.println(bad);
        }
        catch (ArithmeticException err){
            System.out.println("Error successfully caught!\t" + ANSI_BLUE + "PASS" + ANSI_RESET);
        }

        // Extra test cases for reduced Mixed Number modification  ///// UNCOMMENT FOR SPECIAL CASES
        System.out.println("\n===== Testing Reduced Mixed Numbers - BONUS ======");
        Fraction k = new Fraction(81,6);
        Fraction l = new Fraction(217,21);

        System.out.println("1. Fraction 81/6   -> Expected: 13 1/2\tActual: " + k + validate("13 1/2",k.toString()));
        System.out.println("2. Fraction 217/21 -> Expected: 10 1/3\tActual: " + l + validate("10 1/3",l.toString()));
        

    }
}