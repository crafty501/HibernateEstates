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

public class login_ui extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton _abbrechen;
	JButton _weiter;
	private JPanel Generate_Eingabefelder(){
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Sicherheitsabfrage"),
                        BorderFactory.createEmptyBorder(5,5,5,5)),
        main.getBorder()));
		main.setLayout(new GridLayout(2,1));
		
		JPanel box = new JPanel();
		box.setLayout(new BorderLayout());
		JLabel label_1 = new JLabel();
		label_1.setText("Login:");
		JTextField name_ed = new JTextField();
		name_ed.setSize(120,12);
		box.add(label_1,BorderLayout.NORTH);
		box.add(name_ed,BorderLayout.CENTER);
		main.add(box);
		
		JPanel box_2 = new JPanel();
		box_2.setLayout(new BorderLayout());
		box_2.setBackground(new Color(255,255,255));
		JLabel label_2 = new JLabel();
		label_2.setText("Passwort:");
		JPasswordField vorname_ed = new JPasswordField();
		vorname_ed.setSize(120,12);
		box_2.add(label_2,BorderLayout.NORTH);
		box_2.add(vorname_ed,BorderLayout.SOUTH);
		main.add(box_2);
			
		return main;
		
	}
	
	private JPanel ButtonLeiste(){
	
		
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		
		//Neu
		_abbrechen 		= new JButton();
		_abbrechen.setText("Abbrechen");
		_abbrechen.addActionListener(this);
		_weiter 	= new JButton();
		_weiter.setText("Login");
		_weiter.addActionListener(this);
		main.add(_abbrechen);
		main.add(_weiter);
		return main;
	}
	
	public login_ui(){
		super();
		this.setLayout(new BorderLayout());
		
		
		JPanel Eingabe 	= this.Generate_Eingabefelder();
		JPanel Leiste 	= this.ButtonLeiste();
		this.add(Eingabe,BorderLayout.CENTER);
		this.add(Leiste,BorderLayout.SOUTH);
		this.setSize(300, 170);
		this.setMinimumSize(new Dimension(300,170));
		this.setResizable(false);
		this.setTitle("Login");
		//Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object source = arg0.getSource();
		
		if(source.equals(_abbrechen)){
			this.setVisible(false);
		}
		
		
		
		
	}
}
