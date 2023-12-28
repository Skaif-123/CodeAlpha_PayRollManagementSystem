package Employee;

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
public class List_Employee extends JFrame implements ActionListener {
	JTable tb;
	String x[] = { "Eid", "name", "gender", "address", "state", "city", "email", "phone" };
	String y[][] = new String[20][8];
	JButton b1;
	int i = 0;
	int j = 0;
	Font f;

	public List_Employee() {
		super("List Employee");
		setSize(900, 400);
		setLocation(100, 100);
		setResizable(false);

		f = new Font("Geogria", Font.BOLD, 16);

		try {
			ConnectionClass obj = new ConnectionClass();
			String q = "select * from employee";
			ResultSet rs = obj.stm.executeQuery(q);

			while (rs.next()) {
				y[i][j++] = rs.getString("eid");
				y[i][j++] = rs.getString("name");
				y[i][j++] = rs.getString("gender");
				y[i][j++] = rs.getString("address");
				y[i][j++] = rs.getString("state");
				y[i][j++] = rs.getString("city");
				y[i][j++] = rs.getString("email");
				y[i][j++] = rs.getString("phone");
				i++;
				j = 0;
			}
			tb = new JTable(y, x);
			tb.setFont(f);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane js = new JScrollPane(tb);
		add(js);
		b1 = new JButton("print");
		add(b1, "South");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setFont(f);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource()==b1) {
	try {
		tb.print();
		
	} catch (Exception e2) {
		e2.printStackTrace();
	}
}
	}
	public static void main(String[] args) {
		List_Employee listemp = new List_Employee();
		listemp.setVisible(true);
	}

	
}
