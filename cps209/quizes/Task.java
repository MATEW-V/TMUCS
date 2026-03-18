package quizes;
public class Task implements Comparable<Object>{
    private String task;
    private int dur; 
    private int priority;

    public Task(String task, int dur, int priority) {
        this.task = task;
        this.dur = dur;
        this.priority = priority;

    }

    public String getTask() { return task; }
    public int getDur() { return dur; }
    public int getPriority() {return priority; }

    @Override
    public int compareTo(Object obj) {
        Task other = (Task) obj;
        return Integer.compare(this.getPriority(), other.getPriority());
    }
    @Override
    public String toString() {
        return "Name: "+task+"\n Priority: "+priority+"\n Duration: "+dur+" minutes.\n";
    }
    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == this) return true;
    //     if (!(obj instanceof Task)) return false;
    //     Task other = (Task) obj;

    //     return ()
    // }

}
