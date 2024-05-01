import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DetectionGameGUI extends JFrame {
	public static Map map;
	public static int width;
	public static int num_mine;
	public int find=0;
	public Container cont;
	public JPanel p0, p1;	
	public JSlider slider0, slider1;
	public JButton b_map;
	public JButton[] buttons;
	
	
	public DetectionGameGUI() {
		setTitle("DetectionGameGUI");
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
	    	    
	    p0.add(slider0);
	    p0.add(slider1);	
	    p0.add(b_map);
	    cont.add(p0);
	    cont.add(p1);
	    pack();	    
		setVisible(true);
	
	}
	

	public static void main(String[] args) {
		DetectionGameGUI frame = new DetectionGameGUI();

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
			map = new Map(width, num_mine);
			
			p1.setLayout(new GridLayout(width, width));					
			buttons = new JButton[width*width];
			for (int i=0; i<width*width; i++) {
				buttons[i] = new JButton(""+i);
				buttons[i].addActionListener(new MyActionListener1());
				p1.add(buttons[i]);
			}
			p1.validate();
			cont.validate();						
		}		
	}
	
	
	class MyActionListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			int i = Integer.parseInt(s);
			int x = i / width;
			int y = i % width;
			
			if (map.checkMine(x,y) >= 0) {
				JButton b = (JButton)e.getSource();
				b.setText("X");
				map.updateMap(x,y);
				find ++;
				System.out.println(find+" mines found");
				if(find==num_mine)
					System.out.println("Success found "+find+" mines !");
			}			
		}
	
	}
	
	
}
