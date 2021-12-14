import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

/*
*   FileName : TrafficLightMainFrame.java
*   Author : Teman Beck
*   CMSC 335 Project 3
*   Date : December 10th, 2021
*   This class extends our GUI class and adds all relative Java Swing components to the GUI
*   This class adds action listeners and functionality to all buttons.
*   This class acts as the controller of the program.
*/

public class TrafficLightsMainFrame implements ActionListener {

    private Cars car1, car2, car3;												//declare variables for 3 default cars
    private JLabel time;														//declare to hold time 
	private JLabel carLabelOne, carLabelTwo, carLabelThree;

    private JLabel light1_red;                                              	//declare labels to build traffic lights
	private JLabel light1_yellow;
	private JLabel light1_green;
	private JLabel light2_red;
	private JLabel light2_yellow;
	private JLabel light2_green;


	private JLabel light1_intersectionTwoLabel_red;
	private JLabel light1_intersectionTwoLabel_yellow;
	private JLabel light1_intersectionTwoLabel_green;
    private JLabel light2_intersectionTwoLabel_red;
	private JLabel light2_intersectionTwoLabel_yellow;	
	private JLabel light2_intersectionTwoLabel_green;

	private JLabel light1_intersectionThreeLabel_red;
	private JLabel light1_intersectionThreeLabel_yellow;
	private JLabel light1_intersectionThreeLabel_green;
	private JLabel light2_intersectionThreeLabel_red;
	private JLabel light2_intersectionThreeLabel_yellow;
	private JLabel light2_intersectionThreeLabel_green;

	private boolean running = false;
	private boolean exitSim = false;


    private TrafficLight tl1_int1;
	private TrafficLight tl2_int1;
	private TrafficLight tl1_intersectionTwoLabel;
	private TrafficLight tl1_intersectionThreeLabel;
	private TrafficLight tl2_intersectionTwoLabel;
	private TrafficLight tl2_intersectionThreeLabel;


    private boolean stopRunning = true;

	private Thread t;


	// Buttons
	JButton start = new JButton("Start");
	JButton pause = new JButton("Pause");
	JButton stop = new JButton("Stop");
	JButton addCar = new JButton("Add Car");
	JButton addIntersection = new JButton("Add Intersection");

/************************************************************************************************************************************************************/
/*                                This constructor generates our simulation display area, adding all relevant GUI components                                */
/************************************************************************************************************************************************************/



