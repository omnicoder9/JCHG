package org.example.part1.extendingThread;

//implementing Runnable is the superior way
//  - Java does not allow multiple inheritance of classes
//  - inheritance is used to modify the specific behavior of a class; extending Thread does not allow us change the behavior of Thread.
public class PrintNumber extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println("k = " + i);
        }
    }
}
