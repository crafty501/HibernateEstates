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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.dis2016.presenter.ContractsPresenter;
import de.dis2016.presenter.EstatesPresenter;

public class ContractsFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private ContractsPresenter presenter;
	
	private JButton newPersonButton;
	private JButton newContractButton;
	private JButton allContractButton;
	
	private JTable contracts = new JTable();
	
	public ContractsFrame(){
	super();
	
	this.setLayout(new BorderLayout());
	this.setSize(800, 600);
	this.setMinimumSize(new Dimension(800, 600));
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
		newContractButton = new JButton("New contract");
		allContractButton = new JButton("Show all contracts");
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(newPersonButton);
		pnlButtons.add(newContractButton);
		pnlButtons.add(allContractButton);
		
		this.add(pnlButtons, BorderLayout.NORTH);
		
		this.add(new JScrollPane(contracts), BorderLayout.CENTER);

		//newPersonButton.setEnabled(false);
		//newContractButton.setEnabled(false);
		//allContractButton.setEnabled(false);
		
		contracts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		contracts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}
				System.out.println(contracts.getSelectedRow());
			}
		});
		newPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new LoginFrame(presenter);
			}
		});
		newContractButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new LoginFrame(presenter);
			}
		});
		allContractButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new LoginFrame(presenter);
			}
		});
		
	}
	public void setPresenter(ContractsPresenter pres) {
		presenter = pres;
	}
}
