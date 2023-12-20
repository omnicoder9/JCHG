package org.example;


//Java Concurrency Playlist by Harry Gill, https://www.youtube.com/playlist?list=PLqpaR2svEQyHZ8T1zaV71Ab2GDBqA_h-Y
//OCP Oracle Certified Professional Java SE 11 Developer Complete Study Guide: Exam 1Z0-815, Exam 1Z0-816, and Exam 1Z0-817 by Jeanne Boyarsky and Scott Selikoff

//terminology
//thread: the smallest unit of execution that can be scheduled by an OS
//process: a group of one or more threads that are run in a shared environment (same memory space); threads in same process can communicate.

//OS thread scheduler finds an available CPU for a given thread.

//2 types of threads in Java
//  system thread: thread that programmer does not directly interact with; e.g. garbage collector
//  user defined thread: created by programmer

//OS scheduling algorithms: round robin scheduling, priority based scheduling

//creating a thread
//  - define a task
//      - provide a runnable interface to the Thread constructor
//      - extend thread nad override run() method
//  - start the thread using Thread.start()

import org.example.part1.runnable.PrintNumber;

public class Main implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println("j = " + i);
        }
    }
    public static void main(String[] args) {
        System.out.println("Start of main thread");
        Thread thread = new Thread(new PrintNumber());
        //thread.run(); //this will not create a new thread, but it will execute run()
        thread.start();
        System.out.println("End of main thread");

        System.out.println("Start of main thread 2");
        Thread thread2 = new org.example.part1.extendingThread.PrintNumber();
        thread2.start();
        System.out.println("End of main thread 2");

        System.out.println("Start of main thread 3");
        Thread thread3 = new Thread(new Main());
        thread3.start();
        System.out.println("End of main thread 3");

        Runnable task = () -> {
            for (int i = 1; i <= 10; i++){
                System.out.println("q = " + i);
            }
        };
        System.out.println("Start of main thread 4");
        Thread thread4 = new Thread(task);
        thread4.start();
        System.out.println("End of main thread 4");

        /*System.out.println("Start of main thread 5");
        new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                System.out.println("w = " + i);
            }).start();
        System.out.println("End of main thread 5");*/
    }
}