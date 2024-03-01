/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iswarya_490_project_1;
import java.util.Scanner;
/**
 *
 * @author Iswarya Gadde
 */
public class Iswarya_490_project_1 {
    private static int counter = 0; /* added this to shared counter*/
    public static void main(String[] args)
    {
        int nThreads= 0 ;
        try(var consoleReader = new Scanner(System.in)){        
        System.out.print("How many message threads should be started?  (Enter a number): ");
        nThreads = consoleReader.nextInt();
        System.out.println("Will run " + nThreads + " threads.");
        } 
        
        /*loop to create threads as per user input*/ 
        
        for (int i = 1; i <=nThreads; i++) {
            var msgWriter =new MessageWriter(""+i,1000*i);/*To add time for each thread*/
            var thread =new Thread (msgWriter);
            thread.start(); 
        }    

       /* try
        {
            thread.join();
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }*/

        System.out.println("Main Program Ended");
        /*System.exit(0);*/
    } 

    private static class MessageWriter implements Runnable {
    private int myCounter;
    private String myName;
    private long mySleeptime;
     public MessageWriter(String name, long sleepTime)
    {       
        myName = name;
        mySleeptime=sleepTime;
    }
        public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                Thread.sleep(mySleeptime); // 1000 ms
            }
            catch (InterruptedException exc)
            {
                System.out.println(exc);
            }
            ++counter;
            System.out.println("Message #" + counter + " - " + myName+"/time:"+mySleeptime); /*To print Time after each thread*/
        }
    }
    }
}
