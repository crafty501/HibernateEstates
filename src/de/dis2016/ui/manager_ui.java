package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.dis2011.data.IDB2;
import de.dis2016.model.Makler;

public class manager_ui extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	JButton _neu;
	JButton _speichern;
	JButton _ende;
	JTextField _name_ed,_vorname_ed,_adresse_ed,_login_ed;
	JPasswordField _password_ed;
	JList<String> _liste;
	List<Makler> _makler_list;
	DefaultListModel<String> _listModel;
	private IDB2 db;
	
	public manager_ui(IDB2 db){
		super();
		this.db = db;
		//Alle Markler, die in der Datenbank sind auf die Gui schmeissen
		this._makler_list = db.getMarklers();
		
		this.setLayout(new BorderLayout());
		JPanel Eingabe 	= this.Generate_Eingabefelder();
		JPanel Leiste 	= this.ButtonLeiste();
		JPanel Liste	= this.Generate_Liste();
		this.add(Eingabe,BorderLayout.CENTER);
		this.add(Leiste,BorderLayout.SOUTH);
		this.add(Liste,BorderLayout.EAST);
		this.setSize(800, 400);
		this.setResizable(false);
		this.setTitle("Manage Estate Managers");
		//Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the nfalseew location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the window
        this.setLocation(x, y);
        
        this.UpdateUI();
	}
	
	private void UpdateUI(){
		_listModel.clear();
	
		if(_makler_list.size() == 0){
			// Die MarklerListe ist noch komplett leer
			System.out.println("MaklerListe ist noch komplett leer");
		}else{
			_makler_list = db.getMarklers();
			for(int i = 0 ; i < _makler_list.size(); i++){
				Makler m = (Makler) _makler_list.get(i);
				_listModel.addElement(i + "-" + m.getName() + "-" + m.getLogin());
			}
		}
	}
	
	private JPanel Generate_Eingabefelder(){
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
            	BorderFactory.createTitledBorder("Datensatz"),
            	BorderFactory.createEmptyBorder(5,5,5,5)),
            	main.getBorder()));
		main.setSize(500,600);
		main.setLayout(new GridLayout(9,1));
		
		JPanel box = new JPanel();
		box.setLayout(new BorderLayout());
		JLabel label_1 = new JLabel();
		label_1.setText("Name:");
		_name_ed = new JTextField();
		_name_ed.setSize(120,12);
		box.add(label_1,BorderLayout.NORTH);
		box.add(_name_ed,BorderLayout.CENTER);
		main.add(box);
		
		JPanel box_3 = new JPanel();
		box_3.setLayout(new BorderLayout());
		JLabel label_12 = new JLabel();
		label_12.setText("Adresse:");
		_adresse_ed = new JTextField();
		_adresse_ed.setSize(120,12);
		box_3.add(label_12,BorderLayout.NORTH);
		box_3.add(_adresse_ed,BorderLayout.CENTER);
		main.add(box_3);
		
		JPanel box_8 = new JPanel();
		box_8.setLayout(new BorderLayout());
		JLabel label_8 = new JLabel();
		label_8.setText("Login:");
		_login_ed = new JTextField();
		box_8.add(label_8,BorderLayout.NORTH);
		box_8.add(_login_ed,BorderLayout.CENTER);
		main.add(box_8);
		
		JPanel box_7 = new JPanel();
		box_7.setLayout(new BorderLayout());
		JLabel label_6 = new JLabel();
		label_6.setText("Password:");
		_password_ed = new JPasswordField();
		box_7.add(label_6,BorderLayout.NORTH);
		box_7.add(_password_ed,BorderLayout.CENTER);
		main.add(box_7);
		
		return main;
	}
	
	private JPanel ButtonLeiste(){
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		
		_neu 		= new JButton();
		_neu.setText("Save as new");
		_neu.addActionListener(this);
		_speichern 	= new JButton();
		_speichern.setText("Update");
		_speichern.addActionListener(this);
		_ende		= new JButton();
		_ende.setText("Beenden");
		_ende.addActionListener(this);

		main.add(_neu);
		main.add(_speichern);
		main.add(_ende);
		return main;
	}
	
	private JPanel Generate_Liste(){	
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
            	BorderFactory.createTitledBorder("Estate Agents"),
                BorderFactory.createEmptyBorder(5,5,5,5)),
            	main.getBorder()));
		_listModel = new DefaultListModel<String>();
		_liste = new JList<String>(_listModel);
		_liste.addMouseListener(this);
		_liste.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JScrollPane listScroller = new JScrollPane(_liste);
		listScroller.setPreferredSize(new Dimension(400, 250));
		
		main.add(listScroller);
		return main;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object source = arg0.getSource();
		System.out.println(source.toString());
		if(source.equals(_ende)){
			this.setVisible(false);
		}
		
		if(source.equals(_neu)){
			
			String Name 	= _name_ed.getText();
			String Adresse 	= _adresse_ed.getText();
			String Login	= _login_ed.getText();
			
			char[] Password = _password_ed.getPassword();
			String pass = new String(Password);
			
			Makler m = new Makler();
			m.setLogin(Login);
			m.setPassword(pass);
			m.setName(Name);
			m.setAddress(Adresse);
			
			db.addMakler(m);
			this._makler_list.add(m);
			this.UpdateUI();
		}
		
		if(source.equals(_speichern)){
			int index = _liste.getSelectedIndex();
			String old_values = _listModel.getElementAt(index);
			
			String[] split = old_values.split("-");
			String login_old = split[2];
			
			Makler m = new Makler();
			for(int i=0; i < _makler_list.size();i++ ){
				if(login_old.equals(_makler_list.get(i).getLogin())){
					m = _makler_list.get(i);
				}
			};
			
			m.setAddress(this._adresse_ed.getText());
			//m.setLogin(this._login_ed.getText());
			m.setName(this._name_ed.getText());
			m.setPassword(this._password_ed.getPassword().toString());
					
			db.updateMakler(m);
			this.UpdateUI();
		}
		
		if (source.equals(_liste)){
			int index = _liste.getSelectedIndex();
			System.out.println(index);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source.equals(_liste)){
			int index = _liste.getSelectedIndex();
			
			if( index != -1 ){ // Die Gui ist dann noch leer
				
				String ListElement = (String) _listModel.getElementAt(index);
				String[] split = ListElement.split("-");
				String Login = split[2];
			
				Makler m = db.getMakler(Login);
		
				assert m != null : "Der Makler konnte nicht aus der Datenbank gelesen werden.";
			
				String Name 		= m.getName();
				String Adresse 		= m.getAddress();
				String Loginname 	= m.getLogin();
				String Passwort     = m.getPassword().toString();
			
				_name_ed.setText(Name);
				_adresse_ed.setText(Adresse);
				_login_ed.setText(Loginname);
				_password_ed.setText(Passwort);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
