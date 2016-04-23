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
import javax.swing.JTextField;

import de.dis2016.model.House;
import de.dis2016.presenter.EstatesPresenter;

public abstract class AbstractEstateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton abbrechen;
	protected JButton weiter;


	public AbstractEstateFrame() {
		super();

		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		this.setSize(300, 400);
		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
		
		
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		
		
		// Buttons **************************************
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());

		abbrechen = new JButton();
		abbrechen.setText("Abbrechen");
		weiter = new JButton();
		
		pnlButtons.add(abbrechen);
		pnlButtons.add(weiter);

		
		this.setLayout(new BorderLayout());
		this.add(pnlButtons, BorderLayout.SOUTH);

		abbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		
	}
}
