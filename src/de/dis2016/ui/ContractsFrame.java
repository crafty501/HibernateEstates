package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.dis2011.data.IDB2;
import de.dis2016.presenter.ContractsPresenter;

public class ContractsFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private ContractsPresenter presenter;
	private JButton newPersonButton;
	private JButton ContractButton;
	private JButton exitButton;
//	private JTable contracts = new JTable();
	private JPanel contractPanel;
	private JPanel createPerson;
	private IDB2 db;
	
	public ContractsFrame(final IDB2 db){
		super();
		this.db = db;
		this.setLayout(new BorderLayout());
		this.setSize(800, 800);
		this.setMinimumSize(new Dimension(800, 800));
		this.setResizable(true);
		this.setTitle("Persons and contracts");
		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
			
		newPersonButton = new JButton("New person");
		ContractButton = new JButton("Contracts");
		exitButton = new JButton("Exit");
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(newPersonButton);
		pnlButtons.add(ContractButton);
		
		JPanel pnl2Buttons = new JPanel();
		pnl2Buttons.setLayout(new FlowLayout());
		pnl2Buttons.add(exitButton);
		
		this.add(pnlButtons, BorderLayout.NORTH);
		this.add(pnl2Buttons, BorderLayout.SOUTH);

		newPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createPerson = new CreatePerson(db);
				add(createPerson, BorderLayout.CENTER);
				if(contractPanel != null){
					contractPanel.setVisible(false);
				}
				createPerson.setVisible(true);
			}
		});
		ContractButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contractPanel = new ContractsPanel(db);
				add(contractPanel, BorderLayout.CENTER);
				if(createPerson != null){
					createPerson.setVisible(false);	
				}
				contractPanel.setVisible(true);
				
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});			
	}
	public void setPresenter(ContractsPresenter pres) {
		presenter = pres;
	}
}
