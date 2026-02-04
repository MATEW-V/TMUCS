package quizes;

public class QuizThree {
    public static void main(String args[]) {
        Course cs1 = new Course("cps109");
        cs1.setYear(2026);
        cs1.setSem("fall");
        cs1.setLabTime(10, 12);
        cs1.setLecTime(8, 9);
        Course cs2 = new Course("cps209");
        cs2.setYear(2026);
        cs2.setSem("winter");
        cs2.setLabTime(1, 2);
        cs2.setLecTime(3, 6);
        Course cps383 = new Course("cps383");
        cps383.setYear(2027);
        cps383.setSem("fall");
        cps383.setLabTime(17, 20); //overlap
        cps383.setLecTime(16, 17); //overlap
        Course cps510 = new Course("cps510");
        cps510.setYear(2028);
        cps510.setSem("spring");
        cps510.setLabTime(10, 13);
        cps510.setLecTime(6, 9);
 }
}

