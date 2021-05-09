import java.util.*;
import java.io.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
   
class TT_SH_Project {
    static ArrayList<Todo> completed = new ArrayList<>(); // arraylist that stores completed tasks
    static ArrayList<Todo> uncompleted = new ArrayList<>(); // arraylist that stores uncompleted tasks
    static Scanner scan = new Scanner(System.in);
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        Scanner fin = null;
        try { // open fin 
            fin = new Scanner(new File("tasks.txt")); // read the file
        } catch (IOException ex) { // IOException: input-output exception
            System.out.print(ex);
        }
        while (fin.hasNext()) { // while next line still exists (read till end of file)
            String task = fin.nextLine();
            String [] taskList = task.split(","); // store all the fields of the task into an array
            String taskName = taskList[0]; // assign values to the fields of the new Todo object
            int taskHours = Integer.parseInt(taskList[1]);
            int taskMinutes = Integer.parseInt(taskList[2]);
            int taskSeconds = Integer.parseInt(taskList[3]); 
            boolean taskBoolean = Boolean.parseBoolean(taskList[4]);
			Todo fileTask = new Todo (taskName, taskHours, taskMinutes, taskSeconds, taskBoolean); //create new Todo object with information
            if (taskBoolean == true){ // if true, add task to completed list
                completed.add(fileTask);
            }
            else if (taskBoolean == false){ // if false, add task to uncompleted list
                uncompleted.add(fileTask);
            }
        }
        fin.close(); // close the file
        System.out.print("Today's date is: "); getDate(); // print current date
        System.out.println(ANSI_GREEN + "\nDAILY TIME MANAGER" + ANSI_RESET + "\nThis is a tool for you to manage your time effectively by recording your daily tasks.");
        char op;
        do {
            System.out.print("\nMENU\n1. View all your tasks\n2. View uncompleted tasks\n3. Add a new task\n4. Delete a task\n5. Time a task\n6. View completed tasks\n7. View total time taken on all the tasks\n0. Quit\nChoose an option (0 - 7): ");
            op = scan.next().charAt(0);
            System.out.println();
            switch (op) {
                case '1':
                    viewFile();
                    break;
                case '2':
                    printUncompleted();
                    break;
                case '3':
                    enterTask();
                    break;
                case '4':
                    removeTask();
                    break;
                case '5':
                    timeUncompleted();
                    break;
                case '6':
                    printCompleted();
                    break;
                case '7':
                    totalTime();
                    break;
                case '0':
                    saveFile();
                    System.out.println("Goodbye!\n(Please close all your windows to completely end this session)");
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        } while (op != '0');
    } // main

    static void viewFile() { // view all tasks in the file (formatting nicely)
        ArrayList <Todo> fileList = new ArrayList <Todo> (); // create a fileList arraylist the stores all the tasks, uncompleted or completed
        fileList.addAll(uncompleted);
        fileList.addAll(completed);
        for (int i = 0; i < fileList.size(); i++) { // print out all tasks
            System.out.println((i + 1) + ". " + fileList.get(i) + " " + (fileList.get(i).getComplete() ? "completed" : "uncompleted"));
        }
    } // viewFile


    static void printUncompleted() { // show the list of uncompleted tasks
        for (int i = 0; i < uncompleted.size(); i++) {
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) { // empty uncompleted list
            char toAdd;
            do {
                System.out.print("No uncompleted task. Do you want to add one (y/n)? "); // allow user to add a new task from here
                toAdd = scan.next().charAt(0);

                if (toAdd != 'y' && toAdd != 'n')
                    System.out.println("Input must be y or n. Please try again.");
            } while (toAdd != 'y' && toAdd != 'n');
                    
            if (toAdd == 'y') {
                enterTask();
                return;
            }   
        }
    } // printUncompleted

