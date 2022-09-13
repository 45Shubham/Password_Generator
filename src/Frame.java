import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener{
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JTextField textfield = new JTextField();
	JButton button;
	JCheckBox check_box1; 
	JCheckBox check_box2; 
	JCheckBox check_box3; 
	Random random = new Random();
	Frame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		panel.setSize(500, 500);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
	
		
		label.setText("PASSWORD-GENERATOR");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.NORTH);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman",Font.BOLD ,30));
	  
		
		//textfield.setSize(70, 25);
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.RED);
		textfield.setBounds(250-100, 250-35, 150, 35);
		textfield.setFont(new Font("TImes New Roman" , Font.BOLD , 20));
		//textfield.setText("ABC");
		
		check_box1 = new JCheckBox();
		check_box1.setText("6 Character");
		check_box1.setBounds(250-100, 250-35+50, 150, 50);
		check_box1.setBackground(Color.white);
		check_box1.setFocusable(false);
		check_box1.setFont(new Font("MV Boli" , Font.CENTER_BASELINE , 15));
		
		check_box2 = new JCheckBox();
		check_box2.setText("10 Character");
		check_box2.setBounds(250-100, 250-35+80, 150, 50);
		check_box2.setBackground(Color.white);
		check_box2.setFocusable(false);
		check_box2.setFont(new Font("MV Boli" , Font.CENTER_BASELINE , 15));
		
		check_box3 = new JCheckBox();
		check_box3.setText("12 Character");
		check_box3.setBounds(250-100, 250-35+110, 150, 50);
		check_box3.setBackground(Color.white);
		check_box3.setFocusable(false);
		check_box3.setFont(new Font("MV Boli" , Font.CENTER_BASELINE , 15));
		
	    button = new JButton();
		button.setBounds(250-100, 250-35+110+50, 70, 20);
		button.setText("Submit");	
		button.setFocusable(false);
		button.addActionListener(this);
		button.setFont(new Font("Plain" , Font.PLAIN,11));
		
		panel.add(button);
		panel.add(check_box1);
		panel.add(check_box2);
		panel.add(check_box3);
		panel.add(textfield);
		panel.add(label);
		
		this.add(panel);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
		 if(check_box1.isSelected()) {
			 this.createPassword(6);
		 }
		 else if(check_box2.isSelected()) {
			 this.createPassword(10);
		 }
		 else if(check_box3.isSelected()) {
			 this.createPassword(12);
		 }
		 else {
			 this.createPassword(8);
		 }
		}
	}
	
	public void createPassword(int len) {
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@";
		StringBuilder st = new StringBuilder();
		while(len-- > 0) {
			
			st.append(s.charAt(random.nextInt(s.length())));
		}
		textfield.setText(st.toString());
	}
}