    public TrafficLightsMainFrame(){                                            //constructor for TrafficLight Simulator GUI
		 
	     
	    JFrame frame = new JFrame("Traffic Lights Simulator");                  //Create a new JFrame container.
	    frame.setSize(750, 600);                                                //sets the frame size.
	    frame.setLayout(null);													//sets default layout 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 					//allows program to end when user closes
	    
	    // Intersections labels
	    JLabel intersectionOneLabel = new JLabel("First Avenue and 3rd St");                   
	    JLabel intersectionTwoLabel = new JLabel("First Avenue and 4th St");
	    JLabel intersectionThreeLabel = new JLabel("First Avenue and 5th St");
	    intersectionOneLabel.setBounds(50,10,150,30);
	    intersectionTwoLabel.setBounds(300,10,150,30);
	    intersectionThreeLabel.setBounds(550,10,150,30);
	    
/************************************************************************************************************************************************************/
/*                                Adds actionListeners and set bounds of buttons											                                */
/************************************************************************************************************************************************************/
	    
	    start.addActionListener(this); 
	    pause.addActionListener(this);
	    stop.addActionListener(this);
        addCar.addActionListener(this);
        addIntersection.addActionListener(this);

	    
	    start.setBounds(350, 500, 80, 30);
	    pause.setBounds(450, 500, 120, 30);
	    stop.setBounds(590, 500, 80, 30);
        addCar.setBounds(50, 500, 80, 30);
        addIntersection.setBounds(150, 500, 150, 30);

	    
/************************************************************************************************************************************************************/
/*                                Allows creation of several default traffic lights											                                */
/************************************************************************************************************************************************************/
	    // Intersection 1
	    // Traffic light 1
	    light1_red = new JLabel(" ");
	    light1_red.setBounds(50,40,40,30);
	    light1_red.setBackground(Color.red);
	    light1_red.setOpaque(true);
	    light1_yellow = new JLabel(" ");
	    light1_yellow.setBounds(50,70,40,30);
	    light1_yellow.setBackground(Color.yellow);
	    light1_yellow.setOpaque(true);
	    light1_green = new JLabel(" ");
	    light1_green.setBounds(50,100,40,30);
	    light1_green.setBackground(Color.green);
	    light1_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_red = new JLabel(" ");
	    light2_red.setBounds(120,140,40,30);
	    light2_red.setBackground(Color.red);
	    light2_red.setOpaque(true);
	    light2_yellow = new JLabel(" ");
	    light2_yellow.setBounds(120,170,40,30);
	    light2_yellow.setBackground(Color.yellow);
	    light2_yellow.setOpaque(true);
	    light2_green = new JLabel(" ");
	    light2_green.setBounds(120,200,40,30);
	    light2_green.setBackground(Color.green);
	    light2_green.setOpaque(true);
	    
	    
	    // Intersection 2
	    // Traffic light 1
	    light1_intersectionTwoLabel_red = new JLabel(" ");
	    light1_intersectionTwoLabel_red.setBounds(300,40,40,30);
	    light1_intersectionTwoLabel_red.setBackground(Color.red);
	    light1_intersectionTwoLabel_red.setOpaque(true);
	    light1_intersectionTwoLabel_yellow = new JLabel(" ");
	    light1_intersectionTwoLabel_yellow.setBounds(300,70,40,30);
	    light1_intersectionTwoLabel_yellow.setBackground(Color.yellow);
	    light1_intersectionTwoLabel_yellow.setOpaque(true);
	    light1_intersectionTwoLabel_green = new JLabel(" ");
	    light1_intersectionTwoLabel_green.setBounds(300,100,40,30);
	    light1_intersectionTwoLabel_green.setBackground(Color.green);
	    light1_intersectionTwoLabel_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_intersectionTwoLabel_red = new JLabel(" ");
	    light2_intersectionTwoLabel_red.setBounds(370,140,40,30);
	    light2_intersectionTwoLabel_red.setBackground(Color.red);
	    light2_intersectionTwoLabel_red.setOpaque(true);
	    light2_intersectionTwoLabel_yellow = new JLabel(" ");
	    light2_intersectionTwoLabel_yellow.setBounds(370,170,40,30);
	    light2_intersectionTwoLabel_yellow.setBackground(Color.yellow);
	    light2_intersectionTwoLabel_yellow.setOpaque(true);
	    light2_intersectionTwoLabel_green = new JLabel(" ");
	    light2_intersectionTwoLabel_green.setBounds(370,200,40,30);
	    light2_intersectionTwoLabel_green.setBackground(Color.green);
	    light2_intersectionTwoLabel_green.setOpaque(true);
	    
	    // Intersection 3
	    // Traffic light 1
	    light1_intersectionThreeLabel_red = new JLabel(" ");
	    light1_intersectionThreeLabel_red.setBounds(550,40,40,30);
	    light1_intersectionThreeLabel_red.setBackground(Color.red);
	    light1_intersectionThreeLabel_red.setOpaque(true);
	    light1_intersectionThreeLabel_yellow = new JLabel(" ");
	    light1_intersectionThreeLabel_yellow.setBounds(550,70,40,30);
	    light1_intersectionThreeLabel_yellow.setBackground(Color.yellow);
	    light1_intersectionThreeLabel_yellow.setOpaque(true);
	    light1_intersectionThreeLabel_green = new JLabel(" ");
	    light1_intersectionThreeLabel_green.setBounds(550,100,40,30);
	    light1_intersectionThreeLabel_green.setBackground(Color.green);
	    light1_intersectionThreeLabel_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_intersectionThreeLabel_red = new JLabel(" ");
	    light2_intersectionThreeLabel_red.setBounds(620,140,40,30);
	    light2_intersectionThreeLabel_red.setBackground(Color.red);
	    light2_intersectionThreeLabel_red.setOpaque(true);
	    light2_intersectionThreeLabel_yellow = new JLabel(" ");
	    light2_intersectionThreeLabel_yellow.setBounds(620,170,40,30);
	    light2_intersectionThreeLabel_yellow.setBackground(Color.yellow);
	    light2_intersectionThreeLabel_yellow.setOpaque(true);
	    light2_intersectionThreeLabel_green = new JLabel(" ");
	    light2_intersectionThreeLabel_green.setBounds(620,200,40,30);
	    light2_intersectionThreeLabel_green.setBackground(Color.green);
	    light2_intersectionThreeLabel_green.setOpaque(true);
	    time = new JLabel();
	    time.setBounds(500, 400, 200, 50);
	    
	    carLabelOne = new JLabel();
	    carLabelTwo = new JLabel(); 
	    carLabelThree = new JLabel();
	    
	    carLabelOne.setBounds(50, 300, 450, 50);
	    carLabelTwo.setBounds(50, 325, 450, 50);
	    carLabelThree.setBounds(50, 350, 450, 50);

/************************************************************************************************************************************************************/
/*                                Adds all JComponents to the JFrame frame and allows user to see it						                                */
/************************************************************************************************************************************************************/
	    // Add the label to the content pane. 
	    frame.add(intersectionOneLabel); 
	    frame.add(intersectionTwoLabel);
	    frame.add(intersectionThreeLabel);
	    
	    frame.add(time);
	    frame.add(carLabelOne);
	    frame.add(carLabelTwo);
	    frame.add(carLabelThree);
	    
	    frame.add(light1_red); 
	    frame.add(light1_yellow);
	    frame.add(light1_green);
	    frame.add(light2_red); 
	    frame.add(light2_yellow);
	    frame.add(light2_green);
	    
	    frame.add(light1_intersectionTwoLabel_red); 
	    frame.add(light1_intersectionTwoLabel_yellow);
	    frame.add(light1_intersectionTwoLabel_green);
	    frame.add(light2_intersectionTwoLabel_red); 
	    frame.add(light2_intersectionTwoLabel_yellow);
	    frame.add(light2_intersectionTwoLabel_green);
	    
	    frame.add(light1_intersectionThreeLabel_red); 
	    frame.add(light1_intersectionThreeLabel_yellow);
	    frame.add(light1_intersectionThreeLabel_green);
	    frame.add(light2_intersectionThreeLabel_red); 
	    frame.add(light2_intersectionThreeLabel_yellow);
	    frame.add(light2_intersectionThreeLabel_green);
	    
	    frame.add(start); 
	    frame.add(pause);
	    frame.add(stop);
        frame.add(addCar);
        frame.add(addIntersection);

	    
	    frame.setVisible(true); 												//displays the frame to user
	 }


/************************************************************************************************************************************************************/
/*                                This section adds action listeners to all relevant JButtons								                                */
/************************************************************************************************************************************************************/

