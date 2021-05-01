class Todo {
    private String task;
    private int hours;
    private int minutes;
    private int seconds;

    public Todo (String task, int hours, int minutes, int seconds) { // constructor
        this.task = task;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setTask(String task) { // setter: set the value for task
        this.task = task;
    }

    public void setHours(int hours) { // setter: set the value for hours
        this.hours = hours;
    }

    public void setMinutes(int minutes) { // setter: set the value for minutes
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) { // setter: set the value for seconds
        this.seconds = seconds;
    }

    public String getTask() { // getter: get the task
        return task;
    }

    public int getHours() { // getter: get the hours
        return hours;
    }

    public int getMinutes() { // getter: get the minutes
        return minutes;
    }

    public int getSeconds() { // getter: get the seconds
        return seconds;
    }

    public String toString() {
        return task + " - " + hours + ":" + minutes + ":" + seconds;
    }

    public String printTask() { // print the task only
        return task;
    }
    
}
