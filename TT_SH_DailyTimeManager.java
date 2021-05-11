import java.util.*; // for reading and arraylist
import java.io.*; // for files
import java.time.LocalDateTime; // to get the date
import java.time.format.DateTimeFormatter; // to format the date
   
class TT_SH_DailyTimeManager {
    private static ArrayList<Todo> completed = new ArrayList<>(); // arraylist that stores completed tasks
    private static ArrayList<Todo> uncompleted = new ArrayList<>(); // arraylist that stores uncompleted tasks
    static Scanner scan = new Scanner(System.in); // for reading inputs
    public static void main(String[] args) {
        Scanner fin = null;
        try { // open fin 
            fin = new Scanner(new File("tasks.txt")); // read the file
        } catch (IOException ex) { // IOException: input-output exception
            System.out.print(ex);
        }
        while (fin.hasNext()) { // while next line still exists (read till end of file)
            String task = fin.nextLine(); // read line by line
            String [] taskList = task.split(","); // store all the fields of the task into an array
        
            // assign values to the fields of the new Todo object: task, hours, minutes, seconds, completed
            String taskName = taskList[0]; 
            int taskHours = Integer.parseInt(taskList[1]);
            int taskMinutes = Integer.parseInt(taskList[2]);
            int taskSeconds = Integer.parseInt(taskList[3]); 
            boolean taskBoolean = Boolean.parseBoolean(taskList[4]);
			Todo fileTask = new Todo (taskName, taskHours, taskMinutes, taskSeconds, taskBoolean); // create new Todo object
            if (taskBoolean == true){ // if true, add task to completed list
                completed.add(fileTask);
            }
            else if (taskBoolean == false){ // if false, add task to uncompleted list
                uncompleted.add(fileTask);
            }
        }
        fin.close(); // close the file
        System.out.print("Today's date is: "); getDate(); // print current date
        final String ANSI_CYAN = "\u001b[36;1m"; // set text color to cyan
        final String ANSI_RESET = "\u001B[0m"; // set text color back to default (white)
        System.out.println(ANSI_CYAN + "\nDAILY TIME MANAGER" + ANSI_RESET +"\nThis is a tool for you to manage your time effectively by recording your daily tasks."); 
        char op; // menu option
        do {
            System.out.print("\nMENU" + "\n1. View all your tasks\n2. View uncompleted tasks\n3. Add a new task\n4. Delete a task\n5. Time a task\n6. View completed tasks\n7. View total time taken on all the tasks\n0. Quit" + "\nChoose an option (0 - 7): ");
            op = scan.next().charAt(0); // read user input for option
            System.out.println();
            switch (op) {
                case '1':
                    viewFile(); // view all your tasks
                    break;
                case '2':
                    printUncompleted(); // view uncompleted tasks
                    break;
                case '3':
                    enterTask(); // add a new task
                    break;
                case '4':
                    removeTask(); // delete a task
                    break;
                case '5':
                    timeUncompleted(); // time a task
                    break;
                case '6':
                    printCompleted(); // view completed tasks
                    break;
                case '7':
                    totalTime(); // view total time taken on all the tasks
                    break;
                case '0':
                    saveFile(); // option to save the files before quitting
                    System.out.println("Goodbye!\n(Please close all your windows to completely end this session)");
                    break;
                default: System.out.println("Invalid input, please try again."); // invalid input
            }
        } while (op != '0');
    } // main

    static void viewFile() { // view all tasks in the file 
        ArrayList <Todo> fileList = new ArrayList <Todo> (); // create a fileList arraylist that stores all the tasks
        fileList.addAll(uncompleted); // add all Todo objects in uncompleted to fileList 
        fileList.addAll(completed); // add all Todo objects in completed to fileList
        for (int i = 0; i < fileList.size(); i++) { // print out all tasks
            System.out.println((i + 1) + ". " + fileList.get(i) + " " + (fileList.get(i).getComplete() ? "completed" : "uncompleted"));
        }
    } // viewFile