    static void enterTask() { // add a new task
        ArrayList<String> allTasks = new ArrayList<>(); // arraylist to store all the task names
        for (Todo u : uncompleted)
            allTasks.add(u.getTask()); // add all uncompleted task names
        for (Todo c : completed)
            allTasks.add(c.getTask()); // add all completed task names
        System.out.print("Enter a task: "); // ask for input
        scan.nextLine();
        String task = scan.nextLine().toLowerCase();

        while (allTasks.contains(task)) { // if arraylist contains task, ask again
            System.out.println("Task already exists. Please add another task.");
            System.out.print("Enter a task: ");
            task = scan.nextLine().toLowerCase();
        }
        Todo newTask = new Todo(task, 0, 0, 0, false); // create a new Todo object (task), uncompleted by default
        uncompleted.add(newTask); // add new task to the uncompleted list
        System.out.println("Task added.");
        // System.out.println(uncompleted); // test
    } // enterTask

    static void removeTask() { // remove an existing task
        ArrayList <Todo> fileList = new ArrayList <Todo> (); // create a fileList arraylist the stores all the tasks, uncompleted or completed
        fileList.addAll(uncompleted);
        fileList.addAll(completed);
        for (int i = 0; i < fileList.size(); i++) { // print out all tasks
            System.out.println((i + 1) + ". " + fileList.get(i) + " " + (fileList.get(i).getComplete() ? "completed" : "uncompleted"));
        }

        String removeString;
        int removeNum = 0;
        do { // check if it can be parsed as a number
            System.out.print("Enter a task number to delete: ");
            removeString = scan.next();
            if (!checkInt(removeString)) // if it's an integer
                System.out.println("Input must be a positive integer. Please try again.");
            else {
                removeNum = Integer.parseInt(removeString); // parse string as an integer
                if (removeNum > fileList.size() || removeNum <= 0) // removeNum out of bounds, try again
                    System.out.println("Index out of bounds. Please try again");
            }   
        } while (!checkInt(removeString) || removeNum > fileList.size() || removeNum <= 0); 
        
        for (int i = 0; i < uncompleted.size(); i++) { // remove the task from uncompleted arraylist if it's an uncompleted task
            if (fileList.get(removeNum-1).getTask().equals(uncompleted.get(i).getTask())) { // compare task to be deleted vs task in uncompleted arraylist
                uncompleted.remove(i);
            }
        }
        for (int i = 0; i < completed.size(); i++) { // remove the task from completed arraylist if it's an completed task
            if (fileList.get(removeNum-1).getTask().equals(completed.get(i).getTask())) { // compare task to be deleted vs task in completed arraylist
                completed.remove(i);
            }
        }
        System.out.println("Task deleted.");
    } // removeTask

    static void timeUncompleted() { // time a task that is marked as uncompleted
        for (int i = 0; i < uncompleted.size(); i++) {
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) { // empty uncompleted arraylist
            char toAdd;
            do {
                System.out.print("No uncompleted task. Do you want to add one (y/n)? "); // allow user to add a new task from here
                toAdd = scan.next().charAt(0);

                if (toAdd != 'y' && toAdd != 'n')
                    System.out.println("Input must be y or n. Please try again.");
            } while (toAdd != 'y' && toAdd != 'n');

            if (toAdd == 'y') {
                enterTask();
                return;
            }   
        }
        
        String indexString;
        int i = 0;
        do { // check if it can be parsed as a number
            System.out.print("Enter a task number to time that task: "); // ask for the index (on the list) of the task to time, which is shown on screen
            indexString = scan.next();
            if (!checkInt(indexString)) // if it's an integer
                System.out.println("Input must be a positive integer. Please try again.");
            else {
                i = Integer.parseInt(indexString); // parse string as an integer
                if (i > uncompleted.size() || i <= 0) // removeNum out of bounds, try again
                    System.out.println("Index out of bounds. Please try again");
            }   
        } while (!checkInt(indexString) || i > uncompleted.size() || i <= 0); 

        if (i > 0 && i <= uncompleted.size()) {
            Stopwatch stopwatch = new Stopwatch(); // create a stopwatch and run it
            Todo timedTask = uncompleted.get(i - 1); // task that is updated after timing
            scan.nextLine();
            System.out.print("Press enter to continue after done timing.");
            scan.nextLine(); 
            if (stopwatch.hours != 0 || stopwatch.minutes != 0 || stopwatch.seconds != 0) { // if timing is not 0 (there's a change), then update the task (Todo object)
                timedTask = new Todo(uncompleted.get(i-1).getTask(), stopwatch.hours + uncompleted.get(i - 1).getHours(), stopwatch.minutes + uncompleted.get(i - 1).getMinutes(), stopwatch.seconds + uncompleted.get(i - 1).getSeconds(),  uncompleted.get(i - 1).getComplete());
                uncompleted.set(i - 1, timedTask);
            }
            System.out.println("Task time modified: " + uncompleted.get(i - 1)); // inform the user about the updated task
            
            char check;
            do {
                System.out.print("Mark as complete (y/n)? "); // allow the user to decide whether they want to be done with the task, or come back to continue timing the task at another time during the day
                check = Character.toLowerCase(scan.next().charAt(0)); // case-insensitive
                if (check != 'y' && check != 'n')
                    System.out.println("Input must be y or n. Please try again.");
            } while (check != 'y' && check != 'n');

            if (check == 'y') {
                uncompleted.get(i - 1).setComplete(true); // change complete field to true (mark as completed)
                completed.add(uncompleted.get(i - 1)); // move task to completed arraylist
                uncompleted.remove(i - 1); // remove task from uncompleted arraylist
            }
        }
    } // timeUncompleted


