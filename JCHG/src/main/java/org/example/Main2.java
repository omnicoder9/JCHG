package org.example;


public class Main2 {

    public static void main(String[] args){
        System.out.println("Start of main thread main 2");
        /*new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                System.out.println("w = " + i);
            }).start();*/
        System.out.println("End of main thread main 2");
    }
}