    static void printUncompleted() { // show the list of uncompleted tasks
        for (int i = 0; i < uncompleted.size(); i++) { // show all uncompleted tasks
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) { // if empty uncompleted list
            char toAdd; // for reading user input
            do {
                System.out.print("No uncompleted task. Do you want to add one (y/n)? "); // allow user to add a new task from here
                toAdd = scan.next().charAt(0); // read user input

                if (toAdd != 'y' && toAdd != 'n') // invalid input
                    System.out.println("Input must be y or n. Please try again.");
            } while (toAdd != 'y' && toAdd != 'n');
                    
            if (toAdd == 'y') { // if yes, add a new task
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
        System.out.print("Enter a task: "); 
        scan.nextLine();
        String task = scan.nextLine().toLowerCase(); // read user input

        while (allTasks.contains(task)) { // if arraylist contains task, ask again
            System.out.println("Task already exists. Please add another task.");
            System.out.print("Enter a task: ");
            task = scan.nextLine().toLowerCase(); 
        }
        Todo newTask = new Todo(task, 0, 0, 0, false); // create a new Todo object (task), uncompleted by default
        uncompleted.add(newTask); // add new task to the uncompleted list
        System.out.println("Task added.");
    } // enterTask

    static void removeTask() { // remove an existing task
        ArrayList <Todo> fileList = new ArrayList <Todo> (); // create a fileList arraylist that stores all the tasks
        fileList.addAll(uncompleted); // add all Todo objects in uncompleted to fileList 
        fileList.addAll(completed); // add all Todo objects in completed to fileList
        for (int i = 0; i < fileList.size(); i++) { // print out all tasks
            System.out.println((i + 1) + ". " + fileList.get(i) + " " + (fileList.get(i).getComplete() ? "completed" : "uncompleted"));
        }

        String removeString; // for reading user input
        int removeNum = 0; // for parsing the String as an int
        do { // check if removeString can be parsed as an int
            System.out.print("Enter a task number to delete: ");
            removeString = scan.next(); // read user input
            if (!checkInt(removeString)) // if not int
                System.out.println("Input must be a positive integer. Please try again.");
            else { // if int
                removeNum = Integer.parseInt(removeString); // parse string as an int
                if (removeNum > fileList.size() || removeNum <= 0) // removeNum out of bounds, try again
                    System.out.println("Index out of bounds. Please try again");
            }   
        } while (!checkInt(removeString) || removeNum > fileList.size() || removeNum <= 0); 
        
        for (int i = 0; i < uncompleted.size(); i++) { // remove the task from uncompleted if it's an uncompleted task
            if (fileList.get(removeNum - 1).getTask().equals(uncompleted.get(i).getTask())) { // if task found in uncompleted arraylist
                uncompleted.remove(i);
            }
        }
        for (int i = 0; i < completed.size(); i++) { // remove the task from completed if it's an completed task
            if (fileList.get(removeNum - 1).getTask().equals(completed.get(i).getTask())) { // if task found in completed arraylist
                completed.remove(i);
            }
        }
        System.out.println("Task deleted.");
    } // removeTask

    static void timeUncompleted() { // time a task that is marked as uncompleted
        for (int i = 0; i < uncompleted.size(); i++) { // print all uncompleted tasks
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) { // if empty uncompleted list
            char toAdd; // for reading user input
            do {
                System.out.print("No uncompleted task. Do you want to add one (y/n)? "); // allow user to add a new task from here
                toAdd = scan.next().charAt(0); // read user input

                if (toAdd != 'y' && toAdd != 'n') // invalid input
                    System.out.println("Input must be y or n. Please try again.");
            } while (toAdd != 'y' && toAdd != 'n');
                    
            if (toAdd == 'y') { // if yes, add a new task
                enterTask();
                return;
            }   
        }
        
        String indexString; // for reading user input
        int i = 0; // for parsing the String as an int
        do { // check if indexString can be parsed as a number
            System.out.print("Enter a task number to time that task: "); 
            indexString = scan.next(); // read user input
            if (!checkInt(indexString)) // if not int
                System.out.println("Input must be a positive integer. Please try again.");
            else { // if int
                i = Integer.parseInt(indexString); // parse string as an int
                if (i > uncompleted.size() || i <= 0) // i out of bounds, try again
                    System.out.println("Index out of bounds. Please try again");
            }   
        } while (!checkInt(indexString) || i > uncompleted.size() || i <= 0); 
        
        if (i > 0 && i <= uncompleted.size()) { // if i within range
            Stopwatch stopwatch = new Stopwatch(); // create a stopwatch
            Todo timedTask = uncompleted.get(i - 1); // uncompleted task to be timed
            scan.nextLine();
            System.out.print("Press enter to continue after done timing.");
            scan.nextLine(); 
            if (stopwatch.hours != 0 || stopwatch.minutes != 0 || stopwatch.seconds != 0) { // if timing is not 0 (there's a change), then update the task 
                timedTask = new Todo(uncompleted.get(i-1).getTask(), stopwatch.hours + uncompleted.get(i - 1).getHours(), stopwatch.minutes + uncompleted.get(i - 1).getMinutes(), stopwatch.seconds + uncompleted.get(i - 1).getSeconds(),  uncompleted.get(i - 1).getComplete()); // task with updated timing
                uncompleted.set(i - 1, timedTask); // update task 
            }
            System.out.println("Task time modified: " + uncompleted.get(i - 1)); 
            
            char check; // for reading user input
            do {
                System.out.print("Mark as complete (y/n)? "); 
                check = Character.toLowerCase(scan.next().charAt(0)); // read user input, case-insensitive
                if (check != 'y' && check != 'n') // invalid input
                    System.out.println("Input must be y or n. Please try again.");
            } while (check != 'y' && check != 'n');

            if (check == 'y') { // if yes, then mark as completed
                uncompleted.get(i - 1).setComplete(true); // change complete field to true 
                completed.add(uncompleted.get(i - 1)); // move task to completed arraylist
                uncompleted.remove(i - 1); // remove task from uncompleted arraylist
            }
        }
    } // timeUncompleted


    static void printCompleted() { // print all completed tasks
        for (int i = 0; i < completed.size(); i++) {
            System.out.println((i + 1) + ". " + completed.get(i));
        }
        if (completed.size() == 0) // if empty completed arraylist
            System.out.println("No completed task.");
    } // printCompleted


    static void totalTime() { // show the total time taken for all completed tasks
        int total = 0; // in seconds
        for (int i = 0; i < completed.size(); i++) { // compute total time (in seconds)
            total += completed.get(i).getHours() * 3600; 
            total += completed.get(i).getMinutes() * 60;
            total += completed.get(i).getSeconds();
        }
        // convert total time from seconds to hours, minutes, seconds
        int totalHours = total / 3600;
        int residue1 = total % 3600;
        int totalMinutes = residue1 / 60;
        int residue2 = residue1 % 60;
        int totalSeconds = residue2;
        // nice formatting 
        String secondsString = String.format("%02d", totalSeconds); 
        String minutesString = String.format("%02d", totalMinutes);
        String hoursString = String.format("%02d", totalHours);
        System.out.println("Total time: " + hoursString + ":" + minutesString + ":" + secondsString); 
    } // totalTime

    static void saveFile() { // allow user to save their progress in a file once they choose to quit the program
        char toSave; // for reading user input
        do {
            System.out.print("Do you want to save all the tasks into the file tasks.txt for today (y/n)? "); 
            toSave = Character.toLowerCase(scan.next().charAt(0)); // read user input, case-insensitive
            if (toSave != 'y' && toSave != 'n') // invalid input
                System.out.println("Input must be y or n. Please try again.");
        } while (toSave != 'y' && toSave != 'n');

        if (toSave == 'n') // if no, then return 
            return;
        else { // if yes, then update data in a file
            PrintWriter fout = null; // for writing in file
            try {
                fout = new PrintWriter("tasks.txt"); // write in a file called tasks.txt
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
            fout.close(); // close the writer
        }
    } // saveFile

    static boolean checkInt(String s) { // check if string can be parsed as an int
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) // check if all characters are digits
                return false;
        }
        return true;
    } // checkInt

    static void getDate() { // get current date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // format date
        LocalDateTime now = LocalDateTime.now(); // get local date
        System.out.println(dateFormatter.format(now));
    } // getDate

} // class
