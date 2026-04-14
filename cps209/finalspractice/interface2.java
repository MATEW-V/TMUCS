package finalspractice;

import java.util.ArrayList;
import java.util.Collections;


/* Classroom example using Interfaces
 * 
 * A classroom consists of Student objects and Teacher objects
 * Students have a first name, last name, favourite colour, and a height.
 * Teachers have a prefix (Mr. Mrs. Ms. Dr. etc), last name, and subject that they teach.
 * Both of these classes implement the Human interface, seen below.
 * 
 * For each class, create an appropriate constructor to assign values to the instance variables.
 * Implement the required functions for each class. Note that the student class also implements the
 * Comparable interface. This is because student objects can be sorted by their height (tallest
 * student first). Feel free to create any additional methods necessary to confirm that your
 * functions are working correctly.
 * 
 * The Comparable interface contains the int compareTo method
 */

// Given Human interface
interface Human{
    public void greetStudent(Student child);
    public String getName();
}

// Student class
// If Timmy Turner (favourite colour blue) greeted a student named John Doe, Timmy would say:
// "Hello, John. My name is Timmy and my favourite colour is Blue."

// Implement the Comparable interface to sort students from tallest to smallest

class Student implements Human, Comparable<Student>{
    private String fname;
    private String lname;
    private String fc;
    private int h;

    // Create constructor for Student class, ~ 5 lines
    public Student(String fname, String lname, String fc, int h) {
        this.fname = fname;
        this.lname = lname;
        this.fc = fc;
        this.h = h;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.h, this.h);
    }

    @Override
    public void greetStudent(Student child) {
        System.out.println("Hello "+child.getName()+". My name is "+fname+" and my favorite color is "+fc);
    }

    @Override
    public String getName() {
        return fname;
    }
    public String getFullName() {
        return fname + " " + lname;
    }
}

// Teacher class
// If Mr. Walker (teaches Math) greeted a student named John Doe, Mr. Walker would say:
// "Hello, John. My name is Mr. Walker and I teach Math."

class Teacher implements Human{
    private String prefix;
    private String lastName;
    private String subject;

    public Teacher(String pre, String lname, String sub) {
        prefix = pre;
        lastName = lname;
        subject = sub;
    }
    @Override
    public void greetStudent(Student child) {
       System.out.println("Hello, "+child.getName()+". My name is "+this.getName()+" and I teach "+subject);
    }
    @Override
    public String getName() {
        return prefix+" "+lastName;
    }

}

public class interface2 {

    // Given an arraylist of Human variables, every Human greets the new Student (newStud)
    static void classGreetsNewStudent(ArrayList<Human> classroom, Student newStud){
        for (Human person : classroom){
            person.greetStudent(newStud);
        }
    }
    // Given an arraylist of Students, display the names of the students
    static void printOrder(ArrayList<Student> students){
        for (Student i : students){
            System.out.println(i.getName());
        }
    }

    public static void main(String[] args){

        System.out.println("Actual:");
        /* Description of people in the class:
         * Mr. Walker teaches Math class
         * Timmy Turner, favourite colour is blue, 68cm tall
         * Kelly Crazy, favourite colour is red, 57cm tall
         * Paul Jude, favourite colour is green, 70cm tall
         * 
         * New student:
         * John Doe, favourite colour is purple, 55cm tall
         */

        ArrayList<Human> cRoom = new ArrayList<Human>();
        //classroom of the peoiple
        Student tt = new Student("Timmy", "Turner", "Blue", 68);
        Student kc = new Student("Kelly", "Crazy", "Red", 57);
        Student pj = new Student("Paul", "Jude", "Green", 70);
        Teacher w = new Teacher("Mr.", "Walker", "Math");
        //freshie
        Student jd = new Student("John", "Doe", "Purple", 55);
        cRoom.add((Human)w);
        cRoom.add((Human)tt);
        cRoom.add((Human)kc);
        cRoom.add((Human)pj);
        
        for (Human x: cRoom) {
            x.greetStudent(jd);
        }
        cRoom.add((Human)jd);
        // Create an arraylist of all the Students, sort them using the Collections library.
        // Use the printOrder(ArrayList<Student>) method defined above to display the new order. ~ 4 lines
        ArrayList<Student> studArr = new ArrayList<Student>();
        studArr.add(tt);
        studArr.add(kc);
        studArr.add(pj);
        studArr.add(jd);

        Collections.sort(studArr);
        for (Student i: studArr) {
            System.out.println(i.getName());
        }
        // End of code
        System.out.println("Expected:\nHello, John. My name is Mr. Walker and I teach Math.\nHello, John. My name is Timmy and my favourite colour is blue.\nHello, John. My name is Kelly and my favourite colour is red.\nHello, John. My name is Paul and my favourite colour is green.\nPaul\nTimmy\nKelly\nJohn");
    }
    
}