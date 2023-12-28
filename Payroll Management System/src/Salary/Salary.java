package Salary;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.security.auth.login.FailedLoginException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import All_Class.ConnectionClass;

public class Salary extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1, t2, t3, t4, t5, t6;
	Choice ch1;
	JButton b1, b2;
	Font f;
	JPanel p1, p2;

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	public Salary() {
		super("Salary");
		setLocation(100, 100);
		setSize(740, 380);
		setResizable(false);
		f = new Font("Georgia", Font.BOLD, 16);
		l1 = new JLabel("Select ID");
		l2 = new JLabel("HRA");
		l3 = new JLabel("DA");
		l4 = new JLabel("MID");
		l5 = new JLabel("PF");
		l6 = new JLabel("Basic Salary");

		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		ch1 = new Choice();
		ch1.setFont(f);
		

		try {

			ConnectionClass obj = new ConnectionClass();
			String q = "Select eid from employee";
			ResultSet rs = obj.stm.executeQuery(q);

			while (rs.next()) {

				ch1.add(rs.getString("eid"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();

		t1.setFont(f);
		t2.setFont(f);
		t3.setFont(f);
		t4.setFont(f);
		t5.setFont(f);

		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Icon/teacher.png"));
		Image image1 = img1.getImage().getScaledInstance(210, 400, Image.SCALE_DEFAULT);
		ImageIcon edt_img1 = new ImageIcon(image1);
		l7 = new JLabel(edt_img1);

		b1 = new JButton("Submit");
		b2 = new JButton("Close");
		b1.setFont(f);
		b2.setFont(f);

		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);

		b1.addActionListener(this);
		b2.addActionListener(this);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(7, 2, 10, 10));
		p1.add(l1);
		p1.add(ch1);
		p1.add(l2);
		p1.add(t1);
		p1.add(l3);
		p1.add(t2);
		p1.add(l4);
		p1.add(t3);
		p1.add(l5);
		p1.add(t4);
		p1.add(l6);
		p1.add(t5);
		p1.add(b1);
		p1.add(b2);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 1, 10, 10));
		p2.add(l7);

		setLayout(new BorderLayout(30, 30));
		add(p1, "Center");
		add(p2, "West");

	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			int eid = Integer.parseInt(ch1.getSelectedItem());
			float hra = Float.parseFloat(t1.getText());
			float da = Float.parseFloat(t2.getText());
			float mid = Float.parseFloat(t3.getText());
			float pf = Float.parseFloat(t4.getText());
			float basic = Float.parseFloat(t5.getText());

			try {
				ConnectionClass obj = new ConnectionClass();
				String q1 = "insert into salary values('" + eid + "','" + hra + "','" + da + "','" + mid + "','" + pf
						+ "','" + basic + "')";
				obj.stm.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Data inserted successfully");
				setVisible(false);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (e.getSource() == b2) {
				JOptionPane.showMessageDialog(null, "Are you sure?????");
				setVisible(false);
			}
		}

	}

	public static void main(String[] args) {
		Salary sal = new Salary();
		sal.setVisible(true);
	}

}
