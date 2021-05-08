import java.util.*;
import java.io.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
   
class TT_SH_Project {
    static ArrayList<Todo> completed = new ArrayList<>(); // arraylist that stores completed tasks
    static ArrayList<Todo> uncompleted = new ArrayList<>(); // arraylist that stores uncompleted tasks
    static Scanner scan = new Scanner(System.in);
    static Scanner fin = null;
    static File file1 = new File("tasks.txt");
    public static void main(String[] args) {
        try { // open fin 
            fin = new Scanner(file1); // read the file
        } catch (IOException ex) { // IOException: input-output exception
            System.out.print(ex);
        }
        while (fin.hasNext()) {//while next line exists,
            String task = fin.nextLine();
            String [] taskList = task.split(",");
            String taskName = taskList[0];
            int taskHours = Integer.parseInt(taskList[1]);
            int taskMinutes = Integer.parseInt(taskList[2]);
            int taskSeconds = Integer.parseInt(taskList[3]); //assign each components their "key"
            boolean taskBoolean = Boolean.parseBoolean(taskList[4]);
			Todo fileTask = new Todo (taskName, taskHours, taskMinutes, taskSeconds, taskBoolean); //create new Todo object with information
            if (taskBoolean == true){ //if true, add to completedlist
                completed.add(fileTask);
            }
            else if (taskBoolean == false){ //if false, add to uncompletedlist
                uncompleted.add(fileTask);
            }
        }
        fin.close();
        System.out.print("Today's date is: ");
        getDate();
        char op;
        do {
            System.out.print("\nMENU\n1. View entire file\n2. View uncompleted tasks\n3. Add a new task\n4. Delete a task\n5. Time a task\n6. View completed tasks\n7. View total time taken on all the tasks\n0. Quit\nChoose an option (0 - 7): ");
            op = scan.next().charAt(0);
            System.out.println();
            switch (op) {
                case '1':
                    viewFile();
                    break;
                case '2':
                    printUncompleted(uncompleted);
                    break;
                case '3':
                    enterTask(uncompleted);
                    break;
                case '4':
                    removeTask(uncompleted, completed);
                    break;
                case '5':
                    timeUncompleted(uncompleted);
                    break;
                case '6':
                    printCompleted(uncompleted, completed);
                    break;
                case '7':
                    totalTime(completed);
                    break;
                // case '8':
                //     clear();
                //     break;
                case '0':
                    saveFile();
                    System.out.println("Goodbye!\n(Please close all your windows to completely end this session)");
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        } while (op != '0');
    } // main

    static void viewFile() {
        try { // open fin 
            fin = new Scanner(file1); // read the file
        } catch (IOException ex) { // IOException: input-output exception
            System.out.print(ex);
        }
        while(fin.hasNext()){//while next line exists,
            String task = fin.nextLine(); 
            System.out.println(task);//print the line
        }
        fin.close();
    } //viewFile


    static void printUncompleted(ArrayList<Todo> uncompleted) {
        for (int i = 0; i < uncompleted.size(); i++) {
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) {// empty uncompleted
            System.out.print("No uncompleted task. Do you want to add one (y/n)? ");
            char toAdd = scan.next().charAt(0);        
            if (toAdd == 'y') {
                enterTask(uncompleted);
                return;
            }   
        }
    } // printUncompleted

    static void enterTask(ArrayList<Todo> uncompleted) { 
        System.out.print("Enter a task: ");
        scan.nextLine();
        String task = scan.nextLine();
        Todo newTask = new Todo(task, 0, 0, 0, false);
        uncompleted.add(newTask);
        System.out.println("Task added.");
        // //---------------------------------------File-----------------------------
        // //read the original file again 
        // try { // open fin again
        //     fin = new Scanner(file1); // read the file
        // } 
        // catch (IOException ex) { // IOException: input-output exception
        //     System.out.print(ex);
        // }
        // PrintWriter fout = null;
        // File file2 = new File("tasksCopy.txt");
        // try {
        //     fout = new PrintWriter(file2); // write in a new file
        // } catch (IOException ex) { // IOException: input-output exception
        //     System.out.print(ex);
        // }
        // // transfer content from new file to old file
        // while(fin.hasNext()) {
        //     String line = fin.nextLine(); // read line by line
        //     fout.write(line + "\n");
        // }
        // fout.write(newTask.getTask() + "," + newTask.getHours() + "," + newTask.getMinutes() + "," + newTask.getSeconds() + "," + newTask.getComplete() + "\n");
        // System.out.println("Tasks updated in tasks.txt");
        // fin.close();
        // fout.close();
        // boolean a = file1.delete(); // delete the old file
        // boolean b = file2.renameTo(file1); // rename the new file to be the same as the old file
        // //---------------------------------------------------------------------------
    } // enterTask

    static void removeTask(ArrayList<Todo> uncompleted, ArrayList <Todo> completed) { 
        
        // try { // open fin 
        //     fin = new Scanner(file1); // read the file
        // } catch (IOException ex) { // IOException: input-output exception
        //     System.out.print(ex);
        // }
        // while(fin.hasNext()){//while next line exists,
        //     String task = fin.nextLine();
        //     String [] taskList = task.split(",");
        //     String taskName = taskList[0];
        //     int taskHours = Integer.parseInt(taskList[1]);
        //     int taskMinutes = Integer.parseInt(taskList[2]);
        //     int taskSeconds = Integer.parseInt(taskList[3]); //assign each components their "key"
        //     boolean taskBoolean = Boolean.parseBoolean(taskList[4]);
		// 	Todo fileTask = new Todo (taskName, taskHours, taskMinutes, taskSeconds); //create new Todo object with information
        //     fileList.add(fileTask);
        // }
        // for (int i = 0; i < fileList.size(); i++){
        //     System.out.println((i+1) + ". " + fileList.get(i) + " " + fileList.get(i).getComplete());
        // }
        // for (int j = 0; j < uncompleted.size(); j++) { // print uncompleted tasks
        //     System.out.println((j + 1) + ". " + uncompleted.get(j) + " " + uncompleted.get(j).getComplete());
        // }

        // int index = completed.size() + 1;
        // for (int k = 0; k < completed.size(); k++) { // print completed tasks
        //     System.out.println(index + ". " + completed.get(k) + " " + completed.get(k).getComplete());
        //     index++;
        // }
        ArrayList <Todo> fileList = new ArrayList <Todo> ();
        fileList.addAll(uncompleted);
        fileList.addAll(completed);
        for (int i = 0; i < fileList.size(); i++) {
            System.out.println((i + 1) + ". " + fileList.get(i) + " " + fileList.get(i).getComplete());
        }

        System.out.print("Enter a task number to delete: ");
        int removeNum = scan.nextInt();
        for (int i = 0; i < uncompleted.size(); i++){
            if (fileList.get(removeNum-1).getTask().equals(uncompleted.get(i).getTask())){
                uncompleted.remove(i);
            }
        }
        for (int i = 0; i < completed.size(); i++){
            if (fileList.get(removeNum-1).getTask().equals(completed.get(i).getTask())){
                completed.remove(i);
            }
        }
        System.out.println("Task deleted.");
        // fin.close();

        // //---------------------------------------File-----------------------------
        // //read the original file again 

        // try { // open fin again
        //     fin = new Scanner(file1); // read the file
        // } 
        // catch (IOException ex) { // IOException: input-output exception
        //     System.out.print(ex);
        // }
        // PrintWriter fout = null;
        // File file2 = new File("tasksCopy.txt");
        // try {
        //     fout = new PrintWriter(file2); // write in a new file
        // } catch (IOException ex) { // IOException: input-output exception
        //     System.out.print(ex);
        // }
        // // transfer content from new file to old file
        // while(fin.hasNext()) {
        //     String line = fin.nextLine(); // read line by line
        //     String [] tasklist = line.split(",");
        //     if (tasklist[0].equals(fileList.get(removeNum-1).getTask())){ //if the task just read in the file is same as the newly timed task
        //         fout.write("");//update that line
        //     }
        //     else fout.write(line + "\n");//if not, then just write the old info
        // }        
        // System.out.println("Tasks updated in tasks.txt");
        // fin.close();
        // fout.close();
        // boolean a = file1.delete(); // delete the old file
        // boolean b = file2.renameTo(file1); // rename the new file to be the same as the old file
        // //---------------------------------------------------------------------------
        
    } // removeTask

    static void timeUncompleted(ArrayList<Todo> uncompleted) {
        for (int i = 0; i < uncompleted.size(); i++) {
            System.out.println((i + 1) + ". " + uncompleted.get(i));
        }
        if (uncompleted.size() == 0) {// empty uncompleted
            System.out.print("No uncompleted task. Do you want to add one (y/n)? ");
            char toAdd = scan.next().charAt(0);        
            if (toAdd == 'y') {
                enterTask(uncompleted);
                return;
            }   
        }
        System.out.print("Enter a task number to time that task: ");
        int i = scan.nextInt();//1
        if (i > 0 && i <= uncompleted.size()) {
            Stopwatch stopwatch = new Stopwatch();
            Todo timedTask = uncompleted.get(i-1); //initialize timedTask for file writing
            scan.nextLine();
            System.out.print("Press enter to continue after done timing.");
            scan.nextLine(); 
            if (stopwatch.hours != 0 || stopwatch.minutes != 0 || stopwatch.seconds != 0) {
                timedTask = new Todo(uncompleted.get(i-1).getTask(), stopwatch.hours + uncompleted.get(i - 1).getHours(), stopwatch.minutes + uncompleted.get(i - 1).getMinutes(), stopwatch.seconds + uncompleted.get(i - 1).getSeconds(),  uncompleted.get(i - 1).getComplete());
                uncompleted.set(i-1, timedTask);
            }
            System.out.println("Task time modified: " + uncompleted.get(i-1));
            // //---------------------------------------File-----------------------------
            // //read the original file again 
            // try { // open fin again
            //     fin = new Scanner(file1); // read the file
            // } 
            // catch (IOException ex) { // IOException: input-output exception
            //     System.out.print(ex);
            // }
            // PrintWriter fout = null;
            // File file2 = new File("tasksCopy.txt");
            // try {
            //     fout = new PrintWriter(file2); // write in a new file
            // } catch (IOException ex) { // IOException: input-output exception
            //     System.out.print(ex);
            // }
            // // transfer content from new file to old file
            // while(fin.hasNext()) {
            //     String line = fin.nextLine(); // read line by line
            //     String [] tasklist = line.split(",");
            //     if (tasklist[0].equals(timedTask.getTask())){ //if the task just read in the file is same as the newly timed task
            //         fout.write(timedTask.getTask() + "," + timedTask.getHours() + "," + timedTask.getMinutes() + "," + timedTask.getSeconds() + "," + timedTask.getComplete() + "\n");//update that line
            //     }
            //     else fout.write(line + "\n");//if not, then just write the old info
            // }
            // System.out.println("Tasks updated in tasks.txt");
            // fin.close();
            // fout.close();
            // boolean a = file1.delete(); // delete the old file
            // boolean b = file2.renameTo(file1); // rename the new file to be the same as the old file
            //     //---------------------------------------File----------------------------- 
            System.out.print("Mark as complete (y/n)? ");
            char check = scan.next().charAt(0);
            if (check == 'y') {
                uncompleted.get(i - 1).setComplete(true);
            //     //---------------------------------------File-----------------------------
            //     //read the original file again 
            //     try { // open fin again
            //         fin = new Scanner(file1); // read the file
            //     } 
            //     catch (IOException ex) { // IOException: input-output exception
            //         System.out.print(ex);
            //     }
            //     try {
            //         fout = new PrintWriter(file2); // write in a new file
            //     } catch (IOException ex) { // IOException: input-output exception
            //         System.out.print(ex);
            //     }
            //     // transfer content from new file to old file
            //     while(fin.hasNext()) {
            //         String line = fin.nextLine(); // read line by line
            //         String [] tasklist = line.split(",");
            //         if (tasklist[0].equals(timedTask.getTask())){ //if the task just read in the file is same as the newly timed task
            //             fout.write(timedTask.getTask() + "," + timedTask.getHours() + "," + timedTask.getMinutes() + "," + timedTask.getSeconds() + "," + timedTask.getComplete() + "\n");//update that line
            //         }
            //         else fout.write(line + "\n");//if not, then just write the old info
            //     }
            //     System.out.println("Tasks updated in tasks.txt");
            //     fin.close();
            //     fout.close();
            //     boolean file = file1.delete(); // delete the old file
            //     boolean f = file2.renameTo(file1); // rename the new file to be the same as the old file
            //     //---------------------------------------File----------------------------- 
                completed.add(uncompleted.get(i - 1));
                uncompleted.remove(i - 1);
            }
        }
    } // timeUncompleted


    static void printCompleted(ArrayList<Todo> uncompleted, ArrayList<Todo> completed) {
        for (int i = 0; i < completed.size(); i++) {
            System.out.println((i + 1) + ". " + completed.get(i));
        }
        if (completed.size() == 0) // empty completed
            System.out.println("No completed task.");
    } // printCompleted


    static void totalTime(ArrayList<Todo> completed) {
        int total = 0; // in seconds
        for (int i = 0; i < completed.size(); i++) {
            total += completed.get(i).getHours() * 3600; 
            total += completed.get(i).getMinutes() * 60;
            total += completed.get(i).getSeconds();
        }
        int totalHours = total / 3600;
        int residue1 = total % 3600;
        int totalMinutes = residue1 / 60;
        int residue2 = residue1 % 60;
        int totalSeconds = residue2;
        String secondsString = String.format("%02d", totalSeconds);
        String minutesString = String.format("%02d", totalMinutes);
        String hoursString = String.format("%02d", totalHours);
        System.out.println("Total time: " + hoursString + ":" + minutesString + ":" + secondsString);
    } // totalTime

    // static void clear(){
    //     System.out.print("Are you sure that you want to clear the file (y/n) ? ");
    //     String reply = scan.next();
    //     if (reply.equalsIgnoreCase("y")) {
    //         //---------------------------------------File-----------------------------
    //         try { // open fin again
    //             fin = new Scanner(file1); // read the file
    //         } 
    //         catch (IOException ex) { // IOException: input-output exception
    //             System.out.print(ex);
    //         }
    //         PrintWriter fout = null;
    //         try {
    //             fout = new PrintWriter(file1); // write in a new file
    //         } catch (IOException ex) { // IOException: input-output exception
    //             System.out.print(ex);
    //         }
    //         // transfer content from new file to old file
    //         while(fin.hasNext()) {
    //             String line = fin.nextLine(); // read line by line
    //             fout.write("");//update that line
    //         }
    //         System.out.println("Tasks.txt cleared.");
    //         fin.close();
    //         fout.close();
    //         //---------------------------------------------------------------------------
    //     }
    //     else if (reply.equalsIgnoreCase("n")) 
    //         return;
    //     else {
    //         System.out.println("Reply should be y or n. Please try again.");
    //         clear();
    //     }
    // } // clear

    static void saveFile() {
        int toSave;
        do {
            System.out.print("Do you want to save all the tasks into the file tasks.txt for today (y/n)? ");
            toSave = Character.toLowerCase(scan.next().charAt(0)); // case-insensitive
            if (toSave != 'y' && toSave != 'n')
                System.out.println("Input must be y or n. Please try again.");
        } while (toSave != 'y' && toSave != 'n');

        if (toSave == 'n')
            return;
        else {
            PrintWriter fout = null;
            try {
                fout = new PrintWriter(file1); // write in a new file
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

    static void getDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateFormatter.format(now));
    } // getDate

} // class
