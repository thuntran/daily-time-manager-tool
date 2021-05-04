import java.util.*;


class TT_SH_Project {
    static ArrayList<Todo> toDoList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        char op;
        do {
            System.out.print("\nMENU\n1. Task manager\n2. Timer\n3. Record a completed task\n4. View completed tasks\n5. View total time taken\n0. Quit\nChoose an option (0 - 5): ");
            op = scan.next().charAt(0);
            switch (op) {
                case '1':
                    GUI userGUI = new GUI();
                    break;
                case '2':
                    Stopwatch stopwatch = new Stopwatch();
                    break;
                case '3':
                    enterTask(toDoList);
                    break;
                case '4':
                    print(toDoList);
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
        System.out.print("Enter time taken:\n- Hours: ");
        int hh = scan.nextInt();
        System.out.print("- Minutes: ");
        int mm = scan.nextInt();
        System.out.print("- Seconds: ");
        int ss = scan.nextInt();
        toDoList.add(new Todo(task, hh, mm, ss));
    } // enterTask

    static void print(ArrayList<Todo> toDoList) {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ". " + toDoList.get(i));
        }
        System.out.println("Enter a task number to time that task: ");
        int i = scan.nextInt();//1
        if (i>0 && i <= toDoList.size()){
            Stopwatch stopwatch = new Stopwatch();
            scan.nextLine();
            scan.nextLine();
            if (stopwatch.hours != 0 || stopwatch.minutes != 0 || stopwatch.seconds != 0)
                toDoList.set(i-1, new Todo(toDoList.get(i-1).getTask(), stopwatch.hours, stopwatch.minutes, stopwatch.seconds));
                System.out.println("task time modified: " + toDoList.get(i-1));
        }
    } // print

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


