import javax.swing.SwingUtilities;

/*
*   FileName : Main.java
*   Author : Teman Beck
*   CMSC 335 Project 3
*   Date : December 13th, 2021
*   This class contains our main run method 
*/

public class Main {
    public static void main(String args[]) { 

        // Create the frame on the event dispatching thread. 
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                new TrafficLightsMainFrame(); 
            } 
        }); 
     } 
}
