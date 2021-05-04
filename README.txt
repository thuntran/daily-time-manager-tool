### Title: Time Manager


### Authors: Thu Tran, Sophie (Haeun) Song


### Class: CSC 212 Programming With Data Structures - Spring 2021 - Smith College


### Abstract:
    Our program, Time Manager, was created to provide users a tool to manage their time effectively by keeping track of the tasks they have. Our aim is to make this Time Manager easy to use for a wide range of users, so
    different groups of audiences, ranging from students to workers, can organize their study or work-related tasks and check the time spent to complete each tasks. 

    In particular, our time manager program allows the user to:
        1/ Enter a new task to their to-do list
        2/ View their added tasks and choose a task to time. When the users complete their task, they can check the task off by clicking it, and it will appear as the completed task.
        3/ Check the total time taken for the completed tasks. This can inform the user how much time they have used to complete their daily their to-do tasks,

    In this program, we made use of object-oriented programming to create different classes that serve our purposes: 
        - A Todo class that allows us to create instances which represent the tasks and their corresponding completed time (in hours, minutes and seconds).
        - A Stopwatch class that allows us to create stopwatches that help the user with the timing. 

    The main data structure we used in this program is ArrayList, which is used to store the Todo objects. We decided to work mainly with ArrayList because it is the data structure that both of us 
    are most comfortable working with in terms of familiarity with the methods. Also, we frequently made use of traversing through the data structure to write our different functions, and since each element in
    an ArrayList has an index, it will be more convenient for us to make use of indices to write our desired code.
    
    In the ArrayList, we stored Todo object that has four attributes: task, hours, minutes, seconds and print them out using toString method. 
    When the user first enters the task, the hours, minutes, and seconds won't show on the screen (since they are set by default to be zero). 
    When the user runs the timer and stops it, the time will be recorded, and the time related attributes will be updated accordingly. The updated times will be returned on the console using the print method.
    
    Also, in this program, we utilize graphics made from Java Swing to create a simple graphic user interface (GUI) that the user can interact with to manage their to-do list, and also to create the stopwatch for timing.
    While the use of graphics may pose certain challenges as both of us work with Java graphics for the first time, we think that should the graphics be appropriately implemently, it can make our Time Manager more user-friendly
    and more importantly, it helps us achieve the main purpose of this program, which is to time the tasks and manage the total time taken to complete to tasks on the to-do list.


### Sample input file:
    Currently we are still working on the file because it needs to be written in first before being read, but here is a sample of how the lines should look like:

    <task,hours,minutes,time> (This line is NOT in the file)
    
    do csc homework,01,23,00
    do chm homework,00,22,44
    do mth homework,01,44,22
    do yoga,00,33,12
    cook dinner,01,15,23


### Project files: 
    Stopwatch.java
    Todo.java
    TT_SH_Project.java (Main)


### Software: 
    OS: Windows
    Java version: 15.0.2
    Editor: Visual Studio Code, version 1.55.2


