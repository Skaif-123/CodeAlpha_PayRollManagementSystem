package All_Class;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Attendance.List_Attendance;
import Attendance.Take_Attendance;
import Employee.Employee;
import Employee.List_Employee;
import Employee.Update_Employee;
import Salary.Generate_Payslip;
import Salary.Salary;
import Salary.Update_Salary;

@SuppressWarnings("serial")
public class Home_Payroll extends JFrame implements ActionListener {
	JLabel l1;

	Font f;

	public Home_Payroll() {
		super("Home Page");
		f=new Font("geogria", Font.BOLD, 16);
		setSize(1200, 690);
		
		JMenuBar mbar= new JMenuBar();
		JMenu m2=new JMenu("Update");
		JMenu m1=new JMenu("Employee");
		JMenu m3=new JMenu("Attendance");
		JMenu m4=new JMenu("Exit");
		m1.setFont(f);
		m2.setFont(f);
		m3.setFont(f);
		m4.setFont(f);
		
		JMenuItem item1= new JMenuItem("New Employee");
		ImageIcon img1=new ImageIcon(this.getClass().getResource("/Icon/Employee.png"));
		Image image=img1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		ImageIcon edit_img1=new ImageIcon(image);
		item1.setIcon(edit_img1);
		item1.setMnemonic('Y');
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
		item1.addActionListener(this);
		
		JMenuItem item2= new JMenuItem("Salary");
		ImageIcon img2=new ImageIcon(this.getClass().getResource("/Icon/icon10.png"));
		Image image2=img2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img2=new ImageIcon(image2);
		
		item2.setIcon(edit_img2);
		item2.setMnemonic('S');
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		item2.addActionListener(this);
		
		JMenuItem item3=new JMenuItem("List Employee");
		ImageIcon img3=new ImageIcon(this.getClass().getResource("/Icon/icon17.png"));
		Image image3=img3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img3=new ImageIcon(image3);
		
		item3.setIcon(edit_img3);
		item3.setMnemonic('I');
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		item3.addActionListener(this);
		
		JMenuItem item4= new JMenuItem("Update Employee");
		ImageIcon img4=new ImageIcon(this.getClass().getResource("/Icon/icon14.jpg"));
		Image image4=img4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img4=new ImageIcon(image4);
		
		item4.setIcon(edit_img4);
		item4.setMnemonic('U');
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
		item4.addActionListener(this);
		
		JMenuItem item5= new JMenuItem("Update Salary");
		ImageIcon img5=new ImageIcon(this.getClass().getResource("/Icon/icon16.png"));
		Image image5=img5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img5=new ImageIcon(image5);
		
		item5.setIcon(edit_img5);
		item5.setMnemonic('Y');
		item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
		item5.addActionListener(this);
		
		JMenuItem item6= new JMenuItem("Take Attendance");
		ImageIcon img6=new ImageIcon(this.getClass().getResource("/Icon/icon4.jpg"));
		Image image6=img6.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img6=new ImageIcon(image6);
		item6.setIcon(edit_img6);
		item6.setMnemonic('A');
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		item6.addActionListener(this);
		
		JMenuItem item7= new JMenuItem("List Attendance");
		ImageIcon img7=new ImageIcon(this.getClass().getResource("/Icon/icon3.png"));
		Image image7=img7.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img7=new ImageIcon(image7);
		item7.setIcon(edit_img7);
		item7.setMnemonic('T');
		item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
		item7.addActionListener(this);
		
		JMenuItem item8= new JMenuItem("Generate Payslip");
		ImageIcon img8=new ImageIcon(this.getClass().getResource("/Icon/icon7.png"));
		Image image8=img8.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img8=new ImageIcon(image8);
		item8.setIcon(edit_img8);
		item8.setMnemonic('G');
		item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		item8.addActionListener(this);
		
		JMenuItem item9= new JMenuItem("Exit");
		ImageIcon img9=new ImageIcon(this.getClass().getResource("/Icon/cancle.png"));
		Image image9=img9.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon edit_img9=new ImageIcon(image9);	
		item9.setIcon(edit_img9);
		item9.setMnemonic('X');
		item9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		item9.addActionListener(this);
		
		
		
		item1.setFont(f);		
		item2.setFont(f);		
		item3.setFont(f);		
		item4.setFont(f);		
		item5.setFont(f);		
		item6.setFont(f);		
		item7.setFont(f);		
		item8.setFont(f);		
		item9.setFont(f);		
		
		
		m1.add(item1);
		m1.add(item2);
		m1.add(item3);
		
		m2.add(item4);
		m2.add(item5);
		
		m3.add(item6);
		m3.add(item7);
		m3.add(item8);
		
		m4.add(item9);
		
		mbar.add(m1);
		mbar.add(m2);
		mbar.add(m3);
		mbar.add(m4);
		
		setJMenuBar(mbar);
		mbar.setBackground(Color.lightGray);
		
		
		ImageIcon background=new ImageIcon(this.getClass().getResource("/Icon/background.jpg"));
		Image back_img=background.getImage().getScaledInstance(1600, 890, Image.SCALE_DEFAULT);
		ImageIcon background_img=new ImageIcon(back_img);
		JLabel l1=new JLabel(background_img);
		add(l1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd= e.getActionCommand();
		if(cmd.equals("New Employee")) {
			new Employee().setVisible(true);
		}
		else if(cmd.equals("Salary")) {
			new Salary().setVisible(true);
		}
		else if(cmd.equals("List Employee")) {
			new List_Employee().setVisible(true);
		}
		else if(cmd.equals("Update Employee")) {
			new Update_Employee().setVisible(true);
		}
		else if(cmd.equals("Update Salary")) {
			new Update_Salary().setVisible(true);
		}
		else if(cmd.equals("Take Attendance")) {
			try {
				new Take_Attendance().setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(cmd.equals("List Attendance")) {
			new List_Attendance().setVisible(true);
		}
		else if(cmd.equals("Generate Payslip")) {
			new Generate_Payslip().setVisible(true);
		}
		else if(cmd.equals("Exit")) {
			System.exit(0);
		}
		else {
			JOptionPane.showMessageDialog(null,"Sorry you press Wrong Shortcut keys");
			setVisible(false);
		}
		

	}

	public static void main(String[] args) {
		Home_Payroll home = new Home_Payroll();
	
		home.setVisible(true);
		

	}

}
