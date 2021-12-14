import java.awt.Color;
import javax.swing.JLabel;

/*
*   FileName : TrafficLight.java
*   Author : Teman Beck
*   CMSC 335 Project 3
*   Date : December 12th, 2021
*   This class allows the creation of a Traffic Light object for our simulation
*   This class contains a ENUM class to select the 3 static light colors
*/
  
enum TrafficLightColor {                                                    //Enum of traffic light colors.
  RED, YELLOW , GREEN,
} 
 
class TrafficLight implements Runnable {                                    
  private TrafficLightColor trafficLightColor;                              //declares variable to track current traffic light color from ENUM
  private boolean stop = false;                                             //set to true to stop the simulation 
  private boolean changed = false;                                          //boolean to track when the light has changed
  Thread trafficLightThread;                                                //declares variable for traffic light threads
  private int time1;                                                        //declare variable to hold time a light stays a certain color
  private int time2;                                                        //declare variable to hold time a light stays a certain color
  private int time3;                                                        //declare variable to hold time a light stays a certain color
  private JLabel labelRed, labelYellow, labelGreen;

  TrafficLight(TrafficLightColor init, String name, JLabel label1, JLabel label2, JLabel label3, int time1, int time2, int time3) {
	  trafficLightThread = new Thread(this, name);
	  trafficLightColor = init; 
	  this.labelRed = label1;
	  this.labelYellow = label2;
	  this.labelGreen = label3;
	  this.time1 = time1;
	  this.time2 = time2;
	  this.time3 = time3;
  } 
 
  TrafficLight() {                                                          //Traffic light default constructor
    trafficLightColor = TrafficLightColor.RED;                              //assigns  traffic light color to red
  } 
 
  // Start up the light. 
  public void run() { 
    while(!stop) { 
      try { 
        switch(trafficLightColor) {                                         //switch statement to change light color
          case GREEN: 
            Thread.sleep(time1);                                            //sleeps green light thread for x amount of time to hold light
            break; 
          case YELLOW: 
            Thread.sleep(time2);                                            //sleeps yellow light thread for x amount of time to hold light
            break; 
          case RED: 
            Thread.sleep(time3);                                            //sleeps red light thread for x amount of time to hold light
            break; 
        } 
      } catch(InterruptedException exception) { 
        System.out.println(exception); 
      } 
      changeColor();                                                        //calls method to change light color after x amount of sleep time
    }  
  } 
  
  synchronized void changeColor() {                                         //method to change all light colors simultaneously
    switch(trafficLightColor) { 
      case RED: 
        trafficLightColor = TrafficLightColor.GREEN;                        
        break; 
      case YELLOW: 
        trafficLightColor = TrafficLightColor.RED; 
        break; 
      case GREEN: 
       trafficLightColor = TrafficLightColor.YELLOW; 
    } 
 
    changed = true;
    notify();                                                             //method to notify that the light has changed 
  } 
  
  synchronized void waitForChange() {                                     //method to wait for a light change to happen
    switch(trafficLightColor) { 
	      case RED:                                                         //sets red light background to red
		        this.labelRed.setBackground(Color.RED);                   
		        this.labelYellow.setBackground(Color.gray); 
		        this.labelGreen.setBackground(Color.gray); 
		        break; 
	      case YELLOW:                                                      //sets yellow light background to yellow
	    	  this.labelYellow.setBackground(Color.YELLOW);
	    	  this.labelRed.setBackground(Color.gray); 
		      this.labelGreen.setBackground(Color.gray);
		      break; 
	      case GREEN:                                                       //sets green light background to yellow
	    	  this.labelGreen.setBackground(Color.GREEN); 
	    	  this.labelRed.setBackground(Color.gray); 
		      this.labelYellow.setBackground(Color.gray);
		 
      }
      changed = false; 
  } 
 
   
  synchronized Color getColor() {                                         //method to return current light color
	  switch(trafficLightColor) { 
      case RED: 
        return Color.RED;
      case YELLOW: 
        return Color.YELLOW;
      case GREEN: 
       	return Color.GREEN; 
    }
	return null; 
  } 
  
  synchronized void cancel() {                                            //stop the traffic light
    stop = true; 
  } 
}  
  
