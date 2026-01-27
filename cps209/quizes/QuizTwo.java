package quizes;

public class QuizTwo {
    
 public static void main(String args[])
 {
    for(Integer num: divisors(12)) {
    System.out.print(num+ " ");
    }
    System.out.println(" ");
    System.out.print(parseInt("a5b4c3"));
 }

public static int[] divisors(int n) {
  int count = 0;
  for (int i=1; i<=n; i++) {
    if (n%i==0) count++;
  }
  int[] result = new int[count];
  count = 0;
  for (int i=1; i<=n; i++) {
    if (n%i==0) {
        result[count++]=i; 
    } 
  }
    return result;
  }

public static int parseInt(String s ) {
    String res = "";
    for (char i: s.toCharArray()) {
        if (Character.isDigit(i)) {
            res+=i;
        }
    } return Integer.parseInt(res);    
}
}
