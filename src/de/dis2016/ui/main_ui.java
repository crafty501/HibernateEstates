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

public class main_ui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _estate_agents,_estates,_contracts,_exit;
	private manager_ui _manager_ui;
	private login_ui _login_ui;
	
	private JPanel ButtonLeiste(){
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Hauptmen�"),
                        BorderFactory.createEmptyBorder(5,5,5,5)),
        main.getBorder()));
		
		
		 _estate_agents = new JButton();
		 _estate_agents.setText("Manage Estate Agents");
		 _estate_agents.addActionListener(this);
		main.add(_estate_agents);
		
		_estates = new JButton();
		 _estates.setText("Login to Manage Estates");
		 _estates.addActionListener(this);
		main.add(_estates);
		
		
		_contracts = new JButton();
		_contracts.setText("Login to Manage Estates");
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
	
		this._manager_ui = new manager_ui();
		this._login_ui = new login_ui();
		
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
        int w = this.getSize().width;
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
				_manager_ui.setVisible(true);
		}
		
		if(source.equals(_estates)){
				_login_ui.setVisible(true);
		}
		
		if(source.equals(_exit)){
			System.exit(0);
		}
		
	}
}
