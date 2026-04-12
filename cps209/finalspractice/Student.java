package finalspractice;

public class Student {
    private String name;
    private int age;
    private Double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    public String getName() { return name;}
    public int getAge() { return age;}
    public Double getGPA() { return gpa;}

    @Override
    public String toString() {
        return (this.name + "(age: "+this.age+", GPA: "+this.gpa+")");
    }

    public static void main(String args[]) {
        Student mv = new Student("matew", 11, 6.7);
        System.out.println(mv);
    }
}

