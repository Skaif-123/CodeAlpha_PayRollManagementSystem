package Employee;

import All_Class.*;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Employee extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2;
	JPanel p1, p2;
	Choice ch1;
	Font f;

	public Employee() {
		super("Add New Employee");
		setSize(1000, 500);
		setLocation(0, 0);
		setResizable(false);

		f = new Font("geogria", Font.BOLD, 16);

		l1 = new JLabel("Name");
		l2 = new JLabel("Gender");
		l3 = new JLabel("Address");
		l4 = new JLabel("State");
		l5 = new JLabel("City");
		l6 = new JLabel("Email");
		l7 = new JLabel("Phone");
		l9 = new JLabel("Employee Id");

		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/Icon/R.png"));
		Image image1 = img1.getImage().getScaledInstance(340, 350, Image.SCALE_DEFAULT);
		ImageIcon edit_img1 = new ImageIcon(image1);
		l8 = new JLabel(edit_img1);

		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		l9.setFont(f);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();

		t1.setFont(f);
		t2.setFont(f);
		t3.setFont(f);
		t4.setFont(f);
		t5.setFont(f);
		t6.setFont(f);
		t7.setFont(f);

		ch1 = new Choice();
		ch1.add("Male");
		ch1.add("Female");
		ch1.setFont(f);

		b1 = new JButton("Submit");
		b2 = new JButton("Close");

		b1.setFont(f);
		b2.setFont(f);

		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);

		b1.addActionListener(this);
		b2.addActionListener(this);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(9, 2, 10, 10));

		p1.add(l1);
		p1.add(t1);

		p1.add(l2);
		p1.add(ch1);

		p1.add(l3);
		p1.add(t2);

		p1.add(l4);
		p1.add(t3);

		p1.add(l5);
		p1.add(t4);

		p1.add(l6);
		p1.add(t5);

		p1.add(l7);
		p1.add(t6);

		p1.add(l9);
		p1.add(t7);

		p1.add(b1);
		p1.add(b2);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 1, 10, 10));
		p2.add(l8);

		setLayout(new BorderLayout(30, 30));
		add(p1, "Center");
		add(p2, "West");

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String name = t1.getText();
			String gender = ch1.getSelectedItem();
			String address = t2.getText();
			String state = t3.getText();
			String city = t4.getText();
			String email = t5.getText();
			String phone = t6.getText();
			int eid = Integer.parseInt(t7.getText());

			try {
				ConnectionClass obj = new ConnectionClass();

				String q = "insert into employee values('" + eid + "','" + name + "','" + gender + "','" + address
						+ "','" + state + "','" + city + "','" + email + "','" + phone + "')";

				obj.stm.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Recorded");
				setVisible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (e.getSource() == b2) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Are you sure???");
				System.exit(0);
			}
			
			
			
		}
	}

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setVisible(true);
	}

}
