package finalspractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Need to add the implementation for the Comparable Interface
class Bucket implements Comparable<Bucket>{
    public String colour;
    public String things;
    public int quantity;

    public Bucket(String c, String t, int q){
        this.colour = c;
        this.things = t;
        this.quantity = q;
    }

    // Overide the toString method to give us valuable info when printing
    @Override
    public String toString(){
        return colour + " bucket contains " + quantity + " " + things ;
    }
    @Override
    public int compareTo(Bucket other) {
        return this.quantity-other.quantity;
    } 
    // We can make nested Comparator classes to keep our relevant
    // information together. The other class we made is separate from
    // the Bucket class, but its whole purpose is to work with Bucket
    // objects. Although this keeps them together, it is more work for
    // us to create an instance of this class compared to the other
    // comparator class.

    // static class bThingCompareTo() implements Comparable<Bucket>{
    //     public int compareTo(Bucket b1, Bucket b2) {
    //         return (b1.things.compareTo(b2.things));
    //     }
    // }
    static class ColorComparator implements Comparator<Bucket> {

        @Override
        public int compare(Bucket o1, Bucket o2) {
            if (o1.colour.compareTo(o2.colour)==0) {
                return o1.quantity-o2.quantity;
            }
            return o1.colour.compareTo(o2.colour);
        }

    }
}

// Classes that implement Comparator allow us to create alternate ways
// to compare our Bucket objects to each other. Instances of this class
// can be used with Collections.sort(_,_) to sort our objects using this
// metric for comparing the object rather than the previously defined
// Comparable method defined within the Bucket class




public class interfaceA {
    
    public static void main(String[] args) {
        // Each bucket has a colour, a thing that it contains, and the quantity that it contains
        // Want to have a collection of buckets, each with different attributes
        System.out.println();

        Bucket b1 = new Bucket("Red", "Crabs", 17);
        Bucket b2 = new Bucket("Blue", "Spiders", 3);
        Bucket b3 = new Bucket("Green", "Toys", 2);
        Bucket b4 = new Bucket("Orange", "Crabs", 8);

        ArrayList<Bucket> shelf = new ArrayList<Bucket>();

        shelf.add(b1);  shelf.add(b2);  shelf.add(b3);  shelf.add(b4);

        // Sort the shelf in order of quantity
        // Can't use Collections.sort on an object that doesn't implement Comparable
        Collections.sort(shelf);

        System.out.println(shelf);
        System.out.println();

        // Sort the shelf in order of Colour
        // Default comparison uses the quantity, we need a new way to compare objects
        // Make a Comparator object with its own way to compare Buckets

        

        // Use the comparator as the second argument in the method call
        
        System.out.println(shelf);
        System.out.println();

        // Sort the shelf in order of Thing
        // Default comparison uses the quantity, we need a new way to compare objects
        // Make another Comparator object with its own way to compare Buckets

        Bucket.ColorComparator mcc = new Bucket.ColorComparator();
        Collections.sort(shelf, mcc);
        System.out.println(shelf);
        System.out.println();
        // Use the comparator as the second argument in the method call
        
        System.out.println(shelf);
        System.out.println();
    }
}