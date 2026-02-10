package quizes;
import java.util.ArrayList;

class Student extends Person {
    private ArrayList<String> course = new ArrayList<>();
    public Student(String name, int age) {
        super(name, age);
    }
    public void addCourse(String course) {
        this.course.add(course);
    }
    public void removeCourse(String course) {
        this.course.remove(course);
    }
    @Override
    public String toString() {
        String courseFormat = "";
        String studentName = super.getName();
        int studentAge = super.getAge(); 
        for (String c: this.course) {
            courseFormat +=(c+"\n");
        }
        return "Student Name: "+studentName+"\nStudent Age: "+studentAge+"\nCourses: \n"+courseFormat;
    }
}
