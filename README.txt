### Title: Time Manager

### Authors: Thu Tran, Sophie (Haeun) Song

### Class: CSC 212 Programming With Data Structures - Spring 2021 - Smith College

### Abstract:
    This program was created to help the users manage their time effectively by keeping track of the tasks they have.
    Different groups of audiences, ranging from students to workers, can organize their study or work-related tasks and check the time spent to complete each tasks. 
    In particular, our time manager program allows the user to:
        1/ Enter a new task to their to-do list
        2/ View their existing (added) tasks and choose a task to time. When the users complete their task, they can check the task off by clicking it, and it will appear as the completed task.
        3/ Check the total time taken for the completed tasks 
    In this program, we made use of object-oriented programming to create different classes that serve our purposes: 
        - A Todo class that allows us to create instances which represent the tasks and their corresponding completed time.
        - A Stopwatch class that allows us to create stopwatches that helps the user with the timing. 
    The main data structure we used in this program is an ArrayList that stores all the Todo objects. We decided to work mainly with ArrayList because it is the data structure that both of us 
    are most comfortable working with in terms of familiarity. Also, we frequently made use of traversing through the data structure to write our different functions, and since each element in
    an ArrayList has an index, it will be more convenient for us to make use of indices to write our desired code.
    
    In the ArrayList, we stored Todo object that has four attributes: task, hours, minutes, seconds and print them out using toString method. 
    When the user first enters the task, the hours, minutes, and seconds won't show on the screen (since they are set by default to be zero). 
    When the user runs the timer and stops it, the time will be recorded, and the time related attributes will be updated accordingly. The updated times will be returned on the console using the print method.
    
    

### Project files: 
    Stopwatch.java
    Todo.java
    TT_SH_Project.java (Main)

### Software: 
    OS: Windows
    Java version: 15.0.2
    Editor: Visual Studio Code, version 1.55.2



Abstract. 20-30 lines about your program.
How you work with your program.
Sample 5 lines of your data.txt input file.

