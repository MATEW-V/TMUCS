public class Book implements Comparable<Book> 
{
    /* 
     * FULL NAME:  Matthew Vuong
     * STUDENT ID: 501348434
     */

    /*
     * This class represents a book
     * Books have at least two attributes: a title and a base price.
     *
     * Fill in the methods below, and test your solution using the 
     * following commands:
     * 
     * Compile)     javac -cp junit-1.11.0-M2.jar Book.java BookTest.java
     * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c BookTest 
     *  
     * This class is worth 20 marks in total:
     *  Setters and getters: 4 marks
     *  calculatePrice(): 2 marks
     *  equals(): 4 marks
     *  compareTo(): 6 marks
     *  toString(): 4 marks
     */
    
    /* TO BE COMPLETED */
    // Declare instance variables here (if necessary). 
    // Ensure they are all private.
    private String bTitle = "";
    private double bPrice = 0;
   
    /* TO BE COMPLETED */
    public Book(String title, double basePrice) 
    {
        // The constructor for Book
        // Initialize any instance variables here (if necessary)
       bTitle = title;
       bPrice = basePrice;
    }

    /* COMPLETE SETTERS AND GETTERS BELOW */
    public String getTitle() { return this.bTitle; }
    public double getBasePrice() { return this.bPrice; }
    public void setTitle(String title) { this.bTitle = title;}
    public void setBasePrice(double basePrice) { this.bPrice = basePrice;}

    /* TO BE COMPLETED */
    public double calculatePrice() 
    {
        // This method calculates the price of the book.
        // start with the base price, and add 13% tax.
        
        return (this.bPrice)*(1.13);
    }

    /* TO BE COMPLETED */
    @Override
    public boolean equals(Object obj) 
    {
        // Two books are considered equal if they have the 
        // same title and base price. 
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return (this.bTitle.equals(other.bTitle) && this.bPrice==other.bPrice);
    }

    /* TO BE COMPLETED */
    @Override
    public int compareTo(Book other) 
    {
        // Books should be compared based on their base price. 
        // Lower priced books should come first.
        // If two books have the same base price, they should be
        // ordered alphabetically by title.
        if (other.bPrice < this.bPrice) {
            return 1;
        } else if (other.bPrice > this.bPrice) {
            return -1;
        } else {
            if (other.bTitle==this.bTitle) {
                return 0;
            } else {
                return this.bTitle.compareTo(other.bTitle);
            }
        }
    }

    /* TO BE COMPLETED */
    @Override
    public String toString()    
    {
        // Return a string representation of the book.
        // The format should be: Book[title@$basePrice]
        // For example: Book[The Great Gatsby@$10.00]
        // The price should be formatted to 2 decimal places.
        String format = String.format("%.2f", this.bPrice); //imprtnt
        return "Book["+this.bTitle+"@$"+format+"]";
    }
}