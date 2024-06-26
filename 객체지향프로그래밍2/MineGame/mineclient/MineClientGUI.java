package mineclient;

//enoy mine game by dr.han 
//ToDo list
//1. statistic (#success, #fail)
//2. prevent same trial 

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import java.net.*; 
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener; 


class MineClientGUI extends JFrame { 
	static int inPort = 9999;
	static String address ="192.168.0.104";
	static public PrintWriter out;
	static public BufferedReader in;
	static int width=0;
	static int num_mine=0;	 
	static Map map;
	static int find=0;
	static public Socket socket; 
	
	static int attempts = 0;
	static int successes = 0;
    static int failures = 0;
	
	public Container cont;
	public JPanel p0, p1;	
	public JSlider slider0, slider1;
	public JButton b_map;
	public JButton[] buttons;
	
	JTextField statsField;
	JTextField minesLeftField;
	
 public static void main(String[] args) { 
 	MineClientGUI game = new MineClientGUI();
 }
 
 public MineClientGUI() {
 	setTitle("MineClientGUI");
		setSize(500,400);
	    setLocation(150, 150);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
	    cont = getContentPane();    	        
	    cont.setLayout(new FlowLayout());
	    p0 = new JPanel();
	    p0.setBackground(Color.CYAN);
	    p1 = new JPanel();
	    p1.setBackground(Color.YELLOW);
	    	    
	    slider0 = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);  
	    slider0.setMinorTickSpacing(1);  
	    slider0.setMajorTickSpacing(1);  
	    slider0.setPaintTicks(true);  
	    slider0.setPaintLabels(true);  
	    slider0.addChangeListener(new MyChangeListener());	    	    
	    slider1 = new JSlider();
	    slider1.addChangeListener(new MyChangeListener());
	    b_map = new JButton("Create Map");
	    b_map.addActionListener(new MyActionListener0());
	    
	    statsField = new JTextField("Attempts: 0, Succsses: 0, Failure: 0", 30);
	    minesLeftField = new JTextField("Mines left: " + num_mine, 20); 
	    	    
	    p0.add(slider0);
	    p0.add(slider1);	
	    p0.add(b_map);
	    p0.add(statsField);
	    p0.add(minesLeftField);
	    cont.add(p0);
	    cont.add(p1);
	    pack();	    
		setVisible(true);       
 }
 
      
 class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider s = (JSlider) e.getSource();			
			if (s == slider0) {
				width = (int)s.getValue();
				slider1.setMaximum(width*width);		    
			    slider1.setMinorTickSpacing(1);  
			    slider1.setMajorTickSpacing(5);  
			    slider1.setPaintTicks(true);  
			    slider1.setPaintLabels(true);  
			}
			else 
				num_mine = (int)s.getValue();			
		}		
	}

	
	class MyActionListener0 implements ActionListener {
		public void actionPerformed(ActionEvent e) {		
			try {
				socket = new Socket(address, inPort);
	        	out = new PrintWriter(socket.getOutputStream(), true); 
	           	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        	
	           	out.println(width+","+num_mine);
	        }
	        catch (Exception e1) {}
			
			map = new Map(width, num_mine);
			
			p1.setLayout(new GridLayout(width, width));					
			buttons = new JButton[width*width];
			for (int i=0; i<width*width; i++) {
				buttons[i] = new JButton(""+i);
				buttons[i].addActionListener(new MyActionListener1());
				p1.add(buttons[i]);
			}
					
		}		
	}
	
	class MyActionListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			int i = Integer.parseInt(s);
			int x = i / width;
			int y = i % width;
			
			try {
				out.println(x+","+y);
				String msg = in.readLine();
				int result = Integer.parseInt(msg);
				attempts++;
				if (result>=0) {
					//System.out.println("   Find mine at ("+x+", "+y+")");
					JButton b = (JButton)e.getSource();
					b.setText("O");
					map.updateMap(x,y);
					successes++;
					num_mine--;
					minesLeftField.setText("Mines left: " + num_mine);
				} else {
					//System.out.println("   No mine at ("+x+", "+y+")");
					JButton b = (JButton)e.getSource();
					b.setText("X");
					failures++;
					
				}
				
				statsField.setText("Attempts: " + attempts + ", Succsses: " + successes + ", Failure: " + failures);
			
			} catch (Exception e1) {}
			
		}
	
	}
 
     
}
