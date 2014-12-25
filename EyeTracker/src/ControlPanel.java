import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ControlPanel {

	private JFrame frame;
	private List<ControlPanelEventListener> listeners = new ArrayList<ControlPanelEventListener>();  
	private EyeTrackerController controller;
		
	public ControlPanel(EyeTrackerController controller){
		
		this.controller = controller;
		
		frame = new JFrame("eyetribe control panel");
		frame.setSize(400, 100);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addButtons();
		
		frame.setVisible(true);
	}
	
	public void initialize(EyeTrackerController controller){
		this.controller = controller;
	}
	
	public void addListener(ControlPanelEventListener listener){
		this.listeners.add(listener);
	}
	
	public void addButtons(){
		frame.setLayout(new GridLayout(1,3));
		
		JButton startButton = new JButton("START");
		startButton.addActionListener((ActionEvent e)->{
			controller.initialize();
			
			for(ControlPanelEventListener listener : listeners){
				listener.controlled(ControlPanelEventListener.START);
			}
			
		});
		frame.add(startButton);
		
		JButton button = new JButton("STOP");
		button.addActionListener((ActionEvent e)->{
			for(ControlPanelEventListener listener : listeners){
				listener.controlled(ControlPanelEventListener.STOP);
			}
			listeners.clear();
			frame.dispose();
		});
		frame.add(button);
	}

	
}
