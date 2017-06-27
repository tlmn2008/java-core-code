package kenny.algorithm.zzzgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

//import java.awt.Button;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowFocusListener;

public class GUIFrame extends JFrame{
	private static final long serialVersionUID = 6385933774053272194L; //need to assign this variable
	boolean isButtonInBlue = true;
	JPanel panel = new JPanel();
	final JButton button = new JButton("myButton");

	public GUIFrame(){
		setTitle("minghonk");  
		setVisible(true);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //put frame in center position
		
		setContentPane(panel); //use to contain button
		
		//about usage of JButton
		button.setBackground(Color.blue);
		button.setForeground(Color.red);
		//panel.add(button);
		add(button);
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(isButtonInBlue == true){
            		button.setBackground(Color.green);
            		isButtonInBlue = false;
            	} else {
            		button.setBackground(Color.blue);
            		isButtonInBlue = true;
            		//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
            		JOptionPane.showConfirmDialog(null, "choose one", "choose one", JOptionPane.YES_NO_OPTION); 
            	}
            }
        });

		addWindowFocusListener(new WindowFocusListener() {  
            public void windowGainedFocus(WindowEvent e) {
            	button.setBackground(Color.blue);
                System.out.println("get the focus");  
            }
            public void windowLostFocus(WindowEvent e) {
            	button.setBackground(Color.green);
                System.out.println("loss the focus");  
            }
        });
	}
	
	public static void main(String[] args) {
		new GUIFrame();
		
	}
}