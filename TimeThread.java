import java.util.Date;
import javax.swing.JLabel;

/*
*   FileName : TimeThread.java
*   Author : Teman Beck
*   CMSC 335 Project 3
*   Date : December 12th, 2021
*   This class allows the time to run and display to screen and update every 1 second
*/

class TimeThread implements Runnable {
	
	JLabel timeThreadLabel;

	public TimeThread(JLabel timeThreadLabel){
		this.timeThreadLabel = timeThreadLabel;
	}
	
    @Override
  	public void run() {
	      Date date = new Date();										//declares date variable to hold date object
	      timeThreadLabel.setText(date.toString());						//sets the date object to JLabel 
	      try {
	        Thread.sleep(1000);											//sleep for 1000 milliseconds or 1 second
	      } catch (InterruptedException e) {
	        System.out.printf("Clock interrupt exception reached. Check system clock and retry");
	      }
	 }
 }