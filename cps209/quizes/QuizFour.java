package quizes;

public class QuizFour {

    public static void main(String args[]) {
        Student st1 = new Student("name1", 18);
        st1.addCourse("CPS209");
        st1.addCourse("CPS109");
        st1.addCourse("CPS310");
        st1.removeCourse("CPS109");
        Student st2 = new Student("name2", 38);
        st2.addCourse("CPS109");
        st2.addCourse("CPS109");
        st2.addCourse("CRM100");
        Student st3 = new Student("name3", 8);
        st3.addCourse("ASL101");
        st3.addCourse("CPS209");
        st3.addCourse("CRM100");

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
    }
}