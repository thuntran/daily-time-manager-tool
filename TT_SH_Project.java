import java.util.*;


class TT_SH_Project {
    static ArrayList<Todo> toDoList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        char op;
        do {
            System.out.print("\nMENU\n1. Task manager\n2. Add a new task\n3. Choose an uncompleted task to time\n4. View completed tasks\n5. View total time taken\n0. Quit\nChoose an option (0 - 5): ");
            op = scan.next().charAt(0);
            switch (op) {
                case '1':
                    GUI userGUI = new GUI();
                    break;
                case '2':
                    enterTask(toDoList);
                    break;
                case '3':
                    timeUncompleted(toDoList);
                    break;
                case '4':
                    printCompleted(toDoList);
                    break;
                case '5':
                    totalTime(toDoList);
                    break;
                case '0':
                    System.out.println("Goodbye!\n(Please close all your windows to completely end this session)");
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        } while (op != '0');
    } // main

    static void enterTask(ArrayList<Todo> toDoList) {
        System.out.print("Enter a task: ");
        scan.nextLine();
        String task = scan.nextLine();
        toDoList.add(new Todo(task, 0, 0, 0));
    } // enterTask

    static void timeUncompleted(ArrayList<Todo> toDoList) {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ". " + toDoList.get(i));
        }
        System.out.println("Enter a task number to time that task: ");
        int i = scan.nextInt();//1
        if (i>0 && i <= toDoList.size()){
            Stopwatch stopwatch = new Stopwatch();
            scan.nextLine();
            System.out.print("Press enter to continue after done timing.");
            scan.nextLine();
            if (stopwatch.hours != 0 || stopwatch.minutes != 0 || stopwatch.seconds != 0)
                toDoList.set(i-1, new Todo(toDoList.get(i-1).getTask(), stopwatch.hours, stopwatch.minutes, stopwatch.seconds));
                System.out.println("Task time modified: " + toDoList.get(i-1));

        }
    } // timeUncompleted

    static void printCompleted(ArrayList<Todo> toDoList) {//if checkbox checked, then add to the completed list
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ". " + toDoList.get(i));
        }
    } // printCompleted


    static void totalTime(ArrayList<Todo> toDoList) {
        int total = 0; // in seconds
        for (int i = 0; i < toDoList.size(); i++) {
            total += toDoList.get(i).getHours() * 3600; 
            total += toDoList.get(i).getMinutes() * 60;
            total += toDoList.get(i).getSeconds();
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
        // System.out.println("Total time: " + total); // test
    } // totalTime
} // class


