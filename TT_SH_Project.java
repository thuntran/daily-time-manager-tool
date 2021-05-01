import java.util.*;

class TT_SH_Project {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Todo> toDoList = new ArrayList<>();
        char op;
        do {
            System.out.print("\nMENU\n1. Enter a task\n2. View added tasks\n3. Total time\n0. Quit\nChoose an option (0 - 3): ");
            op = scan.next().charAt(0);
            switch (op) {
                case '1':
                    enterTask(toDoList);
                    break;
                case '2':
                    print(toDoList);
                    break;
                case '3':
                    totalTime(toDoList);
                    break;
                case '0':
                    System.out.println("Goodbye!");
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        } while (op != '0');
        // toDoList.add(new Todo("Doing CSC homework", 2, 30, 34));
        // System.out.println(toDoList);
        // Stopwatch stopwatch = new Stopwatch();
    } // main

    static void enterTask(ArrayList<Todo> toDoList) {
        System.out.print("Enter a task: ");
        scan.nextLine();
        String task = scan.nextLine();
        toDoList.add(new Todo(task, 0, 0, 0));
        // toDoList.add(new Todo("Doing CSC homework", 2, 30, 34)); // test
        // toDoList.add(new Todo("Doing MTH homework", 4, 43, 21)); // test
        // toDoList.add(new Todo("Doing FRN homework", 5, 23, 22)); // test
    } // enterTask

    static void print(ArrayList<Todo> toDoList) {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ". " + toDoList.get(i).printTask());
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
        System.out.println("Total time: " + totalHours + ":" + totalMinutes + ":" + totalSeconds);
        // System.out.println("Total time: " + total); // test
    } // totalTime
} // class


