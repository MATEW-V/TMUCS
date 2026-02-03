package quizes;

public class Course {
    String courseCode; 
    private String semester;
    private int start1, end1, start2, end2, year;

    public Course(String cc) {
        courseCode = cc;
    }
    public void setSem(String sem) {
        if (sem.equals("fall") || sem.equals("winter")|| sem.equals("spring")) {
            semester = sem;
        } else {
            System.out.println("invalid sem");
        }
    }
    public void setLecTime(int startLec, int endLec) {
        if (startLec >=0 && startLec <=23 && endLec >=0 && endLec <=23) {
            start1 = startLec;
            end1 = endLec; 
        } else {
            System.out.println("Lectures cannot be more than a day.");
        }
        overlapLecLab();

    }
    public void setLabTime(int startLab, int endLab) {
        if (startLab >=0 && startLab <=23 && endLab >=0 && endLab <=23) {
            start2 = startLab;
            end2 = endLab; 
        } else {
            System.out.println("Labs cannot be more than a day.");
        }
        overlapLecLab();
    }
    public void setYear(int cYear) {
        year = cYear;
    }
    private void overlapLecLab() {
        if (start1<end2 && start2<end1){
            System.out.println("overlapping lectures / labs");
        }
    }
    public int getLecStart() {
        return start1;
    }
    public int getLabStart() {
        return start2;
    }
    public int getLecEnd() {
        return end1;
    }
    public int getLabEnd() {
        return end2;
    }
    public int getYear() {
        return year;
    }
    public String getSemester() {
        return semester;
    }
}