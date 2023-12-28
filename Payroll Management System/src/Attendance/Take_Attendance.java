package Attendance;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import All_Class.ConnectionClass;

@SuppressWarnings("serial")
public class Take_Attendance extends JFrame implements ActionListener {

	JLabel l1,l2,l3,l4;
	JButton b1;
	Choice ch1,ch2,ch3;
	Font f;
	JPanel p1;
	
	public Take_Attendance() throws Exception{
		super("Take Attendance");
		setSize(290,290);
		setLocation(100,100);
		setResizable(false);
		f=new Font("Geogria",Font.BOLD,18);
		l1=new JLabel("First Half");
		l2=new JLabel("Second Half");
		l3=new JLabel("Employee Id");
		
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		
		
		ch1=new Choice();
		ch1.add("Present");
		ch1.add("Absent");
		
		ch2=new Choice();
		ch2.add("Present");
		ch2.add("Absent");
		
		ch3=new Choice();
		ConnectionClass obj=new ConnectionClass();
		String q2="Select eid from employee";
		ResultSet rs= obj.stm.executeQuery(q2);
		while(rs.next()) {
			ch3.add(rs.getString("eid"));
		}
		
		ch3.setFont(f);
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setFont(f);
		
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,10,10));
		p1.add(l3);
		p1.add(ch3);
		p1.add(l1);
		p1.add(ch1);
		p1.add(l2);
		p1.add(ch2);
		
		setLayout(new BorderLayout(30,30));
		add(p1,"Center");
		add(b1,"South");
		
		
	}
	
	
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==b1) {
			try {
				int id= Integer.parseInt(ch3.getSelectedItem());
				String first_half=ch1.getSelectedItem();
				String second_half=ch1.getSelectedItem();
				String dt=new java.util.Date().toString();
				ConnectionClass obj= new ConnectionClass();
				String q="insert into attendance values('"+id+"','"+first_half+"','"+second_half+"','"+dt+"')";
				obj.stm.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Record inserted");
				setVisible(false);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		new Take_Attendance().setVisible(true);
	}
	

	

}
