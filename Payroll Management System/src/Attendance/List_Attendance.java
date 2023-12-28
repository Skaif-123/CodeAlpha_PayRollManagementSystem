package Attendance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import All_Class.ConnectionClass;

@SuppressWarnings("serial")
public class List_Attendance extends JFrame implements ActionListener {

	JTable t;
	JButton b1;
	String x[] = { "Employ Id", "First Half", "Second Half", "Date" };
	String y[][] = new String[20][4];
	int i = 0, j = 0;
	Font f;

	public List_Attendance() {
		super("List Attendance");
		setSize(900,400);
		setLocation(100,100);
		setResizable(false);
		f=new Font("Geogria",Font.BOLD,15);
		
		try {
			ConnectionClass obj= new ConnectionClass();
			String q="Select * from attendance";
			ResultSet rs=obj.stm.executeQuery(q);
			
			while(rs.next()) {
				y[i][j++]=rs.getString("id");
				y[i][j++]=rs.getString("first_half");
				y[i][j++]=rs.getString("second_half");
				y[i][j++]=rs.getString("dt");
				i++;
				j=0;}
			t=new JTable(y,x);
			t.setFont(f);
			
		
		}catch(

	Exception e)
	{
		e.printStackTrace();
	}

	JScrollPane js = new JScrollPane(t);
	add(js);
	
	b1=new JButton("Print");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.setFont(f);
	add(b1,"South");
	

}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1) {
			try {
				t.print();
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}

	
	
	public static void main(String[] args) {
		new List_Attendance().setVisible(true);
	}
}
