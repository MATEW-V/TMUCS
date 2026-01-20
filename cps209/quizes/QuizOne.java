package quizes;

public class QuizOne {

 public static void main(String args[])
 {

    int a, b, c;
    a=5;
    b=5;
    c=5;
    //Verify the variables can be part of a triangle=====================

    System.out.println("Can integers: a: "+ a+", b: "+b+", and c: "+c +" form a triangle? "+ canBeTriangle(a,b,c));
    a=1;
    b=2;
    c=3;
    System.out.println("Can integers: a: "+ a+", b: "+b+", and c: "+c +" form a triangle? "+ canBeTriangle(a,b,c));
    //====================================================================

    //Execute FizzBuzz function

    fizzBuzz(110);
    fizzBuzz(6);

 }

public static boolean canBeTriangle(int num1, int num2, int num3) {
    if ((num1 + num2 > num3) && (num2 + num3 > num1) && (num3 + num1 > num2)) {
        return true;
    }
    return false;
}

public static void fizzBuzz(int N)
{
    //Divisible by 3 and 5
    //3: Fizz
    //5: Buzz
    if (N>100) {
        System.out.println("Too much work, no thanks");
        return;
    } 
    if (N<1) {
        System.out.println("N must be greater than 1");
        return;
    } 

    for (int i=1; i<=N; i++) {
        if ((i%3==0)&&(i%5==0)) {
            System.out.println("FizzBuzz");
        } else if (i%3==0) { 
            System.out.println("Fizz");
        } else if (i%5==0) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }
}

}
