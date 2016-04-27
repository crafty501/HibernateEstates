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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import de.dis2016.model.Contract;
import de.dis2011.data.Contractsdb;


public class ContractsPanel extends JPanel implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	
	JButton _neu;
	JButton _speichern;
	JButton _ende;
	//JTextField _name_ed,_vorname_ed,_adresse_ed,_login_ed;
	JCheckBox cbTenancy;
	JTextField tfID, tfDate, tfPlace, tfStartDate, tfDuration, tfAdditionalCosts, tfNoOfInstallments, tfIntrestRate;
	JList _liste;
	ArrayList<Contractsdb> _contract_list;
	DefaultListModel<String> _listModel;
	
	
	private void UpdateUI(){
	_listModel.clear();
	
	if(_contract_list.size() == 0){
		
		// Die MarklerListe ist noch komplett leer
		System.out.println("Contract ist noch komplett leer");
		
	}else{
	//	DB2 db = new DB2();
//		_contract_list = db.Gib_alle_Contracts();
		for(int i = 0 ; i < _contract_list.size(); i++){
	//		Contractsdb m = (Contractsdb) _contract_list.get(i);
	//		_listModel.addElement(i + "-" + m.getPlace());
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
		//main.setLayout(new Bt());
		main.setLayout(new GridLayout(9,1));
		
		JPanel box = new JPanel();
		box.setLayout(new BorderLayout());
		JLabel label = new JLabel();
		label.setText("Tenancy:");
		cbTenancy = new JCheckBox();
		//c.setSize(120,12);
		box.add(label,BorderLayout.NORTH);
		box.add(cbTenancy,BorderLayout.CENTER);
		main.add(box);
		
		JPanel box_1 = new JPanel();
		box_1.setLayout(new BorderLayout());
		JLabel label_1 = new JLabel();
		label_1.setText("Date:");
		tfDate = new JTextField();
		tfDate.setSize(120,12);
		box_1.add(label_1,BorderLayout.NORTH);
		box_1.add(tfDate,BorderLayout.CENTER);
		main.add(box_1);
		
		JPanel box_2 = new JPanel();
		box_2.setLayout(new BorderLayout());
		JLabel label_2 = new JLabel();
		label_2.setText("Place:");
		tfPlace = new JTextField();
		tfPlace.setSize(120,12);
		box_2.add(label_2,BorderLayout.NORTH);
		box_2.add(tfPlace,BorderLayout.CENTER);
		main.add(box_2);
		
		JPanel box_4 = new JPanel();
		box_4.setLayout(new BorderLayout());
		JLabel label_4 = new JLabel();
		label_4.setText("Start date:");
		tfStartDate = new JTextField();
		tfStartDate.setEditable(false);
		box_4.add(label_4,BorderLayout.NORTH);
		box_4.add(tfStartDate,BorderLayout.CENTER);
		main.add(box_4);
		
		JPanel box_5 = new JPanel();
		box_5.setLayout(new BorderLayout());
		JLabel label_5 = new JLabel();
		label_5.setText("Duration:");
		tfDuration = new JTextField();
		tfDuration.setEditable(false);
		box_5.add(label_5,BorderLayout.NORTH);
		box_5.add(tfDuration,BorderLayout.CENTER);
		main.add(box_5);
		
		JPanel box_6 = new JPanel();
		box_6.setLayout(new BorderLayout());
		JLabel label_6 = new JLabel();
		label_6.setText("Additional Costs:");
		tfAdditionalCosts = new JTextField();
		tfAdditionalCosts.setEditable(false);
		box_6.add(label_6,BorderLayout.NORTH);
		box_6.add(tfAdditionalCosts,BorderLayout.CENTER);
		main.add(box_6);
		
		JPanel box_7 = new JPanel();
		box_7.setLayout(new BorderLayout());
		JLabel label_7 = new JLabel();
		label_7.setText("No of installments:");
		tfNoOfInstallments = new JTextField();
		box_7.add(label_7,BorderLayout.NORTH);
		box_7.add(tfNoOfInstallments,BorderLayout.CENTER);
		main.add(box_7);
		
		JPanel box_8 = new JPanel();
		box_8.setLayout(new BorderLayout());
		JLabel label_8 = new JLabel();
		label_8.setText("Interest Rate:");
		tfIntrestRate = new JTextField();
		box_8.add(label_8,BorderLayout.NORTH);
		box_8.add(tfIntrestRate,BorderLayout.CENTER);
		main.add(box_8);
		
		cbTenancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTenancy.isSelected()) {
					tfNoOfInstallments.setEditable(false);
					tfIntrestRate.setEditable(false);
					tfStartDate.setEditable(true);
					tfDuration.setEditable(true);
					tfAdditionalCosts.setEditable(true);
				}else{
					tfNoOfInstallments.setEditable(true);
					tfIntrestRate.setEditable(true);
					tfStartDate.setEditable(false);
					tfDuration.setEditable(false);
					tfAdditionalCosts.setEditable(false);
				}
		    }
		});
		
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
                        BorderFactory.createTitledBorder("Contracts"),
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
	
	public ContractsPanel(){
		super();
		
		//Alle Markler, die in der Datenbank sind auf die Gui schmeissen
		DB2 db = new DB2();
		//this._contract_list = db.Gib_alle_Contracts();
		
		
		this.setLayout(new BorderLayout());
		JPanel Eingabe 	= this.Generate_Eingabefelder();
		JPanel Leiste 	= this.ButtonLeiste();
		JPanel Liste	= this.Generate_Liste();
		
		this.add(Eingabe,BorderLayout.CENTER);
		this.add(Leiste,BorderLayout.SOUTH);
		this.add(Liste,BorderLayout.EAST);
		this.setSize(800, 500);
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
        
      //  this.UpdateUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object source = arg0.getSource();
		System.out.println(source.toString());
		if(source.equals(_ende)){
			this.setVisible(false);
		}
		
		//Neuen Contract anlegen 
		if(source.equals(_neu)){
			
			
			
			SimpleDateFormat format 		= new SimpleDateFormat("dd.MM.yyyy");
			Date Date = null;
			long timestamp = 0;
			try {
				timestamp = format.parse(tfDate.getText()).getTime();
				Date 						= new Date(timestamp);
			
				System.out.println(Date.toString());
			} catch (ParseException e) {
				System.out.println("Kein richtiges Format");
				e.printStackTrace();
			}
			
			String Place 			= tfPlace.getText();
			Contractsdb c = new Contractsdb();
			
			c.setTenency(cbTenancy.isSelected());
			
			
			if(cbTenancy.isSelected()){			
				String start_date 		= tfStartDate.getText();
				String duration			= tfDuration.getText();
				String additional_costs = tfAdditionalCosts.getText();
				
				
				
				c.setDate(Date);
				c.setPlace(Place);
				c.setAdditionalCosts(Integer.parseInt(additional_costs));
				c.setDuration(Integer.parseInt(duration));
				try {
					c.setStartDate(new Date(format.parse(start_date).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else{
				String No_of_installments 	= tfNoOfInstallments.getText();
				String intrest_rate			= tfIntrestRate.getText();	 
				
				
				c.setDate(Date);
				c.setPlace(Place);
				c.setNoOfInstallments(Integer.parseInt(No_of_installments));
				c.setInterestRate(Integer.parseInt(intrest_rate));
				
			}
			c.Save_as_New();
			
			
		}
		
		if(source.equals(_speichern)){
/*			DB2 db = new DB2();
			String Adresse 	= this._adresse_ed.getText();
			String Name 	= this._name_ed.getText();
			String Login	= this._login_ed.getText();
			String Passwort = this._password_ed.getPassword().toString();
			
			Contractsdb m = new Contractsdb();
			m.setAddress(Adresse);
			m.setLogin(Login);
			m.setName(Name);
			m.setPassword(Passwort);
			int index = _liste.getSelectedIndex();
			String old_values = _listModel.getElementAt(index);
			
			String[] split = old_values.split("-");
			String Login_old = split[2];
		
			
			db.Save_existing_Contracts(m,Login_old);
		
			this.UpdateUI(); */
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
			
			/*
			if( index != -1 ){ // Die Gui ist dann noch leer
				
				String ListElement = (String) _listModel.getElementAt(index);
				String[] split = ListElement.split("-");
				String Login = split[2];
			
				Contractdb m = db.Gib_Makler(Login);
		
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
		*/
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


/*
public class ContractsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private final JCheckBox cbTenancy;
	private final JTextField tfID;
	private final JTextField tfDate;
	private final JTextField tfPlace;
	private final JTextField tfStartDate;
	private final JTextField tfDuration;
	private final JTextField tfAdditionalCosts;
	private final JTextField tfNoOfInstallments;
	private final JTextField tfIntrestRate;
	
	private final JLabel lbTenancy;
	private final JLabel lbID;
	private final JLabel lbDate;
	private final JLabel lbPlace;
	private final JLabel lbStartDate;
	private final JLabel lbDuration;
	private final JLabel lbAdditionalCosts;
	private final JLabel lbNoOfInstallments;
	private final JLabel lbIntrestRate;
	

	
	
	
	
	public ContractsPanel(){
		cbTenancy = new JCheckBox();
		tfID = new JTextField();
		tfDate = new JTextField();
		tfPlace = new JTextField();
		tfStartDate = new JTextField();
		tfDuration = new JTextField();
		tfAdditionalCosts = new JTextField();
		tfNoOfInstallments = new JTextField();
		tfIntrestRate = new JTextField();
		
		lbTenancy = new JLabel("Tenancy");
		lbID = new JLabel("ID");
		lbDate = new JLabel("Date");
		lbPlace = new JLabel("Place");
		lbStartDate = new JLabel("Start Date");
		lbDuration = new JLabel("Duration");
		lbAdditionalCosts = new JLabel("Additional Costs");
		lbNoOfInstallments = new JLabel("No of Installments");
		lbIntrestRate = new JLabel("Intrest Rate");
		
		tfNoOfInstallments.setEditable(true);
		tfIntrestRate.setEditable(true);
		tfStartDate.setEditable(false);
		tfDuration.setEditable(false);
		tfAdditionalCosts.setEditable(false);
		
		
		
		setLayout(new GridLayout(0, 2));
		add(lbTenancy);
		add(cbTenancy);
		add(lbID);
		add(tfID);
		add(lbDate);
		add(tfDate);
		add(lbPlace);
		add(tfPlace);
		add(lbStartDate);
		add(tfStartDate);
		add(lbDuration);
		add(tfDuration);
		add(lbAdditionalCosts);
		add(tfAdditionalCosts);
		add(lbNoOfInstallments);
		add(tfNoOfInstallments);
		add(lbIntrestRate);
		add(tfIntrestRate);
		
		cbTenancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTenancy.isSelected()) {
					tfNoOfInstallments.setEditable(false);
					tfIntrestRate.setEditable(false);
					tfStartDate.setEditable(true);
					tfDuration.setEditable(true);
					tfAdditionalCosts.setEditable(true);
				}else{
					tfNoOfInstallments.setEditable(true);
					tfIntrestRate.setEditable(true);
					tfStartDate.setEditable(false);
					tfDuration.setEditable(false);
					tfAdditionalCosts.setEditable(false);
				}
		    }
		});		
		
	}	

}
*/
