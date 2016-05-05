package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.dis2011.data.IDB2;
import de.dis2016.model.Estate;
import de.dis2016.model.EstateTableModel;
import de.dis2016.model.Makler;
import de.dis2016.presenter.EstatesPresenter;

public class EstatesFrame extends JFrame {

	private static final long serialVersionUID = 1L;


	private EstatesPresenter presenter;

	String[] columnNames = { "ID", "City", "PostalCode" , "Street", "StreetNr." , "SquareArea" };
	
	Object[][] data =  { };
	private JTable estates = new JTable(data,columnNames);
	private JButton loginButton;
	private JButton createHouseButton;
	private JButton createApartmentButton;
	private JButton deleteButton;
	private JButton modifyButton;

	private Makler makler;


	public EstatesFrame(IDB2 db) {
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

		loginButton = new JButton("login");
		createHouseButton = new JButton("new house");
		createApartmentButton = new JButton("new appartment");
		deleteButton = new JButton("delete");
		modifyButton = new JButton("modify");
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(createHouseButton);
		pnlButtons.add(createApartmentButton);
		pnlButtons.add(deleteButton);
		pnlButtons.add(modifyButton);
		pnlButtons.add(loginButton);

		this.add(pnlButtons, BorderLayout.NORTH);

		this.add(new JScrollPane(estates), BorderLayout.CENTER);

		createHouseButton.setEnabled(false);
		createApartmentButton.setEnabled(false);
		deleteButton.setEnabled(false);
		modifyButton.setEnabled(false);

		estates.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		estates.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}
			}
		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(presenter);
			}
		});
		createHouseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CreateHouseFrame(presenter,makler);
			}
		});
		createApartmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateApartmentFrame(presenter,makler);
			}
		});
		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (estates.getSelectedRow() != -1) {
					Estate estate = ((EstateTableModel) estates.getModel()).getEstateAt(estates.getSelectedRow());
					new ModifyEstateFrame(presenter,makler, estate);	
				}
			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (estates.getSelectedRow() != -1) {
					Estate estate = ((EstateTableModel) estates.getModel()).getEstateAt(estates.getSelectedRow());
					new DeleteEstateFrame(presenter,makler, estate);
				}
			}
		});

	}

	public void setEstates(List<Estate> list) {
		createHouseButton.setEnabled(true);
		createApartmentButton.setEnabled(true);
		deleteButton.setEnabled(true);
		modifyButton.setEnabled(true);
		
		estates.setModel(new EstateTableModel(list));
		for(int i =0; i < columnNames.length; i++){
			estates.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
		}
		
	}

	public void setPresenter(EstatesPresenter pres) {
		presenter = pres;
	}

	public void setMakler(Makler makler) {
		this.makler = makler;
		
	}

}
