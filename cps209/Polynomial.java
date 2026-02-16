
public class Polynomial 
{
    private final int[] coeff;
    
    public Polynomial(int[] coefficients) {   
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
            coeff = new int[last+1];
            for (int i=0; i<=last; i++) {
                coeff[i]=coefficients[i];
            }
        }
    }
    
    public int getDegree() {
        return coeff.length-1;
    }
    
    public int getCoefficient(int k) {
        if (k<0) {
            return 0;
        } else if (k<=coeff.length-1) {
            return coeff[k];
        } else {
            return 0;
        }
    }

    public static int powerLoop(int base, int exponent) {
        int result = 1;
        if (exponent == 0) {
            return 1;
        }
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public long evaluate(int x) {
        long eval = 0;
        for (int i=0; i<coeff.length; i++) {
            eval += getCoefficient(i)*(powerLoop(x, i));
        }
        return eval;
    }
    
    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(this.getDegree(), other.getDegree());
        int[] res = new int[maxDegree + 1];
        
        for (int i = 0; i <= maxDegree; i++) {
            int value1 = this.getCoefficient(i);
            int value2 = other.getCoefficient(i);
            res[i] = value1 + value2;
        }
        return new Polynomial(res);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int degree = getDegree();

        for (int i = degree; i >= 0; i--) {
            int coeffS = getCoefficient(i); 
            if (coeffS == 0) continue;

            if (sb.length() > 0) {
                sb.append(coeffS > 0 ? " + " : " - ");
            } else if (coeffS < 0) {
                sb.append("-");
            }
            int absCoeff = Math.abs(coeffS);

            if (i == 0) {
                sb.append(absCoeff);  // Always show constant term coefficient
            } else if (i == 1) {
                sb.append(absCoeff + "x");  // Always show coefficient for linear term
            } else {
                sb.append(absCoeff + "x^" + i);  // Always show coefficient for higher terms
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    /* RUNNING THE UNIT TESTS)
    
     * Compile)
     *  javac -cp junit-1.11.0-M2.jar Polynomial.java PolynomialTestOne.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c PolynomialTestOne
     *
     * When all test report a pass, you're good to go.
     */
}