    static void printCompleted() { // print all completed tasks
        for (int i = 0; i < completed.size(); i++) {
            System.out.println((i + 1) + ". " + completed.get(i));
        }
        if (completed.size() == 0) // empty completed arraylist
            System.out.println("No completed task.");
    } // printCompleted


    static void totalTime() { // calculate and show the total time taken for all the completed tasks during the day
        int total = 0; // in seconds
        for (int i = 0; i < completed.size(); i++) { // split the total (in seconds) to hours, minutes and seconds
            total += completed.get(i).getHours() * 3600; 
            total += completed.get(i).getMinutes() * 60;
            total += completed.get(i).getSeconds();
        }
        int totalHours = total / 3600;
        int residue1 = total % 3600;
        int totalMinutes = residue1 / 60;
        int residue2 = residue1 % 60;
        int totalSeconds = residue2;
        String secondsString = String.format("%02d", totalSeconds); // formatting for nice printing
        String minutesString = String.format("%02d", totalMinutes);
        String hoursString = String.format("%02d", totalHours);
        System.out.println("Total time: " + hoursString + ":" + minutesString + ":" + secondsString); // print the total time in hours, minutes and seconds
    } // totalTime

    static void saveFile() { // allow the user to save their progress in a file after they choose to quit the program
        char toSave;
        do {
            System.out.print("Do you want to save all the tasks into the file tasks.txt for today (y/n)? "); // ask them whether they want to save their progress or not
            toSave = Character.toLowerCase(scan.next().charAt(0)); // case-insensitive
            if (toSave != 'y' && toSave != 'n')
                System.out.println("Input must be y or n. Please try again.");
        } while (toSave != 'y' && toSave != 'n');

        if (toSave == 'n') // if no, then return and say goodbye
            return;
        else { // if yes, then update in a file and say goodbye
            PrintWriter fout = null;
            try {
                fout = new PrintWriter("tasks.txt"); // write in a new file
            } catch (IOException ex) { // IOException: input-output exception
                System.out.print(ex);
            }
            for (int i = 0; i < completed.size(); i++) { // write completed tasks first
                fout.write(completed.get(i).getTask() + "," + completed.get(i).getHours() + "," + completed.get(i).getMinutes() + "," + completed.get(i).getSeconds() + "," + completed.get(i).getComplete() + "\n");
            }
            for (int j = 0; j < uncompleted.size(); j++) { // write uncompleted tasks second
                fout.write(uncompleted.get(j).getTask() + "," + uncompleted.get(j).getHours() + "," + uncompleted.get(j).getMinutes() + "," + uncompleted.get(j).getSeconds() + "," + uncompleted.get(j).getComplete() + "\n");
            }
            System.out.println("Tasks updated in tasks.txt.");
            fout.close();
        }
    } // saveFile

    static boolean checkInt(String s) { // check if string is an int
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    } // checkInt

    static void getDate() { // get current date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateFormatter.format(now));
    } // getDate

} // class
