package quizes;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class ToDoList {
        public static void main(String args[]) {
            Task t1 = new Task("task1", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t2 = new Task("task2", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t3 = new Task("task3", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t4 = new Task("task4", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t5 = new Task("task5", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t6 = new Task("task6", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t7 = new Task("task7", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t8 = new Task("task8", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t9 = new Task("task9", (int) (Math.random()*100), (int) (Math.random()*100));
            Task t10 = new Task("task10", (int) (Math.random()*100), (int) (Math.random()*100));

            ToDoList t = new ToDoList();
            t.addTask(t1);
            t.addTask(t2);
            t.addTask(t3);
            t.addTask(t4);
            t.addTask(t5);
            t.addTask(t6);
            t.addTask(t7);
            t.addTask(t8);
            t.addTask(t9);
            t.addTask(t10);

            System.out.println(t.orderedInString()); // ordered by added
            System.out.println(t);
            t.removeOdd();
            System.out.println(t);
            System.out.println(t.size());


        }

    private PriorityQueue<Task> toDoQueue;
    private ArrayList<Task> orderIn;

    public ToDoList() {
        toDoQueue = new PriorityQueue<>();
        orderIn = new ArrayList<>();
    }

    public void addTask(Task task) {
        toDoQueue.add(task);
        orderIn.add(task);
    }

    public void getNext() {
        toDoQueue.poll();
    }
    
    public int size() {
        return toDoQueue.size();
    }

    public String orderedInString() {
        return orderIn.toString();
    }

    @Override
    public String toString() { // prio format
        String res = "";
        PriorityQueue<Task> temp = new PriorityQueue<>(toDoQueue);
        while (!temp.isEmpty()) {
            res+=""+temp.poll();
        }
        return res;
    }

    public void removeOdd() {
        PriorityQueue<Task> temp = new PriorityQueue<>();

        while (!toDoQueue.isEmpty()) {
            Task t = toDoQueue.poll();
            if (t.getPriority()%2==0) {
                temp.add(t);
            }
        } 
        toDoQueue = temp;
    }
}

