package All_Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4;
	JButton b1, b2;
	JTextField tf1;
	JPasswordField pass;
	JPanel p1;
	Font f;

	LoginPage() {
		super("Login Page");
		f = new Font("georgia", Font.BOLD, 14);
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");

		l1.setFont(f);
		l2.setFont(f);

		tf1 = new JTextField();
		tf1.setFont(f);

		pass = new JPasswordField();
		pass.setFont(f);

		b1 = new JButton("Login");
		b2 = new JButton("Cancel");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b1.setFont(f);
		b2.setFont(f);
		b1.addActionListener(this);
		b2.addActionListener(this);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(pass);
		p1.add(b1);
		p1.add(b2);

		// add background image

		ImageIcon img = new ImageIcon(this.getClass().getResource("/Icon/login.png"));
		Image image = img.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon img1 = new ImageIcon(image);
		l3 = new JLabel(img1);

		setLayout(new BorderLayout(30, 30));
		add(l3, "West");
		add(p1, "Center");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String Username = tf1.getText();
			String Password = pass.getText();
			try {
				ConnectionClass obj= new ConnectionClass();
				String q = "select * from login where username='" + Username + "' and password='" + Password + "'";
				ResultSet res;

				res = obj.stm.executeQuery(q);
				if (res.next()) {
					new Home_Payroll().setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "invalid username or password");
					this.setVisible(false);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b2) {
			JOptionPane.showMessageDialog(null, "Are you sure");
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.setVisible(true);
		login.setSize(380, 180);
		login.setResizable(false);

	}

}
