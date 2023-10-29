package com.durgasoft.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.durgasoft.factory.EmployeeServiceFactory;
import com.durgasoft.pojo.Employee;
import com.durgasoft.service.EmployeeService;
import com.durgasoft.service.EmployeeServiceImpl;

public class EmployeeSearchFrame extends Frame implements ActionListener {

	Label l;
	TextField tf;
	Button b;
	Employee emp;
	/* EmployeeServiceImpl empService; */

	public EmployeeSearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Employee Details");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		l = new Label("Employee Id");
		tf = new TextField(20);
		b = new Button("Search");
		b.addActionListener(this);

		Font font = new Font("consolas", Font.BOLD, 20);
		l.setFont(font);
		tf.setFont(font);
		b.setFont(font);

		this.add(l);
		this.add(tf);
		this.add(b);

		/* empService = new EmployeeServiceImpl(); */
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			int eno = Integer.parseInt(tf.getText());
			EmployeeService empService = EmployeeServiceFactory.getEmployeeService();
			emp = empService.search(eno);
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("consolas", Font.BOLD, 25);
		g.setFont(font);

		if (emp == null) {
			g.drawString("Data Not Found !!!", 50, 250);
		} else {
			g.drawString("Employee Id " + emp.getEmpID(), 50, 200);
			g.drawString("Employee First Name " + emp.getFirstName(), 50, 250);
			g.drawString("Employee Last Name " + emp.getLastName(), 50, 300);
			g.drawString("Employee Salary " + emp.getEsal(), 50, 350);
			g.drawString("Employee Designation " + emp.getDesignation(), 50, 400);

		}
	}

}
