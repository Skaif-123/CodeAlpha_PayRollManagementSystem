package Salary;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import All_Class.ConnectionClass;

public class Generate_Payslip extends JFrame implements ActionListener {

	JButton b1;
	JLabel l1, l2, l3, l4, l5, l6;
	JTextArea ta;
	Choice ch;
	JPanel p1;
	Font f;

	public Generate_Payslip() {
		super("Generate Pay Slip");
		setSize(500, 500);
		setLocation(100, 100);
		setResizable(false);
		f = new Font("Georgia", Font.BOLD, 18);
		l2 = new JLabel("Employee Id");
		l2.setFont(f);
		ch = new Choice();

		try {
			ConnectionClass obj = new ConnectionClass();
			String q = "Select * from employee";
			ResultSet rs = obj.stm.executeQuery(q);
			while (rs.next()) {
				ch.add(rs.getString("eid"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		b1 = new JButton("Print");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setFont(f);
		ch.setFont(f);

		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(f);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3, 10, 10));
		p1.add(l2);
		p1.add(ch);
		p1.add(b1);
		setLayout(new BorderLayout());
		add(sp, "Center");
		add(p1, "South");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			ta.setText("-------------Pay Slip--------------");
			try {
				ConnectionClass obj = new ConnectionClass();
				int id = Integer.parseInt(ch.getSelectedItem());
				String q1 = "select * from employee where eid='" + id + "'";
				ResultSet rs = obj.stm.executeQuery(q1);

				while (rs.next()) {
					ta.append("\n\nEmployee Id:" + Integer.parseInt(rs.getString("eid")));
					ta.append("\n\nEmployee Name:" + rs.getString("name"));
					ta.append("\n---------------------------------------------------------\n\n");
				}
				String q2 = "select * from salary where eid='" + id + "'";
				ResultSet rs2 = obj.stm.executeQuery(q2);

				while (rs2.next()) {
					ta.append("\nHRA:" + Float.parseFloat(rs2.getString("hra")));
					ta.append("\nDA:" + Float.parseFloat(rs2.getString("da")));
					ta.append("\nMID:" + Float.parseFloat(rs2.getString("mid")));
					ta.append("\nPF:" + Float.parseFloat(rs2.getString("pf")));
					ta.append("\nBASIC SALARY:" + Float.parseFloat(rs.getString("basic")));
					ta.append("\n---------------------------------------------------------\n\n");
				}

				float gross_salary = Float.parseFloat(rs2.getString("hra")) + Float.parseFloat(rs2.getString("da"))
						+ Float.parseFloat(rs2.getString("mid")) + Float.parseFloat(rs2.getString("pf"))
						+ Float.parseFloat(rs2.getString("basic"));
				double tax = ((gross_salary * 2.1) / 100);
				ta.append("Gross Salary :" + gross_salary);
				ta.append("\nTotal :" + gross_salary);
				ta.append("\nTax : 2.1%of salary" + tax);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new Generate_Payslip().setVisible(true);
	}

}
