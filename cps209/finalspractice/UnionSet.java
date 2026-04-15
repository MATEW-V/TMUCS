package finalspractice;

import java.util.HashSet;

public class UnionSet<T> extends HashSet<T>{

    // Create a static HashSet object that will contain every
    // unique object (of type Object) that is added to ANY
    // UnionSet object.
    public static HashSet<Object> hs = new HashSet<Object>();

    // No Constructor Method

    // Override the add() method
    @Override
    public boolean add(T newObj){
        hs.add(newObj);
        return super.add(newObj);

    }

    // Override the remove() method - just a wrapper
    // Do not remove it from the global set
    @Override
    public boolean remove(Object remObj){
        return super.remove(remObj);
    }

    // Output the static, union set
    public HashSet<Object> getGlobalSet(){
        return hs;
    }

    // Output true if the global set contains the given
    // object, otherwise return false
    public Object globalContains(Object element){
        if (hs.contains(element)) return true;
        return false;
    }

    public static void main(String[] args) {
        
        // Create 3 different UnionSets containing Strings
        UnionSet<String> names = new UnionSet<>();
        names.add("Paul");      names.add("John");
        names.add("George");    names.add("Ringo");

        System.out.println("==========");
        System.out.print( "Local Set:  ");
        System.out.println( names );
        System.out.print("Global Set: ");
        System.out.println( names.getGlobalSet() );

        UnionSet<String> courses = new UnionSet<>();
        courses.add("CPS209");
        courses.add("CPS310");

        System.out.println("\n==========");
        System.out.print( "Local Set:  ");
        System.out.println( courses );
        System.out.print("Global Set: ");
        System.out.println( courses.getGlobalSet() );

        UnionSet<String> moreNames = new UnionSet<>();
        moreNames.add("Steve");
        moreNames.add("Paul");
        moreNames.add("Bruce");

        System.out.println("\n==========");
        System.out.print( "Local Set:  ");
        System.out.println( moreNames );
        System.out.print("Global Set: ");
        System.out.println( moreNames.getGlobalSet() );
    }
}