     public void actionPerformed(ActionEvent actionEvent) { 
	    if(actionEvent.getActionCommand().equals("Start"))  {				//if start button is clicked
	    	if (stopRunning == true) {
	    		
		    	tl1_int1 = new TrafficLight(TrafficLightColor.GREEN, "Interception 1, Light 1", light1_red, light1_yellow, light1_green, 4000, 1000, 5000); 
		    	tl2_int1 = new TrafficLight(TrafficLightColor.RED, "Interception 1, Light 2", light2_red, light2_yellow, light2_green, 4000, 1000, 5000);
		    	
		    	tl1_intersectionTwoLabel = new TrafficLight(TrafficLightColor.RED, "Interception 2, Light 1", light1_intersectionTwoLabel_red, light1_intersectionTwoLabel_yellow, light1_intersectionTwoLabel_green, 5000, 2000, 7000); 
		    	tl2_intersectionTwoLabel = new TrafficLight(TrafficLightColor.GREEN, "Interception 2, Light 2", light2_intersectionTwoLabel_red, light2_intersectionTwoLabel_yellow, light2_intersectionTwoLabel_green, 5000, 2000, 7000);
		    	
		    	tl1_intersectionThreeLabel = new TrafficLight(TrafficLightColor.GREEN, "Interception 3, Light 1", light1_intersectionThreeLabel_red, light1_intersectionThreeLabel_yellow, light1_intersectionThreeLabel_green, 6000, 1500, 7500); 
		    	tl2_intersectionThreeLabel = new TrafficLight(TrafficLightColor.RED, "Interception 3, Light 2", light2_intersectionThreeLabel_red, light2_intersectionThreeLabel_yellow, light2_intersectionThreeLabel_green, 6000, 1500, 7500);


		    	car1 = new Cars(carLabelOne, Color.RED, 0);
		    	car2 = new Cars(carLabelTwo, Color.RED, 225);
		    	car3 = new Cars(carLabelThree, Color.RED, 650);


		    	car1.carThread.start();
		    	car2.carThread.start();
		    	car3.carThread.start();

		    	tl1_int1.trafficLightThread.start();
		    	tl2_int1.trafficLightThread.start();
		    	tl1_intersectionTwoLabel.trafficLightThread.start();
		    	tl2_intersectionTwoLabel.trafficLightThread.start();
		    	tl1_intersectionThreeLabel.trafficLightThread.start();
		    	tl2_intersectionThreeLabel.trafficLightThread.start();

		    	exitSim = false;

		    	t = new Thread(new Runnable() {									//initializes thread

		    		@Override
		            public void run() {
		                while(!exitSim){
		                    
		                    try {
		                    	tl1_int1.waitForChange();
		                    	tl2_int1.waitForChange();
		                    	tl1_intersectionTwoLabel.waitForChange();
		                    	tl2_intersectionTwoLabel.waitForChange();
		                    	tl1_intersectionThreeLabel.waitForChange();
		                    	tl2_intersectionThreeLabel.waitForChange();

		                    	if (car1.getX() < 1000)
		                    		car1.setLight(tl2_int1.getColor());
		                    	else if (car1.getX() < 2000)
		                    		car1.setLight(tl2_intersectionTwoLabel.getColor());
		                    	else
		                    		car1.setLight(tl2_intersectionThreeLabel.getColor());


		                    	if (car2.getX() < 1000)
		                    		car2.setLight(tl2_int1.getColor());
		                    	else if (car2.getX() < 2000)
		                    		car2.setLight(tl2_intersectionTwoLabel.getColor());
		                    	else
		                    		car2.setLight(tl2_intersectionThreeLabel.getColor());


		                    	if (car3.getX() < 1000)
		                    		car3.setLight(tl2_int1.getColor());
		                    	else if (car3.getX() < 2000)
		                    		car3.setLight(tl2_intersectionTwoLabel.getColor());
		                    	else
		                    		car3.setLight(tl2_intersectionThreeLabel.getColor());

		                    	Thread tt = new Thread(new TimeThread(time));
		                    	tt.start();
		    					Thread.sleep(100);
		    					car1.increment();								//calls method to update and increment car data
		    					car2.increment();								//calls method to update and increment car data
		    					car3.increment();								//calls method to update and increment car data
		    				} catch (InterruptedException e) {
		    					e.printStackTrace();
		    				}
		                }
		            }
		        });
		    	t.start();														//starts thread
	    	}   	
	    } else if (actionEvent.getActionCommand().equals("Stop")) {				//checks if stop button is clicked
	    	exitSim = true;
	    	stopRunning = true;

	    	// Intersection 1
		    // Traffic light 1
		    light1_red.setBackground(Color.red);
		    light1_yellow.setBackground(Color.yellow);
		    light1_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_red.setBackground(Color.red);
		    light2_yellow.setBackground(Color.yellow);
		    light2_green.setBackground(Color.green);
		    
		    
		    // Intersection 2
		    // Traffic light 1
		    light1_intersectionTwoLabel_red.setBackground(Color.red);
		    light1_intersectionTwoLabel_yellow.setBackground(Color.yellow);
		    light1_intersectionTwoLabel_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_intersectionTwoLabel_red.setBackground(Color.red);
		    light2_intersectionTwoLabel_yellow.setBackground(Color.yellow);
		    light2_intersectionTwoLabel_green.setBackground(Color.green);
		    
		    // Intersection 3
		    // Traffic light 1
		    light1_intersectionThreeLabel_red.setBackground(Color.red);
		    light1_intersectionThreeLabel_yellow.setBackground(Color.yellow);
		    light1_intersectionThreeLabel_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_intersectionThreeLabel_red.setBackground(Color.red);
		    light2_intersectionThreeLabel_yellow.setBackground(Color.yellow);
		    light2_intersectionThreeLabel_green.setBackground(Color.green);

	    } else if (actionEvent.getActionCommand().equals("Pause")){				//checks if pause button is clicked
			if(stopRunning == true){
				t.suspend();
	    	tl1_int1.trafficLightThread.suspend();
	    	tl2_int1.trafficLightThread.suspend();
	    	tl1_intersectionTwoLabel.trafficLightThread.suspend();
	    	tl2_intersectionTwoLabel.trafficLightThread.suspend();
	    	tl1_intersectionThreeLabel.trafficLightThread.suspend();
	    	tl2_intersectionThreeLabel.trafficLightThread.suspend();
	    	car1.carThread.suspend();
    		car2.carThread.suspend();
    		car3.carThread.suspend();
	    	stopRunning = false;

			pause.setText("Continue");											//sets pause text to continue

			}
	    	
	    } else if (actionEvent.getActionCommand().equals("Continue")){			//checks if continue button is clicked
			t.resume();
	    		car1.carThread.resume();
	    		car2.carThread.resume();
	    		car3.carThread.resume();
	    		tl1_int1.trafficLightThread.resume();
		    	tl2_int1.trafficLightThread.resume();
		    	tl1_intersectionTwoLabel.trafficLightThread.resume();
		    	tl2_intersectionTwoLabel.trafficLightThread.resume();
		    	tl1_intersectionThreeLabel.trafficLightThread.resume();
		    	tl2_intersectionThreeLabel.trafficLightThread.resume();

				stopRunning = true;
				pause.setText("Pause");
		} else if (actionEvent.getActionCommand().equals("Add Car")){			//checks if Add Car button is clicked
			//create new car object
			JOptionPane.showMessageDialog(null, "Coming Soon! This will allow car creation.");

		} else if (actionEvent.getActionCommand().equals("Add Intersection")){	//checks if Add Intersection button is clicked
			//create new car object
			JOptionPane.showMessageDialog(null, "Coming Soon! This will allow intersection creation.");
		}
	 }    
}
