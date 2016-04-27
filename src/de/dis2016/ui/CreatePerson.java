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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.dis2011.data.DB2;
import de.dis2011.data.DB2ConnectionManager;
import de.dis2011.data.Person;

public class CreatePerson extends JPanel implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	
	JButton _neu;
	JButton _speichern;
	JButton _ende;
	JCheckBox cbTenancy;
	JTextField tfFirstName, tfName, tfAdress;
	JList _liste;
	ArrayList<Person> _person_list;
	DefaultListModel<String> _listModel;
	
	
	private void UpdateUI(){
	_listModel.clear();
	
	if(_person_list.size() == 0){
		
		// Die MarklerListe ist noch komplett leer
		System.out.println("Personenliste ist noch komplett leer");
		
	}else{
		DB2 db = new DB2();
		_person_list = db.Gib_alle_Person();
		for(int i = 0 ; i < _person_list.size(); i++){
			Person m = (Person) _person_list.get(i);
			_listModel.addElement(m.getID() + "-" + m.getFirstName() + " " + m.getName());
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
		
		JPanel box_1 = new JPanel();
		box_1.setLayout(new BorderLayout());
		JLabel label_1 = new JLabel();
		label_1.setText("First name:");
		tfFirstName = new JTextField();
		tfFirstName.setSize(120,12);
		box_1.add(label_1,BorderLayout.NORTH);
		box_1.add(tfFirstName,BorderLayout.CENTER);
		main.add(box_1);
		
		JPanel box_2 = new JPanel();
		box_2.setLayout(new BorderLayout());
		JLabel label_2 = new JLabel();
		label_2.setText("Name:");
		tfName = new JTextField();
		tfName.setSize(120,12);
		box_2.add(label_2,BorderLayout.NORTH);
		box_2.add(tfName,BorderLayout.CENTER);
		main.add(box_2);
		
		JPanel box_4 = new JPanel();
		box_4.setLayout(new BorderLayout());
		JLabel label_4 = new JLabel();
		label_4.setText("Adress:");
		tfAdress = new JTextField();
		box_4.add(label_4,BorderLayout.NORTH);
		box_4.add(tfAdress,BorderLayout.CENTER);
		main.add(box_4);
			
		return main;
		
	}
	
	private JPanel ButtonLeiste(){
		
		
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		
		//Neu
		_neu 		= new JButton();
		_neu.setText("Save as new");
		_neu.addActionListener(this);
		_speichern 	= new JButton();
		_speichern.setText("Update");
		_speichern.addActionListener(this);

		main.add(_neu);
		main.add(_speichern);
		return main;
	}
	
	
	private JPanel Generate_Liste(){
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Personen"),
                        BorderFactory.createEmptyBorder(5,5,5,5)),
        main.getBorder()));
		_listModel = new DefaultListModel<String>();
		_liste = new JList(_listModel);
		_liste.addMouseListener(this);
	//	_liste.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_liste.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//_liste.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(_liste);
		listScroller.setPreferredSize(new Dimension(400, 250));
		
		main.add(listScroller);
		return main;
	}
	
	public CreatePerson(){
		super();
		
		//Alle Markler, die in der Datenbank sind auf die Gui schmeissen
		DB2 db = new DB2();
		this._person_list = db.Gib_alle_Person();
		
		
		this.setLayout(new BorderLayout());
		JPanel Eingabe 	= this.Generate_Eingabefelder();
		JPanel Leiste 	= this.ButtonLeiste();
		JPanel Liste	= this.Generate_Liste();
		this.add(Eingabe,BorderLayout.CENTER);
		this.add(Leiste,BorderLayout.SOUTH);
		this.add(Liste,BorderLayout.EAST);
		this.setSize(800, 400);
		//this.setResizable(false);
		//this.setTitle("Manage Estate Managers");
		//Get the size of the screen
     //   Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the nfalseew location of the window
     //   int w = this.getSize().width;
     //   int h = this.getSize().height;
     //   int x = (dim.width-w)/2;
     //   int y = (dim.height-h)/2;
        // Move the window
     //   this.setLocation(x, y);
        
        this.UpdateUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object source = arg0.getSource();
		System.out.println(source.toString());
		if(source.equals(_ende)){
			this.setVisible(false);
		}
		
		if(source.equals(_neu)){
			
			String firstName 	= tfFirstName.getText();
			String name 	= tfName.getText();
			String adress	= tfAdress.getText();
			
			Person m = new Person();
			m.setFirstName(firstName);
			m.setName(name);
			m.setAdress(adress);
			
			DB2 db = new DB2();
			db.Save_new_Person(m);
			this._person_list.add(m);
			this.UpdateUI();
		}
		
		if(source.equals(_speichern)){
			DB2 db = new DB2();
			String firstName 	= this.tfFirstName.getText();
			String name 	= this.tfName.getText();
			String adress	= this.tfAdress.getText();
			
			Person m = new Person();
			m.setFirstName(firstName);
			m.setName(name);
			m.setAdress(adress);
			int index = _liste.getSelectedIndex();
			String old_values = _listModel.getElementAt(index);
			
			String[] split = old_values.split("-");
			int id = Integer.parseInt(split[0]);
		
			
			db.Save_existing_Person(m,id);
		
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
			
			DB2 db = new DB2();
			
			System.out.println(index);
			
			
			if( index != -1 ){ // Die Gui ist dann noch leer
				
				String old_values = _listModel.getElementAt(index);
			
				String[] split = old_values.split("-");
				int id = Integer.parseInt(split[0]);
				Person m = db.Gib_Person(id);
				
		
				assert m != null : "Die Person konnte nicht aus der Datenbank gelesen werden.";
			
				String firstName 	= m.getFirstName();
				String name 		= m.getName();
				String adress 	= m.getAdress();
			
				tfFirstName.setText(firstName);
				tfName.setText(name);
				tfAdress.setText(adress);
			}
		
		}
		
		
		
		
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}