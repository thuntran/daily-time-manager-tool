class Todo {
    String task;
    int hours;
    int minutes;
    int seconds;

    public Todo(String task, int hours, int minutes, int seconds) { // constructor
        this.task = task;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString() {
        return task + " - " + hours + ":" + minutes + ":" + seconds;
    }
    
}
