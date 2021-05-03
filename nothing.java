        int recordtime = seconds + minutes*60 + hours*3600;
        System.out.println("Time taken: " + hours + ":" + minutes + ":" + seconds);
        return recordtime;



        System.out.println("Enter a task number to time that task: ");
        int i = scan.nextInt();//1
        if (i>0 && i <= toDoList.size()){
            Stopwatch stopwatch = new Stopwatch();
            toDoList.set(i-1, Todo(toDoList.get(i-1).getTask(), hours, minutes, seconds));
        }


