package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.dis2011.data.IDB2;
import de.dis2011.data.ImmoService;
import de.dis2016.presenter.EstatesPresenter;
//import de.dis2016.presenter.EstatesPresenter;
//import de.dis2016.presenter.ContractsPresenter;

public class main_ui extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton _estate_agents,_estates,_contracts,_exit;
	private EstatesFrame estates;
	private ContractsFrame contracts;
	private IDB2 db;
	
	private JPanel ButtonLeiste(){
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
            	BorderFactory.createTitledBorder("Hauptmen�"),
                BorderFactory.createEmptyBorder(5,5,5,5)),
            	main.getBorder()));
		
		_estate_agents = new JButton();
		_estate_agents.setText("Estate Agents");
		_estate_agents.addActionListener(this);
		main.add(_estate_agents);
		
		_estates = new JButton();
		_estates.setText("Estates");
		_estates.addActionListener(this);
		main.add(_estates);
		
		_contracts = new JButton();
		_contracts.setText("Persons and contracts");
		_contracts.addActionListener(this);
		main.add(_contracts);
		
		_exit = new JButton();
		_exit.setText("Exit");
		_exit.addActionListener(this);
		main.add(_exit);
		
		return main;
	}
	
	public main_ui(){
		super();
		db = new ImmoService();
		
		estates = new EstatesFrame(db);
		estates.setPresenter(new EstatesPresenter(estates,db));
		
		contracts = new ContractsFrame(db);
		//contracts.setPresenter(new ContractsPresenter(contracts,db));
		
		this.setLayout(new BorderLayout());
		JPanel menue = this.ButtonLeiste();
	
		this.add(menue);
		this.setSize(200, 100);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("Hauptmenu");
		
		//Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int h = this.getSize().height;
        int x = 100;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source.equals(_estate_agents)){		
			LoginFrame2 login = new LoginFrame2(db);	
			login.setVisible(true);	
		}
		
		if(source.equals(_estates)){
			estates.setVisible(true);
		}
		
		if(source.equals(_contracts)){
			contracts.setVisible(true);
		}
		
		if(source.equals(_exit)){
			System.exit(0);
		}
		
	}
}
