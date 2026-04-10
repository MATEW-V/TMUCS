package labs;
public class BigO extends Polynomial {
    
    private String category;
    
    public BigO(int[] coefficients) {
        super(coefficients);
        int degree = getDegree();
        
        if (degree == 0) {
            category = "constant";
        } else if (degree == 1) {
            category = "linear";
        } else if (degree == 2) {
            category = "quadratic";
        } else if (degree == 3) {
            category = "cubic";
        } else {
            category = "polynomial";
        }
    }
    
    public String getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        int degree = getDegree();
        
        if (degree == 0) {
            return "O(1)";
        } else if (degree == 1) {
            return "O(n)";
        } else {
            return "O(n^" + degree + ")";
        }
    }
}