# Daily Time Manager Tool

## Authors 
Thu Tran, Sophie (Haeun) Song

## Abstract
Our program, the Daily Time Manager, was created to provide the users a tool to manage their time effectively by keeping track of the tasks they have. 
Different groups of audiences, ranging from students to workers, can organize their to-dos for a day, and check the time spent to complete each tasks. 
The users can create daily to-do list by entering the tasks, and time them using the stopwatch incorporated in this program.

In particular, our program allows the users to achieve the following:

1/ Add and delete a task in their to-do list

2/ View their to-do list and choose a task to time. 
   When the users finish timing the task, they can mark it as completed. 
   The task will then be removed from the to-do list and add on to the completed task list.

3/ View completed tasks in the list with the time taken to finish them.

4/ Check the total time spent for the completed tasks. 
   This can inform the users how much time they spent on the to-dos in a day.


In this program, we made use of object-oriented programming to create different classes that serve our purposes: 

- A Todo class. It allows the users to create instances which represent the tasks and their states.
  Attributes include the following: 
  *task*: String object that stores the content of the task that users create. 
  *hours*: Integer object that keeps track of the hours spent on the task.
  *minutes*: Integer object that keeps track of the minutes spent on the task. 
  *seconds*: Integer object that keeps track of the seconds spent on the task.
  *complete*: Boolean object that shows the completion of the task (false = uncompleted task, true = completed task).

- A Stopwatch class. It allows users to create stopwatches that help them time the task. 


The main data structure we used in this program is ArrayList, which stores the Todo objects. We have two main ArrayLists called *uncompleted* and *completed*.
After reading the file and storing each lines as Todo objects, the objects will be parsed into the *uncompleted* or *completed* list according to their boolean attributes. 

Also, in this program, we utilized graphics made from Java AWT and Swing to create a stopwatch interface that the user can interact with.
While the use of graphics may pose certain challenges as both of us work with Java graphics for the first time, it can make our Daily Time Manager more user-friendly 
if implemented appropriately.

The Menu is explained in detail below:

1. View all the tasks 
    - This option allows the users to view all of the Todo elements the user have created. The program will read the file and store the obejects in the list. 
      The elements will be enumerated with the attributes of the Todo object shown.
2. View uncompleted task 
    - This option allows the users to view the elements in the ArrayList *uncompleted*. The elements will be enumerated with the numbers.
3. Add new task 
    - This option allows the users to enter a new task.  
      When the users first enter the task, the attributes *hours*, *minutes*, and *seconds* are set by default to be zero, and *complete* is set by default to be false. 
      Therefore, the task will automatically be added to the *uncompleted* list. 
3. Delete a task 
    - This option allows the users to delete a task existing in the list, regardless of their status. 
      Elements in ArrayLists *uncompleted* and *completed* will both be added to the temorary ArrayList *fileList*, and the elements in *fileList* will be enumerated.
      The users will select the number that corresponds to the task that they want to delete. 
      If the boolean attribute of the chosen task is false, the task will be deleted from the ArrayList *uncompleted*, and vice versa. 
4. Time a task
    - This option allows the users to choose an element from the ArrayList *uncompleted* to measure the time they will spend on doing that task. 
      The stopwatch graphics window will be opened, and the users can press Start button to start timing. 
      After they finished measuring the time, they can click Done button and close the window, and the time will be processed and printed on the console.
      After that, the users will face the option to mark the task as complete or not. 
      If the users choose to set the task as completed, the boolean attribute will be updated to be true, and the corresponding element will be removed from the ArrayList *uncompleted* and be added to the ArrayList *completed*.
5. View completed tasks
    - This option allows the users to view the elements in the ArrayList *completed* with the time taken to finish each of them. The elements will be enumerated with the numbers.
6. View total time taken on the tasks
    - This option calculates the total time taken on all of the tasks in the *completed* list and prints it. The users will see how much time they spent on the tasks in one day.
0. Quit 
    - If the users choose to quit, they will get the option to save their data of ArrayLists into the "tasks.txt" file.


## Sample input file (tasks.txt)

<*task*,*hours*,*minutes*,*seconds*,*complete*> (This line is NOT in the file)

cook dinner,0,0,0,false

do mth homework,0,0,0,false

do yoga,0,0,0,false

play the piano,0,0,0,false

water the plants,0,0,0,false


## Project files

Stopwatch.java

Todo.java

DailyTimeManager.java (Main)


## Software

OS: Windows

Java version: 15.0.2

Editor: Visual Studio Code, version 1.55.2

