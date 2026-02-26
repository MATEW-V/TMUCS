public class TextBook extends Book 
{
    /* 
     * FULL NAME:  <your full name here>
     * STUDENT ID: <your student ID here>
     */

    /*
     * This class represents a textbook, which extends the Book class.
     * Textbooks have an associated course code and a 20% markup on the base price.
     *
     * Fill in the methods below, and test your solution using the 
     * following commands:
     * 
     * Compile)     javac -cp junit-1.11.0-M2.jar Book.java TextBook.java TextBookTest.java
     * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c TextBookTest 
     *  
     * This class is worth 10 marks in total:
     *  Setter and getter: 2 marks
     *  calculatePrice(): 2 marks
     *  equals(): 3 marks
     *  toString(): 3 marks
     */

    /* TO BE COMPLETED */
    // Declare instance variables here (if necessary). 
    // Ensure they are all private.
    private String courseCode;
    /* TO BE COMPLETED */
    public TextBook(String title, double basePrice, String courseCode) 
    {
        // The constructor for TextBook should initialize instance 
        // variables (if necessary) and call the superclass constructor.
        super(title, basePrice);
        this.courseCode = courseCode;
    }

    /* COMPLETE SETTER AND GETTER BELOW */ 
    public String getCourseCode() { return this.courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode;}    
    
    /* TO BE COMPLETED */
    @Override
    public double calculatePrice() 
    {
        // Textbooks have a 20% markup on the base price.
        // This markup should be added before the 13% tax.

        return super.getBasePrice() * 1.20 * 1.13;
    }

    /* TO BE COMPLETED */
    @Override
    public boolean equals(Object obj) 
    {
        // Two textbooks are considered equal if they have the same 
        // title and the same course code. Price is not considered for 
        // textbook equality. 
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextBook other = (TextBook) obj;
        return (super.getTitle().equals(other.getTitle()) && courseCode.equals(other.getCourseCode()));
        
    }

    /* TO BE COMPLETED */
    @Override
    public String toString() 
    {
        // Return a string representation of the textbook.
        // The format should be: courseCode:TextBook[title@$basePrice]
        // For example: CSC1009:TextBook[The Great Gatsby@$10.00]
        // The price should be formatted to 2 decimal places.

        return this.courseCode+":Text"+super.toString();
    }
}