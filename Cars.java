import java.awt.Color;
import javax.swing.JLabel;
import java.util.Random;

/*
*   FileName : Cars.java
*   Author : Teman Beck
*   CMSC 335 Project 3
*   Date : December 13th, 2021
*   This class creates Car objects for Traffic Light simulation.
*	This class also dislays relevant information to frame
*/

public class Cars implements Runnable {
	JLabel carInfoTextField;
	private double x = 0;														//initializes starting x coordinate to zero
	private double y = 0;														//initializes y coordinate to zero since we assume straight line
	private double speed = 1; 													// moves 1 m/s
	private double time = 0;													//sets time to start at zero
	private Color light;

	Thread carThread;															//declares carthread


	Cars(JLabel carInfoTextField, Color light, double x){
		carThread = new Thread();												//starts new thread for car object
		this.carInfoTextField = carInfoTextField;
		this.light = light;
		this.x = x;
	}
	
    @Override
  	public void run() {
    	
	      try {
	        Thread.sleep(1000);
	        
	      } catch (InterruptedException e) {
	        System.out.printf("Testing check point");
	      }
	    
	 }
    
    synchronized void setLight(Color light) {
    	this.light = light;
    }
    
    synchronized double getX() {
    	return this.x;
    }
    
    synchronized void increment() { 											//function to update both the x-coordinate and the speed and dosplay to screen
    	if (this.light == Color.red && ((x >= 850 && x <= 1000))) {				//check to see distance from light between 850 - 1000 meters
	    	  speed = 0;														//sets current speed to 0 if close enough to light
	    } else if (this.light == Color.red && ((x >= 1850 && x <= 2000))) {		//check to see distance from light between 1850 - 2000 meters
			speed = 0;															//sets current speed to 0 if close enough to light
	  	} else if (this.light == Color.red && ((x >= 2850 && x <= 3000))) {		//check to see distance from light between 2850 - 3000 meters
			speed = 0;															//sets current speed to 0 if close enough to light
	  	} else {																//default speed option to add a random speed element to car
	    	speed = (new Random()).nextDouble() * (2 + 0.5);					
	    }

    	time += 0.01;															//increments time by 0.01
        x += speed * time;														//formula to plot x coordinate for distance travel

        if ((x >= 850 && x <= 1000)) {
        	carInfoTextField.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s Arrived at 3rd St.", x, y, speed));
        }
        else if ((x >= 1850 && x <= 2000)) {
        	carInfoTextField.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s Arrived at 4th St.", x, y, speed));
        }
        else if ((x >= 2850 && x <= 3000)) {
        	carInfoTextField.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s Arrived at 5th St.", x, y, speed));
        }
        else {
        	carInfoTextField.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s ", x, y, speed));
        }
    } 
}
