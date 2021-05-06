class Todo extends TT_SH_Project{
    private String task;
    private int hours;
    private int minutes;
    private int seconds;
    private boolean complete;

    public Todo (String task, int hours, int minutes, int seconds) { // constructor
        this.task = task;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.complete = false;
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

    public void setComplete(boolean complete) { // setter: set the value for complete
        this.complete = complete;
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

    public boolean getComplete() { // getter: get complete
        return complete;
    }

    public String toString() {
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);
        return task + " - " + hours_string + ":" + minutes_string + ":" + seconds_string;
    }

    public String printTask() { // print the task only
        return task;
    }
    
}
