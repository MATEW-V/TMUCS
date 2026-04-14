package finalspractice;

public class StudentQ {
    private String name;
    private int age;
    private Double gpa;

    public StudentQ(String name, int age, double gpa) {
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
        StudentQ mv = new StudentQ("matew", 11, 6.7);
        System.out.println(mv);
    }
}

