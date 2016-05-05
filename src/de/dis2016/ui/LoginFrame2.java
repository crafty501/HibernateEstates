package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import de.dis2011.data.IDB2;

public class LoginFrame2 extends JFrame {
	private static final long serialVersionUID = 1L;

	private manager_ui _manager_ui;
	//private JTextField _tfLogin;
	private JPasswordField _tfPassword;
	private JButton abbrechen;
	private JButton weiter;


	public LoginFrame2(final IDB2 db) {
		super();

		// textfields *************************

		JPanel pnlTextfields = new JPanel();
		pnlTextfields.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Sicherheitsabfrage"),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)),
				pnlTextfields.getBorder()));
		pnlTextfields.setLayout(new GridLayout(2, 1));

		JPanel pnlPassword = new JPanel();
		pnlPassword.setLayout(new BorderLayout());
		pnlPassword.setBackground(new Color(255, 255, 255));
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Passwort:");
		 _tfPassword = new JPasswordField();
		_tfPassword.setSize(120, 12);
		pnlPassword.add(passwordLabel, BorderLayout.NORTH);
		pnlPassword.add(_tfPassword, BorderLayout.SOUTH);
		pnlTextfields.add(pnlPassword);

		// Buttons **************************************
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());

		abbrechen = new JButton();
		abbrechen.setText("Abbrechen");
		weiter = new JButton();
		weiter.setText("OK");
		pnlButtons.add(abbrechen);
		pnlButtons.add(weiter);

		this.setLayout(new BorderLayout());

		
		
		this.add(pnlTextfields, BorderLayout.CENTER);
		this.add(pnlButtons, BorderLayout.SOUTH);

		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean success = false;
				
				String Passwort = String.valueOf(_tfPassword.getPassword());
				if (Passwort.equals("123456")){
					success = true ;
				}
				
				if(success) {
					
					_manager_ui = new manager_ui(db);
					_manager_ui.setVisible(true);
					
					setVisible(false);
					dispose();
					
				}
			}
		});

		abbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		this.setSize(300, 180);
		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
		
		
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
}
