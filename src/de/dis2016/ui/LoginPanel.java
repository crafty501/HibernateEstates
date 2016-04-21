package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.dis2016.presenter.EstatesPresenter;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton abbrechen;
	private JButton weiter;


	public LoginPanel(final EstatesPresenter presenter) {
		super();

		// textfields *************************

		JPanel pnlTextfields = new JPanel();
		pnlTextfields.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Sicherheitsabfrage"),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)),
				pnlTextfields.getBorder()));
		pnlTextfields.setLayout(new GridLayout(2, 1));

		JPanel pnlLogin = new JPanel();
		pnlLogin.setLayout(new BorderLayout());
		JLabel lbLogin = new JLabel();
		lbLogin.setText("Login:");
		final JTextField tfLogin = new JTextField();
		tfLogin.setSize(120, 12);
		pnlLogin.add(lbLogin, BorderLayout.NORTH);
		pnlLogin.add(tfLogin, BorderLayout.CENTER);
		pnlTextfields.add(pnlLogin);

		JPanel pnlPassword = new JPanel();
		pnlPassword.setLayout(new BorderLayout());
		pnlPassword.setBackground(new Color(255, 255, 255));
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Passwort:");
		final JPasswordField tfPassword = new JPasswordField();
		tfPassword.setSize(120, 12);
		pnlPassword.add(passwordLabel, BorderLayout.NORTH);
		pnlPassword.add(tfPassword, BorderLayout.SOUTH);
		pnlTextfields.add(pnlPassword);

		// Buttons **************************************
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());

		abbrechen = new JButton();
		abbrechen.setText("Abbrechen");
		weiter = new JButton();
		weiter.setText("Login");
		pnlButtons.add(abbrechen);
		pnlButtons.add(weiter);

		this.setLayout(new BorderLayout());

		this.add(pnlTextfields, BorderLayout.CENTER);
		this.add(pnlButtons, BorderLayout.SOUTH);

		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				presenter.logIn();

			}
		});

		abbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfLogin.setText("");
				tfPassword.setText("");
				setVisible(false);
			}
		});
	}
}
