package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import de.dis2016.presenter.EstatesPresenter;

public class EstatesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EstatesPresenter presenter;
	
	private JTable houses = new JTable();
	private JTable apartments = new JTable();
	
	
	private JButton createButton;
	private JButton deleteButton;
	private JButton modifyButton;
	
	
	private JTextField id;
	private JTextField street;
	private JTextField streetNo;
	private JTextField squareArea;
	private JTextField postalCode;
	
	
	

	public EstatesFrame() {
		super();

		this.setLayout(new BorderLayout());
		this.setSize(800, 600);
		this.setMinimumSize(new Dimension(800, 600));
		this.setResizable(true);
		this.setTitle("Estates");
		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
		
		
		createButton = new JButton("create");
		deleteButton = new JButton("delete");
		modifyButton = new JButton("modify");
		JPanel east = new JPanel();
		east.setLayout(new FlowLayout());
		east.add(createButton);
		east.add(deleteButton);
		east.add(modifyButton);
		east.setSize(300,500);
		east.setPreferredSize(new Dimension(300, 500));
		
		this.add(BorderLayout.EAST, east);
		
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 2));
		center.add(new JScrollPane(houses));
		center.add(new JScrollPane(apartments));
		
		createButton.setEnabled(false);
		deleteButton.setEnabled(false);
		modifyButton.setEnabled(false);
	}
	
	
	public void showLogin() {
		JFrame loginwindow = new JFrame("login");
		LoginPanel login = new LoginPanel(presenter);
		login.setSize(500,500);
		loginwindow.add(login);
		login.setVisible(true);
		this.add(BorderLayout.CENTER, login);
		
		createButton.setEnabled(false);
		deleteButton.setEnabled(false);
		modifyButton.setEnabled(false);
	}
	
    
	
	
	public void showEstates() {
		createButton.setEnabled(true);
		deleteButton.setEnabled(true);
		modifyButton.setEnabled(true);
	}
	
	
	public void setPresenter(EstatesPresenter pres) {
        presenter = pres;
    }


}
